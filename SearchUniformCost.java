
//
// Uniform Cost-Search
//

import java.util.*;

public class SearchUniformCost implements Search {

    public static void main(String[] args) {
        PriorityQueue<UCSState> queue = new PriorityQueue<UCSState>();
        queue.add(new UCSState(500, 0));
        queue.add(new UCSState(200, 1));
        queue.add(new UCSState(900, 2));
        for (int i = 0; i < 3; i++) {
            UCSState state = queue.poll();
            System.out.println("Cost: " + state.getCost());
        }
    }

    // Private variables

    private long nodesExpanded;
    private PriorityQueue<UCSState> queue = new PriorityQueue<UCSState>();
    private HashMap<Long, Action> explored = new HashMap<Long, Action>();

    // Public methods

    public boolean run(State s, Cost cost, ArrayList<Action> solution) {
        nodesExpanded = 0;
        boolean solved = false;

        // HashMap initialization.
        explored.clear();

        // Priority queue initialization.
        queue.clear();                                          // Clears the priority queue.
        queue.offer(new UCSState(0, s.getStateID()));           // Adds the root to the queue.

        while (true) {
            if (queue.isEmpty()) {                              // Checks for failure.
                break;
            }
            // Backups the last state id in case of the next state being a goal state.
            // long lastStateId = s.getStateID();

            // Retrieve the UCSState
            UCSState wrapper = queue.poll();                    // Retrieve the best looking state.
            long stateId = wrapper.getStateId();
            int tmpCost = wrapper.getCost();
            Action tmpAction = wrapper.getAction();             // TODO: Re-fucking-name.
            s.setState(stateId);                                // Apply the state.
            explored.put(stateId, tmpAction);
            if (s.isGoal()) {                                   // Check if this is a goal state.
                solved = true;
                break;
            }
            nodesExpanded++;
            ArrayList<Action> actions = new ArrayList<Action>();
            s.getActions(actions);
            for (Action action : actions) {
                int totalCostOfAction = tmpCost + s.getCost(action);
                s.make(action);
                long newStateId = s.getStateID();
                if (!explored.containsKey(newStateId)) {
                    UCSState queueElement = findElement(s);
                    if (queueElement == null) {                 // None found.
                        queue.offer(new UCSState(totalCostOfAction, newStateId, action));
                    } else if (queueElement.getCost() > totalCostOfAction) { // Some found but does it have higher cost?
                        queue.remove(queueElement);
                        queue.add(new UCSState(totalCostOfAction, newStateId, action));
                    }
                }
                s.retract(action);
            }

        }

        if (solved) {
            while (!s.isStart()) {
                Action action = explored.get(s.getStateID());
                solution.add(action);
                s.retract(action);
            }
            Collections.reverse(solution);

            // TODO: Okay. Is there any better way to retrieve the cost?
            //s.draw();
            for (Action action : solution) {
                //System.out.println();
                //System.out.println("Action: " + action.toStr());
                cost.value += s.getCost(action);
                s.make(action);
                //s.draw();
            }
        }
        return solved;
    }

    public UCSState findElement(State element) {
        long stateId = element.getStateID();
        for (UCSState s : queue) {
            if (s.getStateId() == stateId) {
                return s;
            }
        }
        return null; // None found.
    }

    public long getNodesExpanded() {
        return nodesExpanded;
    }

}

class UCSState implements Comparable<UCSState> {

    private int cost;
    private long stateId;
    private Action action;

    public UCSState(int cost, long stateId) {
        this(cost, stateId, null);
    }

    public UCSState(int cost, long stateId, Action action) {
        this.cost = cost;
        this.stateId = stateId;
        this.action = action;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public long getStateId() {
        return stateId;
    }

    public void setStateId(long stateId) {
        this.stateId = stateId;
    }

    public Action getAction() {
        return this.action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public int compareTo(UCSState other) {
        if (this.cost > other.cost) {
            return 1;
        } else if (this.cost < other.cost) {
            return -1;
        }
        return 0;
    }

    public boolean equals(UCSState other) {
        return this.stateId == other.getStateId();
    }

}