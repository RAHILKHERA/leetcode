package DesignPattern.BehavioralPatterns.Observer;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class AverageScoreDisplay implements PropertyChangeListener {

    private double runRate;
    private int predicatedScore;

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        ScoreData scoreData = (ScoreData) evt.getNewValue();
        double overs = (double) scoreData.getBalls() / 6;
        this.runRate = scoreData.getRuns() / overs;
        this.predicatedScore = (int) this.runRate * 50;
    }

    @Override
    public String toString() {
        return "AverageScoreDisplay [runRate=" + runRate + ", predicatedScore=" + predicatedScore + "]";
    }

    public void display() {
        System.out.println(toString());
    }

}
