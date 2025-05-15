package DesignPattern.BehavioralPatterns.StateDocumentEditor;

import java.util.logging.Logger;

import DesignPattern.BehavioralPatterns.StateDocumentEditor.DocumentStates.DocumentState;

public class Demo {

    private static Logger LOGGER = Logger.getLogger(Demo.class.getSimpleName());
    public static void main(String[] args) {
        
    
        Document document = new Document("Resume.pdf");
        try {
            //Draft
            DocumentState state = document.getDocumentState();
            state.editDocument("Name : Rahil", false);
            state.editDocument("\nSoftware Developer", true);
            state.addComments("\nSubmitted for Review, Initial Draft.\n");
            state.submitDocument();

            //Review
            state = document.getDocumentState();
            LOGGER.info(state.getContent());
            LOGGER.info("\n-----------------------------Comments-----------------------\n");
            state.getComments();
            state.addComments("Add Place..");
            state.rejectDocument();

            //Draft
            state = document.getDocumentState();
            LOGGER.info(state.getContent());
            LOGGER.info("\n------------------------------Comments-----------------------\n");
            state.getComments();
            state.editDocument("\nPlace : Pune, India", true);
            state.addComments("Fixed : Added Place.");
            state.submitDocument();

            //Review 
            state = document.getDocumentState();
            LOGGER.info(state.getContent());
            LOGGER.info("\n------------------------------Comments-----------------------\n");
            state.getComments();
            state.addComments("Approved");
            state.approveDocument();

            //Approved
            state = document.getDocumentState();
            LOGGER.info(state.getContent());
            LOGGER.info("\n------------------------------Comments-----------------------\n");
            state.getComments();
            state.addComments("Add YOE...");
            state.rejectDocument(); //Send back to edits. 

            //Draft
            state = document.getDocumentState();
            LOGGER.info(state.getContent());
            LOGGER.info("\n------------------------------Comments-----------------------\n");
            state.getComments();
            state.editDocument("\n YOE : 10+ years", true);
            state.addComments("Fixed : Added YOE...");
            state.submitDocument();
            
            //Review 
            state = document.getDocumentState();
            LOGGER.info(state.getContent());
            LOGGER.info("\n------------------------------Comments-----------------------\n");
            state.getComments();
            state.addComments("Approved...");
            state.approveDocument();

            //Approved
            state = document.getDocumentState();
            LOGGER.info(state.getContent());
            LOGGER.info("\n------------------------------Comments-----------------------\n");
            state.getComments();
            state.addComments("Publish It..!!");
            state.pubilshDocument();

            //Publish
            state = document.getDocumentState();
             LOGGER.info(state.getContent());
            LOGGER.info("\n------------------------------Comments-----------------------\n");
            state.getComments();
            state.archiveDocument();

            //Archived.
            state = document.getDocumentState();
            LOGGER.info(state.getContent());
            LOGGER.info("\n------------------------------Comments-----------------------\n");
            state.getComments();
            state.addComments("Publish it again.");

        } catch (Exception e) {
            LOGGER.severe("Exception Occured :" + e.getMessage());
        }
    }
}
