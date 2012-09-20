//
// RushHour main program.
//
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.io.FileWriter;

public class RushHour {

    public static void main( String[] args )
    {
        boolean		  showBoard = false; // Show game board.
        String searchClassName;
        if(args.length>0) {
        	searchClassName = args[0];
        }
        else {
        	searchClassName = "SearchUniformCost";
        }
        
        Map<String, String> classToAlgName = new HashMap<String, String>();
        classToAlgName.put("SearchDFID", "DFID");
        classToAlgName.put("SearchUniformCost", "Uniform-Cost");
        classToAlgName.put("SearchPureHeuristic", "Pure-Heuristic");
        classToAlgName.put("SearchAStar", "A*");
        classToAlgName.put("SearchIDAStar", "IDA*");
        classToAlgName.put("SearchEnhancedIDAStar", "Enhanced-IDA*");
        String algName = classToAlgName.get(searchClassName);
                
        ArrayList<String> puzzles = new ArrayList<String>();
        puzzles.add( "puzzle00.rh" );
        puzzles.add( "puzzle01.rh" );
        puzzles.add( "puzzle02.rh" );
        //puzzles.add("jam/test.rh");

        for (int i = 1; i <= 40; i++) {
            puzzles.add("jam/jam" + i + ".rh");
        }

        try {
            Search search = (Search)Class.forName(searchClassName).newInstance();
        	FileWriter file = new FileWriter( searchClassName +".txt" ); // Store output in file.
            Solve( file, showBoard, algName, search, puzzles );
            file.close();
        } catch (IOException e) {
           e.printStackTrace();
        } catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    }

    static void Solve( OutputStreamWriter osw, boolean showBoard, String header, Search search, ArrayList<String> puzzles )
    {

        try {
            OutputStreamWriter cout = new OutputStreamWriter(System.out);
            osw.write("=======================================================================\n");
            osw.write( header + "\n" );
            osw.write("=======================================================================\n");
            osw.write("N ? Len Cost       Nodes     MSec  Solution\n");
            cout.write("---+---+-----+------+-------------+-------+---------\n");
            cout.write("N  | ? | Len | Cost | Nodes       | MSec  | Solution\n");
            cout.write("---+---+-----+------+-------------+-------+---------\n");

            long sumNodes = 0, sumMillis = 0;
            int sumLength = 0, sumCost = 0;

            for ( int n=0 ; n<puzzles.size() ; ++n ) {
                State rhs = RushHourState.createFromFile( puzzles.get(n) );
                if ( showBoard ) {
                    rhs.draw( );
                    System.out.flush();
                }
                // Solve the problem instance.
                Cost cost = new Cost();
                ArrayList<Action> sol = new ArrayList<Action>();
                long start = System.currentTimeMillis();
                boolean solved = search.run( rhs, cost, sol );
                long stop = System.currentTimeMillis();

                sumCost += cost.value;
                sumLength += sol.size();
                sumNodes += search.getNodesExpanded();
                sumMillis += (stop - start);

                // Output search logistic (to console and to a file).
                OutputInfo( cout, n, solved, search.getNodesExpanded(), cost.value, sol, stop-start, sol.size() );
                OutputInfo( osw, n, solved, search.getNodesExpanded(), cost.value, sol, stop-start, sol.size() );
            }
            cout.write("---+---+-----+------+-------------+-------+---------\n");
            OutputInfo(cout, 0, true, sumNodes, sumCost, new ArrayList<Action>(), sumMillis, sumLength );
            cout.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static void OutputInfo( OutputStreamWriter osw, int n, boolean solved, long nodesExpanded, int cost,
                            ArrayList<Action> sol, long tim, int solLength)
    {
        try {
            osw.write(String.format("%2s", String.valueOf(n)) + " ");
            osw.write("|");
            osw.write(String.format("%2s", String.valueOf(solved ? '1' : '0')) + " ");
            osw.write("|");
            osw.write(String.format("%4s", String.valueOf(solLength)) + " ");
            osw.write("|");
            osw.write(String.format("%5s", String.valueOf(cost)) + " ");
            osw.write("|");
            osw.write(String.format("%12s", String.valueOf(nodesExpanded)) + " ");
            osw.write("|");
            osw.write(String.format("%6s", String.valueOf(tim)) + " ");
            osw.write("| ");
            for ( int i=0; i<sol.size(); ++i )
            {
                 RushHourAction ra = (RushHourAction) sol.get(i);
                 osw.write( ra.toStr() );
                 osw.write( ' ' );
            }
            osw.write('\n');
            osw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
