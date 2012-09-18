//
// AStar
//

import java.util.ArrayList;

class SearchAStar implements Search
{
	// Input: start state
	// Output: cost of solution and the solution path.
	// Returns: true if solution found, otherwise false.
	public boolean run( State s, Cost cost, ArrayList<Action> solution )
    {
        // You should implement this method.
        return false;
    }

    // Get number of nodes expanded.
	public long getNodesExpanded()
    {
        return m_nodesExpanded;
    }

    ///////// Private ///////////
	private long m_nodesExpanded;
}
