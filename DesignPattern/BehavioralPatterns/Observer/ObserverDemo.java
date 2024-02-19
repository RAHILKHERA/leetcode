package DesignPattern.BehavioralPatterns.Observer;

public class ObserverDemo {
    public static void main(String[] args) {
        ScoreData scoreData = new ScoreData(20, 10);

        CricketData cricketData = new CricketData();
        AverageScoreDisplay asd = new AverageScoreDisplay();
        CurrentScoreDisplay csd = new CurrentScoreDisplay();

        cricketData.addPropertyChangeListener(asd);
        cricketData.addPropertyChangeListener(csd);

        cricketData.setScoreData(scoreData);

        csd.disply();
        asd.display();

        // cricketData.removePropertyChangeListener(csd);
        ScoreData newScoreData = new ScoreData(36, 40);
        cricketData.setScoreData(newScoreData);

        csd.disply();
        asd.display();

    }
}
