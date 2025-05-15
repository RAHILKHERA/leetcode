package DesignPattern.BehavioralPatterns.StateDocumentEditor.DocumentStates.Impl;

import java.util.logging.Logger;

import DesignPattern.BehavioralPatterns.StateDocumentEditor.Document;
import DesignPattern.BehavioralPatterns.StateDocumentEditor.DocumentException;
import DesignPattern.BehavioralPatterns.StateDocumentEditor.DocumentStatus;
import DesignPattern.BehavioralPatterns.StateDocumentEditor.DocumentStates.DocumentState;

public class ReviewState extends DocumentState {

    private static Logger LOGGER = Logger.getLogger(DraftState.class.getSimpleName());
    
    ReviewState(Document document) {
        super(document);
        LOGGER.info("Document, " + document.getTitle() + " is under review.");
    }

    @Override
    public void submitDocument() throws DocumentException {
        throw new DocumentException("Document " + getDocument().getTitle() + ", is getting reviewd.");
    }

    @Override
    public void approveDocument() throws DocumentException {
        getDocument().setDocumentStatus(DocumentStatus.READ_ONLY);
        getDocument().setDocumentState(new ApprovedState(document));
    }

    @Override
    public void rejectDocument() throws DocumentException{
        getDocument().setDocumentStatus(DocumentStatus.WRITE);
        getDocument().setDocumentState(new DraftState(document));
    }

    @Override
    public void pubilshDocument() throws DocumentException {
      throw new DocumentException("Document " + getDocument().getTitle() + ", is getting reviewed. Unapproved documents cannot be published.");
    }

    @Override
    public void archiveDocument() throws DocumentException {
        throw new DocumentException("Document " + getDocument().getTitle() + ", is getting reviewed. Cannot be archived.");
    }

    @Override
    public void addComments(String comment) throws DocumentException {
       getDocument().addComments(comment);
    }

    @Override
    public void editDocument(String content, boolean append) throws DocumentException {
        throw new DocumentException("Document " + getDocument().getTitle() + ", is getting reviewed. Cannot be edited.");
    }


    
}
