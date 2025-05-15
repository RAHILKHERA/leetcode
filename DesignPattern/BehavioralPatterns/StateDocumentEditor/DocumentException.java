package DesignPattern.BehavioralPatterns.StateDocumentEditor;

public class DocumentException extends Exception{
    
    public DocumentException(String message) {
        super(message);
    }

    public DocumentException(String message, Throwable clause) {
        super(message, clause);
    }

    public DocumentException(Throwable clause) {
        super(clause);
    }
}
