package DesignPattern.StructuralPatterns.AdapterPattern;

public class VLCMediaPlayer implements AdvancedMediaPlayer {

    @Override
    public void advancePlay(String fileName) {
        System.out.println("Playing VLC media file : " + fileName);
    }

}
