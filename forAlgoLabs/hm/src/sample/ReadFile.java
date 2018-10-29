package sample;

public class ReadFile {

    private Hamsters[] totalHamsters;

    private long foodSupply;

    public Hamsters[] getTotalHamsters() {
        return totalHamsters;
    }

    public void setTotalHamsters(Hamsters[] totalHamsters) {
        this.totalHamsters = totalHamsters;
    }

    public long getFoodSupply() {
        return foodSupply;
    }

    public void setFoodSupply(long foodSupply) {
        this.foodSupply = foodSupply;
    }

    public ReadFile(long foodSupply, Hamsters[] totalHamsters) {
        this.totalHamsters =totalHamsters;
        this.foodSupply = foodSupply;
    }
}