package DesignPattern.BehavioralPatterns.Observer;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class CurrentScoreDisplay implements PropertyChangeListener {

    private ScoreData scoreData;

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        this.setScoreData((ScoreData) evt.getNewValue());
    }

    private void setScoreData(ScoreData scoreData) {
        this.scoreData = scoreData;
    }

    public void disply() {
        System.out.println("Current Socre :: " + this.scoreData);
    }

}
