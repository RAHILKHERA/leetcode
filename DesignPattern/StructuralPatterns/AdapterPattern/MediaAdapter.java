package DesignPattern.StructuralPatterns.AdapterPattern;

public class MediaAdapter implements MediaPlayer {

    private AdvancedMediaPlayer advancedMediaPlayer;

    public MediaAdapter(AdvancedMediaPlayer advancedMediaPlayer) {
        this.advancedMediaPlayer = advancedMediaPlayer;
    }

    @Override
    public void play(String fileName) {
        advancedMediaPlayer.advancePlay(fileName);
    }

}
