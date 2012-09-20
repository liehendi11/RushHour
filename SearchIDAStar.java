//
// IDAStar
//

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

class SearchIDAStar implements Search
{
    // Private members

    private long nodesExpanded;
    private State state;

    // Public members

	public boolean run( State s, Cost cost, ArrayList<Action> solution )
    {
        state = s; // Keep the state as a private member.
        solution.clear();
        nodesExpanded = 0;
        boolean solved;
        int threshold = s.getHeuristic(); // f(x) = g(x) + h(x) = 0 + h(x)

        while (true) {
            IDAStarReturn ret = IDAStar(s.getStateID(), 0, threshold, cost, solution);
            solved = ret.solved; // TODO: Death to IDAStarReturn?
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

    private IDAStarReturn IDAStar(long stateId, int gScore, int threshold,
                                  Cost cost, ArrayList<Action> solution) {

        // Applies the state.
        state.setState(stateId);

        // Is it a goal state?
        if (state.isGoal()) {
            return new IDAStarReturn(true, gScore); // TODO: Contradicts Wikipedia.
        }

        int nextThreshold = Integer.MAX_VALUE;

        // Generates successors.
        ArrayList<Action> actions = new ArrayList<Action>();
        state.getActions(actions);
        nodesExpanded++;
        for (Action action : actions) {
            int distToNeighbour = state.getCost(action);
            state.make(action);
            int neighbourGScore = gScore + distToNeighbour;
            int neighbourFScore = neighbourGScore + state.getHeuristic();
            if (neighbourFScore <= threshold) {
                IDAStarReturn ret = IDAStar(state.getStateID(), neighbourGScore, threshold, cost, solution);
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

        return new IDAStarReturn(false, nextThreshold);
    }

	public long getNodesExpanded()
    {
        return nodesExpanded;
    }

}


class IDAStarReturn {
    public boolean solved;
    public int nextThreshold;

    IDAStarReturn(boolean solved, int minimumCost) {
        this.solved = solved;
        this.nextThreshold = minimumCost;
    }
}