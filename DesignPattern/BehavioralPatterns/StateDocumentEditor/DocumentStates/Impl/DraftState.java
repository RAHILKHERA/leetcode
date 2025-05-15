package DesignPattern.BehavioralPatterns.StateDocumentEditor.DocumentStates.Impl;

import java.util.logging.Logger;

import DesignPattern.BehavioralPatterns.StateDocumentEditor.Document;
import DesignPattern.BehavioralPatterns.StateDocumentEditor.DocumentException;
import DesignPattern.BehavioralPatterns.StateDocumentEditor.DocumentStatus;
import DesignPattern.BehavioralPatterns.StateDocumentEditor.DocumentStates.DocumentState;

public class DraftState extends DocumentState {

    private static Logger LOGGER = Logger.getLogger(DraftState.class.getSimpleName());

    public DraftState(Document document) {
        super(document);
        LOGGER.info("Document " + document.getTitle() + " is in draft state.");        
    }   


    @Override
    public void submitDocument() {
        getDocument().setDocumentState(new ReviewState(document));
        getDocument().setDocumentStatus(DocumentStatus.READ_ONLY);
    }

    @Override
    public void approveDocument() throws DocumentException {
        throw new DocumentException("Document, " + document.getTitle() + "cannot be approved in Draft state.");
    }

    @Override
    public void rejectDocument() throws DocumentException {
        throw new DocumentException("Document, " + document.getTitle() + "cannot be rejected in Draft state.");
    }

    @Override
    public void pubilshDocument() throws DocumentException {
        throw new DocumentException("Document, " + document.getTitle() + "cannot be published in Draft state. Submit it for the review.");
    }

    @Override
    public void archiveDocument() throws DocumentException {
        throw new DocumentException("Document, " + document.getTitle() + "cannot be archived in Draft state. Document needs to be Published.");
    }

    @Override
    public void addComments(String comment) throws DocumentException {
        getDocument().addComments(comment);
    }


    @Override
    public void editDocument(String content, boolean append) throws DocumentException {
       getDocument().editDocument(content, append);
    }
    
}
