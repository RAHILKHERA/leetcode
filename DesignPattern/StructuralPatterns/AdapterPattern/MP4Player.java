package DesignPattern.StructuralPatterns.AdapterPattern;

public class MP4Player implements AdvancedMediaPlayer {

    @Override
    public void advancePlay(String fileName) {
        System.out.println("Playing MP4 File : " + fileName);
    }

}
