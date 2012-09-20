import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class SearchEnhancedIDAStar implements Search {

    // Private members

    private long nodesExpanded;
    private HashMap<Long, TransEntry> transTable = new HashMap<Long, TransEntry>();

    // Public members

    public boolean run( State s, Cost cost, ArrayList<Action> solution )
    {
        transTable.clear();
        solution.clear();
        nodesExpanded = 0;
        boolean solved;
        int threshold = s.getHeuristic(); // f(x) = g(x) + h(x) = 0 + h(x)

        while (true) {
            IDAReturnValue ret = EIDAStar(s, s.getStateID(), 0, threshold, cost, solution);
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

    private IDAReturnValue EIDAStar(State state, long stateId, int gScore, int threshold,
                                   Cost cost, ArrayList<Action> solution) {

        // Probes the transposition table.
        if (transTable.containsKey(stateId)) {
            TransEntry entry = transTable.get(stateId);
            if (gScore > entry.gScore) {
                return new IDAReturnValue(false, Integer.MAX_VALUE);
            }
            if (gScore == entry.gScore && threshold == entry.threshold) {
                return new IDAReturnValue(false, Integer.MAX_VALUE);
            }
        }
        TransEntry entry = new TransEntry(gScore, threshold);
        transTable.put(stateId, entry);

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

            // g(x)
            int distToNeighbour = state.getCost(action);
            state.make(action);
            int neighbourGScore = gScore + distToNeighbour;
            long neighbourStateId = state.getStateID();

            // h(x): Probes the transposition table for a H-score, if not found: Calculate it.
            int neighbourHScore;
            if (transTable.containsKey(neighbourStateId)) {
                TransEntry neighbourEntry = transTable.get(neighbourStateId);
                neighbourHScore = neighbourEntry.hScore;
            } else {
                neighbourHScore = state.getHeuristic();
            }

            // f(x)
            int neighbourFScore = neighbourGScore + neighbourHScore;
            if (neighbourFScore <= threshold) {
                // Calls the search function recursively.
                IDAReturnValue ret = EIDAStar(
                        state, neighbourStateId, neighbourGScore, threshold, cost, solution);
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

        // Set the h(x) for this node in the transposition table.
        entry.hScore = nextThreshold - gScore;

        return new IDAReturnValue(false, nextThreshold);
    }

    public long getNodesExpanded() {
        return nodesExpanded;
    }

}

class TransEntry {

    public int gScore;
    public int hScore;
    public int threshold;

    TransEntry(int gScore, int threshold) {
        this.gScore = gScore;
        this.threshold = threshold;
        this.hScore = 0; // TODO: this.
    }

}
