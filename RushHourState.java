/*
 *  RushHourState.h
 *  RealTimeSearch
 *
 *  Created by Sverrir Sigmundarson on 24.1.2006 (C++)
 *  Ported to Java by YB (Jan. 2008)
 The State is read from a map-file that must have the file-ending ".rh"
 Excluding the indentation, the structure of the file is as follows (all text that follows a "--" should not be includes in the rh-file):
  8 -- (integer) first line defines the grid dimensions (Theoretically it has a MIN=2, MAX=16, but for this project this number is fixed at "8")
  3 -- (integer) second line defines the number of cars (including the required car0, so the number 3 indicates 2 blocking cars and car0 which is the goal char)
    -- The remaining lines describe the grid layout in ascii. Where "#" is a wall, "=" is the exit gate, and the letters A through U represent the cars and their layout
    ########
    #  C   #
    #AAC   =
    #  C   #
    # BB   #
    #      #
    #      #
    ######## 
 The example above can be found in the file "puzzle1.rh" (which is a normal text file
                                                          
SPECIAL NOTES:
1. NO more than 21 cars can be placed on the map (e.g. letters A through U)
2. There MUST be at least one car placed on the map (that is car0)!!
3. For this project the grid dimensions are fixed at 8 (that is 6x6 movable space)
4. Always remember to have an extra line break at the end of the .rh file
5. Use the functions:
   - getActions( &vector ) to get all available actions
   - Use the function getCost( action ) to get the cost of making that action (non-unit cost)
   - Use the functions make() and retract() to perform the actions that are returned from getActions()
6. REIMPLEMENT the function getHeuristic() since it really really is quite bad (no really!)
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

       
class RushHourState implements State
{
    RushHourGrid           grid;
    ArrayList<GridPos>     cars_original;
    ArrayList<RushHourCar> cars;
    int                    m_number_of_cars;
    int                    m_board_dimensions;
    long                   startStateID;   // The complete stateID of the initial state (not enough just to observe car0 here, since the arrangement of all other cars must be the same)
    GridPos                exitPos;        // The row col number of the exit
    
    RushHourState( int board_dimensions, int number_of_cars )
    {
        grid = new RushHourGrid( board_dimensions, board_dimensions );
        cars_original = new  ArrayList<GridPos>();
        cars = new ArrayList<RushHourCar>();
        m_number_of_cars = number_of_cars;
        m_board_dimensions = board_dimensions;
        startStateID = 0;
        exitPos = new GridPos();

    }

    static State create( int board_dimensions, int number_of_cars )
    {
        // Check if the state string is ok
        if( board_dimensions < 2 || board_dimensions > 10 )
        {
            System.out.println("The grid dimensions must be within the range of 2 to 10");
            System.exit(-2);
        }

        return new RushHourState(board_dimensions, number_of_cars);
    }
    
    void printCars()
    {
        System.out.println("Cars:");
        for (int i=0; i<cars.size();++i)
        {
            RushHourCar c = cars.get(i);
            System.out.print( (char)(c.getCarId()+RushHourGrid.FIRST_LETTER) );
            System.out.print( ":" );
            System.out.print( c.getOrientation() );
            System.out.print( ":" );
            System.out.print( c.getHead().getRow() );
            System.out.print( "-" );
            System.out.print( c.getHead().getCol() );
            System.out.print( ":" );
            System.out.println( c.getLength() );
        }
    }


    public boolean loadMap( String mapFile )
    {
        try {
            BufferedReader fin = new BufferedReader(new FileReader( mapFile ));

            int x;
            int y;

            x = Integer.valueOf( fin.readLine() ).intValue();
            y = Integer.valueOf( fin.readLine() ).intValue();

            // Must be at-least one car
            if( y < 1 ) {
                System.out.print("Error: there must be at least one car (1) specified in the second line of the map file (");
                System.out.println( mapFile );
                return false;
            }

            // Initialize the vector with empty cars so that we can index them correctly when they are read from the puzzle file
            for( int i = 0; i < y; ++i ) {
                cars.add( new RushHourCar(i) );
                cars_original.add( new GridPos(-1,-1) );
            }

            RushHourGrid ngrid = new RushHourGrid( x, x );

            for( int r=0; r < x; r++ ) {
                for( int c=0; c < x; c++ ) {

                    char in = (char) fin.read(); 
                     
                    // If this is a free block or a wall block then just fill it in
                    if( in == RushHourGrid.FREE || in == RushHourGrid.BLOCKED ) {
                      ngrid.setAt( c, r, in );
                    }
                    else if( in == RushHourGrid.EXIT ) {
                        // If this is an exit then we store the row and column number of the exit
                        exitPos.set( c, r );
                        ngrid.setAt( c, r, in );
                    }
                    else if( in >= RushHourGrid.FIRST_LETTER && in <= RushHourGrid.LAST_LETTER ) {
                        /* TODO: Here we should setup a simple error checking to check if there aren't:
                             - car0 must be specified
                             - the number of cars must be equal to the number specified in line two
                             - All cars must have dimensions greater than 1 and less than the width/height of the game-grid
                        */
                        // This is a car.. check what char it is and it's orientations
                        int carid = in - RushHourGrid.FIRST_LETTER;

                        // Set the cars head position and orientation
                        cars.get(carid).setOrientation( c, r );
                       cars_original.get(carid).set( cars.get(carid).getHead() ); // The orginal position of the cars on the grid, used to calculate the StatID!, and yes .. i know this is kinda, dirty:)
                    }
                    else if( in == '\n' ) {
                        if( c != x ) {
                            System.out.println("Warning: end-of-line encountered before grid was fully initialized.");
                        }
                        break;
                    }
                    else {
                        System.out.print("Error, unrecognized character ('");
                        System.out.print(in);
                        System.out.println("found in map stream. Could not load map.");
                        fin.close();
                        return false;
                    }
                }

                // Remove the last linebreak at the end of the line
		        char ln = (char)( fin.read() );
                if ( ln == '\r' ) {   // DOS/Windows style
                    ln = (char)( fin.read() );
                }
                if( ln != '\n' ) {
                    System.out.println("Expecting line-break at end of line).");
        			fin.close();
		        	return false;
		        }
                
            }
            fin.close();

            // Save the grid
            grid = ngrid;

            // Save the start state
            startStateID = getStateID();
         } catch (IOException e) {
            System.out.print("Unable to find or read RushHourState puzzle file, file not found. Filename:");
            System.out.println( mapFile );
            return false;
         }

	    // All is ok.. :)
	    return true;
    }


	static State createFromFile( String fileName )
    {
        // Check if the file is a RushHour puzzle file (just check if the ending is .rh )
        if( ! fileName.endsWith(".rh") )
        {
            System.out.println("The RushHour map file must have the file ending .rh, else it won't be loaded. Yeah i know it's stupid but hey!");
            System.exit( -10 );
        }

        RushHourState state = new RushHourState(8, 1);
        if(!state.loadMap(fileName))
        {
            System.out.println("Error: Could not create the state :/ some thing is wrong in the loadMap() function!");
            System.exit( -30 );
        }
        else
        {
            return state;
        }

        return null;
    }

    enum None { none }
	
	// Set current state.
	public boolean setState( long id )
    {
        for(int i=0; i<cars.size(); ++i)
        {
            GridPos org = cars_original.get(i);
            int change = (int)((id >> (i * 3))&7);

            // Changes in column position only if vertical
            if( cars.get(i).getOrientation() == RushHourCar.Orientation.VERTICAL )
            {
                if( change < org.getRow() ) {
                    cars.get(i).getHead().setRow(org.getRow() - change);
                }
                else if( change > org.getRow() ) {
                    cars.get(i).getHead().setRow(org.getRow() + (change - org.getRow()));
                }
                else if( change == org.getRow() ) {
                    cars.get(i).getHead().setRow(org.getRow());
                }
             }
             // Changes only in row position if horizontal
             else if( cars.get(i).getOrientation() == RushHourCar.Orientation.HORIZONTAL )
             {
                 if( change < org.getCol() )
                     cars.get(i).getHead().setCol(org.getCol() - change);
                 else if( change > org.getCol() )
                     cars.get(i).getHead().setCol(org.getCol() + (change - org.getCol()));
                 else if( change == org.getCol() )
                     cars.get(i).getHead().setCol(org.getCol());
             }
         }
         return true;
    }

	// Get current state id.
	public long getStateID( )
    {
        long id = 0;
        for( int i=0; i<cars.size(); ++i)
        {
            RushHourCar c = cars.get(i);
            GridPos o = cars_original.get(i);
            int change = 0;
            int amount = 0;

            if( c.getOrientation() == RushHourCar.Orientation.VERTICAL )
            {
                change = c.getHead().getRow() - o.getRow();
                amount = o.getRow();
            }
            else if( c.getOrientation() == RushHourCar.Orientation.HORIZONTAL )
            {
                change = c.getHead().getCol() - o.getCol();
                amount = o.getCol();
            }

            if( change < 0 )
                amount = Math.abs( change );
            else if( change > 0 )
                amount += change;

            id |= ( (long)(amount)	<< ( i * 3));
        }

        return id;
    }

	// Get actions, make/retract an action, and check whether a state is a goal state.
	public void getActions( ArrayList<Action> actions ) {
        // Start by creating a copy of the underlying grid with the car data merged to it
        RushHourGrid g = grid.merge( cars );

        // For all cars check available space based on their orientation
        for( int i=0; i<cars.size(); ++i)
        {
            RushHourCar car = cars.get(i);

            int space_before = 0;
            int space_after = 0;

            if( car.getOrientation() == RushHourCar.Orientation.VERTICAL ) // Vertical then we check the rows
            {
                // Get the space before the position
                for( int r=car.getHead().getRow()-1; r>=0; --r )
                {
                    if( g.isFree(car.getHead().getCol(), r) ||
                        (i==0 && g.isExit(car.getHead().getCol(),r) ))
                        space_before++;
                    else
                        break;
                }

                // Get the space after the end of the car
                for( int r=car.getHead().getRow()+car.getLength(); r<=g.getWidth(); ++r )
                {
                    if( g.isFree(car.getHead().getCol(), r) ||
                        (i==0 && g.isExit(car.getHead().getCol(),r) ) )
                        space_after++;
                    else
                        break;
                }
            }
            else if (car.getOrientation() == RushHourCar.Orientation.HORIZONTAL ) // Horizontal, we check the columns
            {
                // Get the space before the position
                for( int c=car.getHead().getCol()-1; c>=0; --c )
                {
                    if( g.isFree(c, car.getHead().getRow()) ||
                        (i==0 && g.isExit(c,car.getHead().getRow()) ) )
                        space_before++;
                    else
                        break;
                }

                // Get the space after the end of the car
                for( int c=car.getHead().getCol()+car.getLength(); c<=g.getHeight(); ++c )
                {
                    if( g.isFree(c, car.getHead().getRow()) ||
                        (i==0 && g.isExit(c,car.getHead().getRow()) ) )
                        space_after++;
                    else
                        break;
                }
            }

            // Now we can construct all the permutations of these actions
            for( int n = 1; n<=space_before; ++n )
            {
                RushHourAction a = new  RushHourAction( car.getCarId(), -n );
                actions.add( a );
            }
            for( int n = 1; n<=space_after; ++n )
            {
                RushHourAction a = new RushHourAction( car.getCarId(), n );
                actions.add( a );
            }
        }

    }


    public void make( Action a )
    {
        // Decode the action
        RushHourAction ra = (RushHourAction) a;

        // Move the appropriate car :)
        cars.get(ra.getCarId()).move( ra.getMoveBy() );
    }


    public void retract( Action a )
    {
        // Decode the action
        RushHourAction ra = (RushHourAction) a;

        // Retract the move (by negating it) simple is good :)
        cars.get(ra.getCarId()).move( -ra.getMoveBy() );

    }

    public int getCost( Action a )
    {
        RushHourAction ra = (RushHourAction) a;
        return Math.abs( ra.getMoveBy() ) + 1;
    }


    public boolean isGoal( ) {
        // This is the goal position if car0 has excaped the boundaries of the grid, through the EXIT gate!

        // Get car0
        RushHourCar car0 = cars.get(0);

        // if horizontal, and the column of the exit is the same as the column of car0 then this is a goal :)
        if( car0.getOrientation() == RushHourCar.Orientation.HORIZONTAL &&
           (car0.getHead().getCol() == exitPos.getCol() || car0.getHead().getCol()+(car0.getLength()-1) >= exitPos.getCol() ) )
           return true;
        // if vertical.. yaddy..yaddy.. ya!
        if( car0.getOrientation() == RushHourCar.Orientation.VERTICAL && (car0.getHead().getRow() == exitPos.getRow() ||
                car0.getHead().getRow()+(car0.getLength()-1) >= exitPos.getRow()) )
           return true;

        // Nope.. not a goal..
        return false;
    }


    public boolean isStart( )
    {
        // The state is only the start if the arrangement of all the cars is the same!!!
        // StateID FTW!!
        return getStateID() == startStateID;
    }

    public void draw()
    {
        // Draw each block in the grid
        grid.draw( cars );
        // DEBUG!!! print the car info
        // printCars();
    }
    

    // NOTE: This heuristic function assumes that car0 lies horizontally on the grid and that the exit goal is on the right-hand side of car0.
    //       The test-bed itself does not make these constraints, e.g. the exit can be on any of the four sides of the grid and car0 can both be
    //       placed horizontally and vertically.. but it's up to you to choose :) hehe options == nothing but a pain in the a**.
	public int getHeuristic()
    {
        // YEEEEESSS... so for starters you get this heuristic function:
        //  Counts how many cars are blocking the exit
        //  Believe me this heuristic function s*cks.. highly recommend that you use your newfound heuristic-intuition to make a better one :D

        RushHourCar car0 = cars.get(0);
        int upper_limit = grid.getWidth(); // Get the right-hand side of the grid
        int count = 0; // Yeah.. mkay a counter ok!

        // Create the merged grid.. this is rather expensive to do in a heuristic function which is called repeatedly,
        // you might want to do this differently (hint, hint) :)
        RushHourGrid tgrid = grid.merge( cars );

        for( int i=car0.getHead().getCol()+car0.getLength(); i<upper_limit;++i)
        {
            if( !tgrid.isFree(i,car0.getHead().getRow()) )
                count++;
        }
    
        return count;
    }
    
}
