package DesignPattern.StructuralPatterns.AdapterPattern;

public class AudioPlayer implements MediaPlayer {

    @Override
    public void play(String fileName) {
        MediaType extension = MediaType.fromFileName(fileName);

        switch (extension) {
            case MP3:
                System.out.println("Playing MP3 file : " + fileName);
                break;
            case MP4:
                MediaAdapter adapter = new MediaAdapter(new MP4Player());
                adapter.play(fileName);
                break;
            case VLC:
                MediaAdapter adapter1 = new MediaAdapter(new VLCMediaPlayer());
                adapter1.play(fileName);
                break;
            default:
                System.out.println("Not Supported : " + fileName);
        }
    }

}
