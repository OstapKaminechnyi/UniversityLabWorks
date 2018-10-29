package sample;

public class Hamsters {

    private long hamsterDose;

    private long greed;

    public long getHamsterDose() {
        return hamsterDose;
    }

    public void setHamsterDose(int hamsterDose) {
        this.hamsterDose = hamsterDose;
    }

    public long getGreed() {
        return greed;
    }

    public void setGreed(int greed) {
        this.greed = greed;
    }

    public Hamsters(int hamsterDose, int greed) {
        this.hamsterDose = hamsterDose;
        this.greed = greed;
    }

    public long getConsume(int neighbours) {
        return hamsterDose + greed * neighbours;
    }
}