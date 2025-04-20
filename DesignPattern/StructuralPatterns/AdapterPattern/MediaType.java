package DesignPattern.StructuralPatterns.AdapterPattern;

public enum MediaType {
    MP3("mp3"),
    MP4("mp4"),
    VLC("vlc"),
    UNKNOWN("");

    private final String extension;

    MediaType(String extension) {
        this.extension = extension;
    }

    public String getExtension() {
        return this.extension;
    }

    public static MediaType fromFileName(String fileName) {
        String ext = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
        for (MediaType type : values()) {
            if (type.getExtension().equals(ext)) {
                return type;
            }
        }
        return UNKNOWN;
    }
}
