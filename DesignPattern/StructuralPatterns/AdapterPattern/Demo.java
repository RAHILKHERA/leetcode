package DesignPattern.StructuralPatterns.AdapterPattern;

public class Demo {
    public static void main(String[] args) {
        MediaPlayer player = new AudioPlayer();
        player.play("abc.mp4");
        player.play("abc.vlc");
        player.play("abc.mp3");

    }
}
