package DesignPattern.StructuralPatterns.AdapterPattern_1;

public enum EBookType {

    PDF("pdf"),
    EPUB("epub"),
    UNKNOWN("");

    private final String type;

    EBookType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public static EBookType fromFileName(String fileName) {
        String ext = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
        for (EBookType type : values()) {
            if (ext.equals(type.getType())) {
                return type;
            }
        }
        return UNKNOWN;
    }
}
