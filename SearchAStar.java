//
// A star
//

class SearchAStar extends BestFirstSearch {

    @Override
    public int costFunction(int currentFScore, int neighbourGScore, int neighbourHScore) {
        return neighbourGScore + neighbourHScore;
    }

    @Override
    public int initialFScore(State s) {
        return s.getHeuristic();
    }
}
