package DesignPattern.BehavioralPatterns.StateDocumentEditor;

public enum DocumentStatus {
    READ_ONLY("read_only"),
    WRITE("write"),
    ARCHIVED("archived"),
    INVALID("invalid");

    private String status;

    DocumentStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public static DocumentStatus getDocumentStatus(String status) {
        for (DocumentStatus documentStatus : values()) {
            if (documentStatus.status.equals(status)) {
                return documentStatus;
            }
        }
        return INVALID;
    }
}
