public class SearchNode implements Comparable<SearchNode> {

    // Private members

    private int fScore;
    private int gScore; // TODO: Note: Only used with A*.
    private long stateId;
    private Action action;

    // Public members

    public SearchNode(int fScore, long stateId) {
        this.fScore = fScore;
        this.stateId = stateId;
    }

    public SearchNode(int fScore, int gScore, long stateId, Action action) {
        this.fScore = fScore;
        this.gScore = gScore;
        this.stateId = stateId;
        this.action = action;
    }

    public int getFScore() {
        return fScore;
    }

    public int getGScore() {
        return gScore;
    }

    public long getStateId() {
        return stateId;
    }

    public Action getAction() {
        return action;
    }

    public int compareTo(SearchNode other) {
        if (this.fScore > other.fScore) {
            return 1;
        } else if (this.fScore < other.fScore) {
            return -1;
        } else {
            // F-score tie-breaker: Take a look at the G-score and return the node with
            // the HIGHEST G-score.
            if (this.gScore > other.gScore) {
                return -1;
            } else if (this.gScore < other.gScore) {
                return 1;
            }
        }
        return 0;
    }


}
