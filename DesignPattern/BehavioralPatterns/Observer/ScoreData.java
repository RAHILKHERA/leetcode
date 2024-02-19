package DesignPattern.BehavioralPatterns.Observer;

public class ScoreData {
    private int runs;

    private int balls;

    public ScoreData(int runs, int balls) {
        this.runs = runs;
        this.balls = balls;
    }

    public int getRuns() {
        return runs;
    }

    public void setRuns(int runs) {
        this.runs = runs;
    }

    public int getBalls() {
        return balls;
    }

    public void setBalls(int balls) {
        this.balls = balls;
    }

    @Override
    public String toString() {
        return "ScoreData [runs=" + runs + ", balls=" + balls + "]";
    }
}
