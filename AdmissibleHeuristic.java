public class AdmissibleHeuristic implements Heuristic {

    // Types

    enum ExitPosWall { NORTH, EAST, SOUTH, WEST }

    // Private variables

    private ExitPosWall exitPosWall;
    private GridPos exitPos;
    private RushHourCar red;
    private RushHourCar.Orientation redOrientation;
    private int numberOfCars;

    private RushHourState state;
    private GridPos redPos;
    private int lower, upper;
    private RushHourGrid grid;

    // Public functions

    public void initialize(State s) {
        // Does one-time initialization.

        // First off the exit position.
        RushHourState state = (RushHourState) s;
        exitPos = state.exitPos;
        if (exitPos.getCol() == 0) exitPosWall = ExitPosWall.WEST;      // TODO: Fixed board size.
        if (exitPos.getCol() == 7) exitPosWall = ExitPosWall.EAST;
        if (exitPos.getRow() == 0) exitPosWall = ExitPosWall.NORTH;
        if (exitPos.getRow() == 7) exitPosWall = ExitPosWall.SOUTH;

        // Number of cars.
        numberOfCars = state.cars.size();

        // A reference to the red car.
        red = state.cars.get(0);
        redOrientation = red.getOrientation();
    }

    public int estimateCost(State s) {
        state = (RushHourState) s;
        grid = state.grid.merge(state.cars);

        // The position of the red car.
        redPos = red.getHead();

        // Find the start and end positions of the path between the red car and the exit.
        // NOTE: This has side effects - updates upper and lower member variables.
        findBlockingPath();

        // (Step 1) Loop through each of the other cars and check if any one of them is in the path,
        // if a car is in the path, we want to find the MINIMUM cost it would take for us to move
        // him out of the path.
        int cost = 0;
        for (int i = 1; i < numberOfCars; i++) {
            RushHourCar car = state.cars.get(i);
            if (collidesWith(car, lower, upper)) {
                //System.out.println("Cost of moving car: " + carIdToString(car.getCarId()));
                cost += getCostOfMoving(car);
            }
        }

        // (Step 2) Add the cost of moving the red car towards the goal.
        cost += Math.abs(upper - lower) + 2;

        return cost;
    }

    private int getCostOfMoving(RushHourCar car) {
        int minCost = Integer.MAX_VALUE;

        int col = car.getHead().getCol(), row = car.getHead().getRow();

        if (car.getOrientation() == RushHourCar.Orientation.VERTICAL) {
            int endRow = row + car.getLength() - 1;
            int maxUp = 1 - row, maxDown = 6 - endRow; // TODO: Fixed board size.

            for (int i = maxUp; i <= maxDown; i++) {
                // It does not make sense to move the car 0 up/down:
                if (i == 0) continue;
                car.move(i);
                if (collidesWith(car, lower, upper)) {
                    car.move(-i);
                } else {
                    //System.out.println("> Moving car: " + i);
                    // Adds the cost of just moving the car.
                    int cost = Math.abs(i);

                    // Add the cost of moving the cars that are in the way.
                    car.move(-i);
                    for (int y = row + i; y <= endRow + i; y++) {
                        if (grid.isCar(col, y) && (y < row || y > endRow)) {
                            //System.out.println(String.format("(%d, %d) is car!", col, y));
                            cost += 1;
                        }
                    }
                    minCost = Math.min(minCost, cost);
                }
            }

        } // TODO: else { }

        return minCost;
    }

    private boolean collidesWith(RushHourCar car, int lower, int upper) {
        if (car.getOrientation() == redOrientation) {
            return false;
        }
        if (car.getOrientation() == RushHourCar.Orientation.HORIZONTAL) {
            // The red is vertical.
            // TODO: this.
        } else if (car.getOrientation() == RushHourCar.Orientation.VERTICAL) {
            // The red is horizontal.
            int col = car.getHead().getCol(), row = car.getHead().getRow();
            if (redPos.getRow() >= row && redPos.getRow() <= (row + car.getLength() - 1)
                    && col >= lower && col <= upper) {
                return true;
            }
        } else {
            assert false;
        }
        return false;
    }

    // Private functions

    private void findBlockingPath() {
        if (redOrientation == RushHourCar.Orientation.HORIZONTAL) {
            if (exitPosWall == ExitPosWall.EAST) {
                lower = redPos.getCol() + red.getLength();
                upper = 6; // TODO: fixed.
            } // TODO: else { }
        } // TODO: else { }
        assert lower != 0 && upper != 0 : "lower/upper cannot be 0.";
    }

    // For debugging purposes

    public static char carIdToString(int id) {
        id += 65;
        return (char) id;
    }

    public static void main(String[] args) {
        String file = "puzzle00.rh";
        State s = RushHourState.createFromFile(file);
        s.draw();

        AdmissibleHeuristic dev = new AdmissibleHeuristic();
        dev.initialize(s);
        System.out.println("Cost estimate: " + dev.estimateCost(s));
    }

}
