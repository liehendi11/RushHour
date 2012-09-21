//
// Uniform Cost-Search
//

public class SearchUniformCost extends BestFirstSearch {

    @Override
    public int costFunction(int neighbourGScore, int neighbourHScore) {
        // neighbourGScore: cost(root -> current) + cost(current -> neighbour).
        return neighbourGScore;
    }

}