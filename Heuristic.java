public interface Heuristic {
    public void initialize(State state);
    public int estimateCost(State state);
}
