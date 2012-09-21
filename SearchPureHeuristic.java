//
// Pure-Heuristic Search
//

public class SearchPureHeuristic extends BestFirstSearch {

    @Override
    public int costFunction(int neighbourGScore, int neighbourHScore) {
        // neighbourHScore: costEstimate(neighbour -> goal).
        return neighbourHScore;
    }

}