package DesignPattern.BehavioralPatterns.Observer;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class CricketData {

    private ScoreData scoreData;
    private static final String SCORE_CHANGE = "Score Change";

    private PropertyChangeSupport support;

    public CricketData() {
        support = new PropertyChangeSupport(this);
    }

    public void addPropertyChangeListener(PropertyChangeListener scoreListener) {
        support.addPropertyChangeListener(SCORE_CHANGE, scoreListener);
    }

    public void removePropertyChangeListener(PropertyChangeListener scoreListener) {
        support.removePropertyChangeListener(SCORE_CHANGE, scoreListener);
    }

    public void setScoreData(ScoreData scoreData) {
        ScoreData oldScoreData = this.scoreData; // Store the old value
        this.scoreData = scoreData;
        support.firePropertyChange(SCORE_CHANGE, oldScoreData, scoreData); // Use old and new values
    }

    public ScoreData getScoreData() {
        return scoreData;
    }
}
