package DesignPattern.BehavioralPatterns.StateDocumentEditor.DocumentStates.Impl;

import java.util.logging.Logger;

import DesignPattern.BehavioralPatterns.StateDocumentEditor.Document;
import DesignPattern.BehavioralPatterns.StateDocumentEditor.DocumentException;
import DesignPattern.BehavioralPatterns.StateDocumentEditor.DocumentStatus;
import DesignPattern.BehavioralPatterns.StateDocumentEditor.DocumentStates.DocumentState;

public class PublishedState extends DocumentState {

    private static Logger LOGGER = Logger.getLogger(DraftState.class.getSimpleName());

    public PublishedState(Document document) {
        super(document);
        LOGGER.info("Document, " + document.getTitle() + " is published.");
    }

    @Override
    public void submitDocument() throws DocumentException {
        throw new DocumentException("Document " + getDocument().getTitle() + ", is published.");
    }

    @Override
    public void approveDocument() throws DocumentException {
        throw new DocumentException("Document " + getDocument().getTitle() + ", is published.");
    }

    @Override
    public void rejectDocument() throws DocumentException{
        throw new DocumentException("Document " + getDocument().getTitle() + ", is published.");
    }

    @Override
    public void pubilshDocument() throws DocumentException{
        throw new DocumentException("Document " + getDocument().getTitle() + ", is published.");
    }

    @Override
    public void archiveDocument() throws DocumentException{
        getDocument().setDocumentStatus(DocumentStatus.ARCHIVED);
        getDocument().setDocumentState(new ArchivedState(document));
    }

    @Override
    public void addComments(String comment) throws DocumentException{
        throw new DocumentException("Document " + getDocument().getTitle() + ", is published. Cannot add comments to published document.");
    }


    @Override
    public void editDocument(String content, boolean append) throws DocumentException {
        throw new DocumentException("Document " + getDocument().getTitle() + ", is published. Cannot edit published document.");
    }
    
}
