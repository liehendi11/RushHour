
public class IDAReturnValue {

    public boolean solved;
    public int nextThreshold;

    IDAReturnValue(boolean solved, int minimumCost) {
        this.solved = solved;
        this.nextThreshold = minimumCost;
    }

}
