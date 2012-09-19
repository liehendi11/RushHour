
//
// Pure-Heuristic Search
//

public class SearchPureHeuristic extends BestFirstSearch {

    @Override
    public int costFunction(int currentFScore, int neighbourGScore, int neighbourHScore) {
        return currentFScore + neighbourHScore;
    }

    @Override
    public int initialFScore(State s) {
        return s.getHeuristic();
    }

}