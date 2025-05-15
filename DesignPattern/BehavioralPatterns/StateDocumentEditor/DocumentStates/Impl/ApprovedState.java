package DesignPattern.BehavioralPatterns.StateDocumentEditor.DocumentStates.Impl;

import java.util.logging.Logger;

import DesignPattern.BehavioralPatterns.StateDocumentEditor.Document;
import DesignPattern.BehavioralPatterns.StateDocumentEditor.DocumentException;
import DesignPattern.BehavioralPatterns.StateDocumentEditor.DocumentStatus;
import DesignPattern.BehavioralPatterns.StateDocumentEditor.DocumentStates.DocumentState;

public class ApprovedState extends DocumentState {

    private static Logger LOGGER = Logger.getLogger(ApprovedState.class.getSimpleName());

    public ApprovedState(Document document) {
        super(document);
        LOGGER.info("Document, " + document.getTitle() + " is approved.");
    }

    @Override
    public void submitDocument() throws DocumentException {
        throw new DocumentException("Document, " + document.getTitle() + "is already approved.");
    }

    @Override
    public void approveDocument() throws DocumentException {
        throw new DocumentException("Document, " + document.getTitle() + "is already approved.");
    }

    @Override
    public void rejectDocument() {
        getDocument().setDocumentStatus(DocumentStatus.WRITE);
        getDocument().setDocumentState(new DraftState(document));
    }

    @Override
    public void pubilshDocument() {
        getDocument().setDocumentState(new PublishedState(document));
    }

    @Override
    public void archiveDocument() throws DocumentException {
        throw new DocumentException(
                "Document, " + document.getTitle() + "is approved. Only published documents can be archived.");
    }

    @Override
    public void addComments(String comment) throws DocumentException {
        getDocument().addComments(comment);
    }

    @Override
    public void editDocument(String content, boolean append) throws DocumentException {
        throw new DocumentException(
                "Document, " + document.getTitle() + "is approved. Cannot edit it, request moderator for changes.");
    }

}
