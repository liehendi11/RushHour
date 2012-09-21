//
// A*
//

class SearchAStar extends BestFirstSearch {

    @Override
    public int costFunction(int neighbourGScore, int neighbourHScore) {
        // neighbourGScore: cost(root -> current) + cost(current -> neighbour).
        // neighbourHScore: costEstimate(neighbour -> goal).
        return neighbourGScore + neighbourHScore;
    }

}
