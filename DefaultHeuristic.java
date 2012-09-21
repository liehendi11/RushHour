
public class DefaultHeuristic implements Heuristic {

    public void initialize(State state) {
        // Do nothing.
    }

    public int estimateCost(State state) {
        return state.getHeuristic();
    }

}
