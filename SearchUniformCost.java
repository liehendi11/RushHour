
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
    //private PriorityQueue<UCSState> queue = new PriorityQueue<UCSState>();
    private HashMap<Long, Action> explored = new HashMap<Long, Action>();
    private PQMapHybrid<Long, UCSState> mapQueue = new PQMapHybrid<Long, UCSState>();

    // Public methods

    public boolean run(State s, Cost cost, ArrayList<Action> solution) {
        nodesExpanded = 0;
        boolean solved = false;

        // HashMap initialization.
        explored.clear();

        // Priority queue initialization.
        long rootStateId = s.getStateID();
        mapQueue.clear();                                          // Clears the map-queue.
        mapQueue.offer(rootStateId, new UCSState(0, rootStateId)); // Adds the root to the map-queue.

        while (true) {
            if (mapQueue.isEmpty()) {                              // Checks for failure.
                break;
            }

            // Retrieve the UCSState.
            UCSState wrapper;
            do {
                if (mapQueue.isEmpty()) {
                    assert false : "Should not happen.";
                    // Just in case there are no solutions.
                    return false;
                }
                wrapper = mapQueue.poll();
                // We CANNOT use states that have already been processed.
            } while (explored.containsKey(wrapper.getStateId()));

            long currentStateId  = wrapper.getStateId();
            int currentCost      = wrapper.getCost();
            s.setState(currentStateId);                                // Apply the state.
            explored.put(currentStateId, wrapper.getAction());
            if (s.isGoal()) {                                   // Check if this is a goal state.
                solved = true;
                break;
            }
            nodesExpanded++;
            ArrayList<Action> actions = new ArrayList<Action>();
            s.getActions(actions);
            for (Action action : actions) {
                int totalCostOfAction = currentCost + s.getCost(action);
                s.make(action);
                long newStateId = s.getStateID();
                if (!explored.containsKey(newStateId)) {
                    UCSState probed = mapQueue.get(newStateId);
                    if (probed == null) {
                        // Adds a new entry to both the hash map AND the priority queue.
                        mapQueue.offer(newStateId, new UCSState(totalCostOfAction, newStateId, action));
                    } else if (probed.getCost() > totalCostOfAction) {
                        // Updates the entry in the hash map AND adds a new one to the priority queue.
                        // TODO: Uncommenting the next line actually lowers the node count from
                        // TODO: 127210 to 127152 - which is awfully fucked up.
                        // mapQueue.getQueue().remove(probed);
                        mapQueue.offer(newStateId, new UCSState(totalCostOfAction, newStateId, action));
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