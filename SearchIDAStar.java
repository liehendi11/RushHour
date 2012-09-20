//
// IDAStar
//

import java.util.ArrayList;
import java.util.Collections;

class SearchIDAStar implements Search {

    // Private members

    private long nodesExpanded;
    private Heuristic1 heuristic = new Heuristic1();  // TODO: Change!

    // Public members

	public boolean run( State s, Cost cost, ArrayList<Action> solution )
    {
        heuristic.init(s);
        solution.clear();
        nodesExpanded = 0;
        boolean solved;
        int threshold = heuristic.getHeuristic(s); // f(x) = g(x) + h(x) = 0 + h(x)

        while (true) {
            IDAReturnValue ret = IDAStar(s, s.getStateID(), 0, threshold, cost, solution);
            solved = ret.solved;
            if (solved) {
                Collections.reverse(solution);
                return true;
            }
            threshold = ret.nextThreshold;
            if (threshold == Integer.MAX_VALUE) {
                return false;
            }
        }
    }

    private IDAReturnValue IDAStar(State state, long stateId, int gScore, int threshold,
                                   Cost cost, ArrayList<Action> solution) {
        // Applies the state.
        state.setState(stateId);

        // Is it a goal state?
        if (state.isGoal()) {
            return new IDAReturnValue(true, gScore);
        }

        // Generates successors.
        ArrayList<Action> actions = new ArrayList<Action>();
        state.getActions(actions);
        nodesExpanded++;
        int nextThreshold = Integer.MAX_VALUE;
        for (Action action : actions) {
            // Calculates f(x) = g(x) + h(x)
            int distToNeighbour = state.getCost(action);
            state.make(action);
            int neighbourGScore = gScore + distToNeighbour;
            int neighbourFScore = neighbourGScore + heuristic.getHeuristic(state);

            if (neighbourFScore <= threshold) {
                // Calls the search function recursively.
                IDAReturnValue ret = IDAStar(
                        state, state.getStateID(), neighbourGScore, threshold, cost, solution);
                if (ret.solved) {
                    solution.add(action);
                    cost.value += distToNeighbour;
                    return ret;
                } else {
                    nextThreshold = Math.min(nextThreshold, ret.nextThreshold);
                }
            } else {
                nextThreshold = Math.min(nextThreshold, neighbourFScore);
            }
            state.retract(action);
        }

        return new IDAReturnValue(false, nextThreshold);
    }

	public long getNodesExpanded() {
        return nodesExpanded;
    }

}