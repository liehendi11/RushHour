
// General BestFirstSearch class.

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

public abstract class BestFirstSearch implements Search {

    public static void main(String[] args) {
        PriorityQueue<SearchNode> queue = new PriorityQueue<SearchNode>();
        queue.offer(new SearchNode(10, 10, -1, new Action()));
        queue.offer(new SearchNode(10, 20, -1, new Action()));
        queue.offer(new SearchNode(10, 15, -1, new Action()));
        for (int i = 0; i < 3; i++) {
            SearchNode node = queue.poll();
            System.out.println("F: " + node.getFScore() + " / G: " + node.getGScore());
        }
    }

    // Private variables

    private long nodesExpanded;
    private HashMap<Long, Action> explored = new HashMap<Long, Action>();
    private PQMapHybrid<Long, SearchNode> mapQueue = new PQMapHybrid<Long, SearchNode>();

    // Public methods

    public boolean run(State s, Cost cost, ArrayList<Action> solution) {
        nodesExpanded = 0;
        boolean solved = false;

        // HashMap initialization.
        explored.clear();

        // Priority queue initialization.
        long rootStateId = s.getStateID();
        int rootNodeScore = initialFScore(s);
        mapQueue.clear();
        mapQueue.offer(rootStateId, new SearchNode(rootNodeScore, rootStateId));

        while (true) {
            if (mapQueue.isEmpty()) { // Checks for failure.
                break;
            }

            // Polls until it finds a proper SearchNode.
            SearchNode wrapper;
            do {
                if (mapQueue.isEmpty()) {
                    assert false : "Should not happen.";
                    // Just in case there are no solutions.
                    return false;
                }
                wrapper = mapQueue.poll();
                // We CANNOT use states that have already been processed.
            } while (explored.containsKey(wrapper.getStateId()));

            long currentStateId = wrapper.getStateId();
            int currentFScore = wrapper.getFScore();
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
                int neighbourHScore = s.getHeuristic();
                int neighbourFScore = costFunction(currentFScore, neighbourGScore, neighbourHScore);

                long newStateId = s.getStateID();
                if (!explored.containsKey(newStateId)) {
                    SearchNode probed = mapQueue.get(newStateId);
                    if (probed == null) {
                        // Adds a new entry to both the hash map AND the priority queue.
                        mapQueue.offer(newStateId, new SearchNode(neighbourFScore, neighbourGScore, newStateId, action));
                    } else if (probed.getGScore() > neighbourGScore) {
                        // Updates the entry in the hash map AND adds a new one to the priority queue.
                        // TODO: Uncommenting the next line actually lowers the node count from
                        // TODO: 127210 to 127152 - which is awfully fucked up.
                        mapQueue.getQueue().remove(probed);
                        mapQueue.offer(newStateId, new SearchNode(neighbourFScore, neighbourGScore, newStateId, action));
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

    public abstract int costFunction(int currentFScore, int neighbourGScore, int neighbourHScore);

    public abstract int initialFScore(State s);

}
