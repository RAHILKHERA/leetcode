package DesignPattern.BehavioralPatterns.StateDocumentEditor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import DesignPattern.BehavioralPatterns.StateDocumentEditor.DocumentStates.DocumentState;
import DesignPattern.BehavioralPatterns.StateDocumentEditor.DocumentStates.Impl.DraftState;

public class Document {
    
    private String title;
    private String content;
    private StringBuilder contentBuilder;
    private DocumentState documentState;
    private List<String> comments;
    private DocumentStatus status;
    
    public Document (String title) {
       this.title = title;
       contentBuilder = new StringBuilder();
       documentState = new DraftState(this);
       comments = new ArrayList<>();
       status = DocumentStatus.WRITE;
    }

    public String getContent() {
        if (content == null) {
            content = contentBuilder.toString();
        }
        return content;
    }

    public void addComments(String comment) throws DocumentException {
        if (status.equals(DocumentStatus.ARCHIVED) || status.equals(DocumentStatus.INVALID)) {
            throw new DocumentException("Document " + getTitle() + " cannot add comments.");    
        }
        comments.add(comment);    
    }

    public List<String> getComments() {
        return Collections.unmodifiableList(comments);
    }

    public void editDocument(String content, boolean append) throws DocumentException {
        if (!status.equals(DocumentStatus.WRITE)) {
            throw new DocumentException("Document " + getTitle() + " cannot be edited.");    
        }
        if (append) {
            contentBuilder.append(content);
        } else {
            contentBuilder = new StringBuilder(content);
        }
    }
    
    public  DocumentState getDocumentState() {
        return documentState;
    }

    public void setDocumentState(DocumentState state) {
        documentState = state;
    }

    public DocumentStatus getDocumentStatus() {
        return status;
    }

    public void setDocumentStatus(DocumentStatus status) {
        this.status = status;
        if (status.equals(DocumentStatus.READ_ONLY)) {
            content = contentBuilder.toString();
        }
    } 

    public String getTitle() {
        return title;
    }
}
