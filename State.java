//
// State.h
//
// Abstract class representing a State Space.
//
//

import java.util.*;

interface State
{
	public boolean setState( long id );

	// Get current state (either ID or string representation).
	public long getStateID( );

	// Get actions, make/retract an action, and check whether a state is a goal state.
	public void getActions( ArrayList<Action> actions );
	public void make( Action a );
	public void retract( Action a );

	// Check whether current state is a goal.
	public boolean isGoal( );
	public boolean isStart( );

	// Get cost of an edge/heuristic estimate.
	public int getCost( Action a );
	public int getHeuristic();

	// Make a copy of the state.
	//public State clone();
	
	public void draw();

}
