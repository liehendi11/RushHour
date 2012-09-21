//
// Abstract Search Class
//

import java.util.ArrayList;

interface Search {

	// Runs the search.
	// Input: start state
	// Output: cost of solution and the solution path.
	// Returns: true if solution found, otherwise false.
	public boolean run( State s, Cost cost, ArrayList<Action> solution );

	// Get number of nodes expanded.
	public long getNodesExpanded();

    public void setHeuristic(Heuristic heuristic);
};

