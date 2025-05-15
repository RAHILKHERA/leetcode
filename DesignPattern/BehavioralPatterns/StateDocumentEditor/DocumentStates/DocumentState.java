package DesignPattern.BehavioralPatterns.StateDocumentEditor.DocumentStates;

import java.util.List;
import java.util.logging.Logger;

import DesignPattern.BehavioralPatterns.StateDocumentEditor.Document;
import DesignPattern.BehavioralPatterns.StateDocumentEditor.DocumentException;

public abstract class DocumentState {
    
    private static Logger LOGGER = Logger.getLogger(DocumentState.class.getSimpleName());
    protected Document document;
    
    public DocumentState(Document document) {
        this.document = document;
    }

    public Document getDocument() {
        return document;
    }

    public String getContent() {
        return document.getContent();
    }

    public void getComments() {
        List<String> comments = document.getComments();
        for (String comment : comments) {
            LOGGER.info("\n \t" + comment);
        }
    }

    public abstract void editDocument(String content, boolean append) throws DocumentException;
    public abstract void submitDocument() throws DocumentException;
    public abstract void approveDocument() throws DocumentException;
    public abstract void rejectDocument() throws DocumentException;
    public abstract void pubilshDocument() throws DocumentException;
    public abstract void archiveDocument() throws DocumentException;
    public abstract void addComments(String comment) throws DocumentException;

}
