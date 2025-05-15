package DesignPattern.BehavioralPatterns.StateDocumentEditor.DocumentStates.Impl;

import java.util.logging.Logger;

import DesignPattern.BehavioralPatterns.StateDocumentEditor.Document;
import DesignPattern.BehavioralPatterns.StateDocumentEditor.DocumentException;
import DesignPattern.BehavioralPatterns.StateDocumentEditor.DocumentStates.DocumentState;

public class ArchivedState extends DocumentState {

    private static Logger LOGGER = Logger.getLogger(ArchivedState.class.getSimpleName());

    public ArchivedState(Document document) {
        super(document);
        LOGGER.info("Document, " + document.getTitle() + " is archived.");
    }

    @Override
    public void submitDocument() throws DocumentException {
         throw new DocumentException("Document, " + document.getTitle() + " is archived. This action cannot be performed.");
    }

    @Override
    public void approveDocument() throws DocumentException{
         throw new DocumentException("Document, " + document.getTitle() + " is archived. This action cannot be performed.");
    }

    @Override
    public void rejectDocument() throws DocumentException {
        throw new DocumentException("Document, " + document.getTitle() + " is archived. This action cannot be performed.");
    }

    @Override
    public void pubilshDocument() throws DocumentException {
        throw new DocumentException("Document, " + document.getTitle() + " is archived. This action cannot be performed.");
    }

    @Override
    public void archiveDocument() throws DocumentException {
         throw new DocumentException("Document, " + document.getTitle() + " is archived. This action cannot be performed.");
    }

    @Override
    public void addComments(String comment) throws DocumentException {
         throw new DocumentException("Document, " + document.getTitle() + " is archived. This action cannot be performed.");
    }


    @Override
    public void editDocument(String content, boolean append) throws DocumentException {
      throw new DocumentException("Document, " + document.getTitle() + " is archived. This action cannot be performed.");
    }
    
}
