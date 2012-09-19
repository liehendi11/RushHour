
//
// Pure-Heuristic Search
//

import java.util.*;

public class SearchPureHeuristic implements Search {

    // Private variables

    private long nodesExpanded;
    private HashMap<Long, Action> explored = new HashMap<Long, Action>();
    private PQMapHybrid<Long, PHSState> mapQueue = new PQMapHybrid<Long, PHSState>();

    // Public methods

    public boolean run(State s, Cost cost, ArrayList<Action> solution) {
        nodesExpanded = 0;
        boolean solved = false;

        // HashMap initialization.
        explored.clear();

        // Priority queue initialization.
        long rootStateId = s.getStateID();
        mapQueue.clear();                                          // Clears the map-queue.
        mapQueue.offer(rootStateId, new PHSState(s.getHeuristic(), rootStateId));

        while (true) {
            if (mapQueue.isEmpty()) {                              // Checks for failure.
                break;
            }

            // Retrieve the UCSState.
            PHSState wrapper;
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
            int currentCost      = wrapper.getHeuristic();
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
                s.make(action);
                int totalCostOfAction = currentCost + s.getHeuristic();
                long newStateId = s.getStateID();
                if (!explored.containsKey(newStateId)) {
                    PHSState probed = mapQueue.get(newStateId);
                    if (probed == null) {
                        // Adds a new entry to both the hash map AND the priority queue.
                        mapQueue.offer(newStateId, new PHSState(totalCostOfAction, newStateId, action));
                    } else if (probed.getHeuristic() > totalCostOfAction) {
                        // Updates the entry in the hash map AND adds a new one to the priority queue.
                        // TODO: Uncommenting the next line actually lowers the node count from
                        // TODO: 127210 to 127152 - which is awfully fucked up.
                        // mapQueue.getQueue().remove(probed);
                        mapQueue.offer(newStateId, new PHSState(totalCostOfAction, newStateId, action));
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

class PHSState implements Comparable<PHSState> {

    private int heuristic;
    private long stateId;
    private Action action;

    public PHSState(int cost, long stateId) {
        this(cost, stateId, null);
    }

    public PHSState(int cost, long stateId, Action action) {
        this.heuristic = cost;
        this.stateId = stateId;
        this.action = action;
    }

    public int getHeuristic() {
        return heuristic;
    }

    public void setHeuristic(int cost) {
        this.heuristic = cost;
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

    public int compareTo(PHSState other) {
        if (this.heuristic > other.heuristic) {
            return 1;
        } else if (this.heuristic < other.heuristic) {
            return -1;
        }
        return 0;
    }

    public boolean equals(UCSState other) {
        return this.stateId == other.getStateId();
    }

}