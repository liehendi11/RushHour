//
// General BestFirstSearch class.
//

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public abstract class BestFirstSearch implements Search {

    // Private variables

    private long nodesExpanded;
    private HashMap<Long, Action> explored = new HashMap<Long, Action>();
    private PQMapHybrid<Long, SearchNode> mapQueue = new PQMapHybrid<Long, SearchNode>();
    protected Heuristic heuristic;

    // Public methods

    public boolean run(State s, Cost cost, ArrayList<Action> solution) {
        // In case no heuristic is set.
        if (heuristic == null) {
            heuristic = new DefaultHeuristic();
        }

        // Initialization.
        heuristic.initialize(s);
        nodesExpanded = 0;
        boolean solved = false;

        // HashMap initialization.
        explored.clear();

        // PQMapHybrid initialization.
        long rootStateId = s.getStateID();
        int rootNodeScore = costFunction(0, s.getHeuristic());
        mapQueue.clear();
        mapQueue.offer(rootStateId, new SearchNode(rootNodeScore, rootStateId));

        while (true) {
            // Checks for failure.
            if (mapQueue.isEmpty()) {
                break;
            }

            // Polls until it finds a proper SearchNode.
            long currentStateId;
            SearchNode wrapper;
            do {
                if (mapQueue.isEmpty()) {
                    assert false : "Should not happen.";
                    // Just in case there are no solutions.
                    return false;
                }
                wrapper = mapQueue.poll();
                currentStateId = wrapper.getStateId();

                // If the mapQueue does not contain the state ID, we cannot use it.
            } while (!mapQueue.containsKey(currentStateId));

            // Tells the HQMapHybrid that this state "is not" in the queue, even though it might
            // still exist in the priority queue.
            mapQueue.remove(wrapper.getStateId());

            int currentGScore = wrapper.getGScore();
            s.setState(currentStateId);
            explored.put(currentStateId, wrapper.getAction());
            if (s.isGoal()) {
                solved = true;
                break;
            }
            nodesExpanded++;
            ArrayList<Action> actions = new ArrayList<Action>();
            s.getActions(actions);
            for (Action action : actions) {
                // Calculates the cost of this action before the action is made.
                int distToNeighbour = s.getCost(action);
                s.make(action);

                // When we have made the move to the neighbour we can retrieve heuristic data and
                // calculate the F-score.
                int neighbourGScore = currentGScore + distToNeighbour;
                int neighbourHScore = heuristic.estimateCost(s);
                int neighbourFScore = costFunction(neighbourGScore, neighbourHScore);

                long newStateId = s.getStateID();
                if (!explored.containsKey(newStateId)) {
                    SearchNode probed = mapQueue.get(newStateId);
                    if (probed == null) {
                        // Adds a new entry to both the hash map AND the priority queue.
                        mapQueue.offer(newStateId, new SearchNode(
                                neighbourFScore, neighbourGScore, newStateId, action));
                    } else if (probed.getGScore() > neighbourGScore) {
                        // Updates the entry in the hash map AND adds a new one to the priority queue.
                        mapQueue.offer(newStateId, new SearchNode(
                                neighbourFScore, neighbourGScore, newStateId, action));
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

            // This might not be the best way to retrieve the cost.
            for (Action action : solution) {
                cost.value += s.getCost(action);
                s.make(action);
            }
        }
        return solved;
    }

    public long getNodesExpanded() {
        return nodesExpanded;
    }

    /**
     *
     * @param neighbourGScore the G-score of the neighbour node - (cost(root, current) + cost(current, neighbour))
     * @param neighbourHScore the H-score of the neighbour - costEstimate(neighbour, goal).
     * @return f(neighbour)
     */
    public abstract int costFunction(int neighbourGScore, int neighbourHScore);

    public void setHeuristic(Heuristic heuristic) {
        this.heuristic = heuristic;
    }

}
