package sample;

public class WriteToFile {

    private int maxHamsters;

    public int getMaxHamsters() {
        return maxHamsters;
    }

    public void setMaxHamsters(int maxHamsters) {
        this.maxHamsters = maxHamsters;
    }

    public WriteToFile(int maxAffordableHamsters) {
        this.maxHamsters = maxHamsters;
    }
}