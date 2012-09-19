
//
// Uniform Cost-Search
//

import java.util.*;

public class SearchUniformCost extends BestFirstSearch {

    @Override
    public int costFunction(int currentFScore, int neighbourGScore, int neighbourHScore) {
        return neighbourGScore;
    }

    @Override
    public int initialFScore(State s) {
        return 0;
    }

}