//
// Depth-First Search
//

import java.util.ArrayList;
import java.util.Collections;

class SearchDFID implements Search
{
    
    // Input: start state
	// Output: cost of solution and the solution path.
	// Returns: true if solution found, otherwise false.
    public boolean run( State s, Cost cost, ArrayList<Action> solution )
    {
        // Iterate on depth threashold until solution is found.
        m_nodesExpanded = 0; // reset nodes expanded.
        int  depth  = 0;
        boolean solved = false;
        while ( !solved ) {
            solved = DFS( s, depth, cost, solution );
            depth++;
        }
        Collections.reverse( solution );
        return solved;
    }

    // Get number of nodes expanded.
	public long getNodesExpanded()
    {
        return m_nodesExpanded;
    }

    ///////// Private ///////////
    private long m_nodesExpanded;

    // Depth-bounded Depth-First Search
    private boolean DFS( State s, int depth, Cost cost, ArrayList<Action> solution )
    {
	    // If goal is found then return success, else if depth limit
	    // is reached return failure.
	    if ( s.isGoal() ) {
		    cost.value = 0;
		    solution.clear();
		    return true;
	    }
	    else if ( depth <= 0 ) {
	    	return false;
	    }

    	// Iterate through the successors recursively invoking DFS.
	    ArrayList<Action> actions = new ArrayList<Action>();
	    s.getActions( actions );
        m_nodesExpanded++;
        boolean solved = false;
	    for ( int i=0; i < actions.size() ; ++i ) {
	        s.make( actions.get(i) );
	        solved = DFS( s, depth-1, cost, solution );
	        s.retract( actions.get(i) );
	        if ( solved ) {
		        cost.value += s.getCost( actions.get(i) );
		        solution.add( actions.get(i) );
		        break;
	        }
	    }

	    // Return the status of the search (solution found or not).
	    return solved;
    }

}
