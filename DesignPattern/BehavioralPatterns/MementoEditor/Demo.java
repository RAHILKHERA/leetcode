package DesignPattern.BehavioralPatterns.MementoEditor;

import java.util.logging.Logger;

public class Demo {
    
    private static final Logger LOGGER = Logger.getLogger("Demo");

    public static void main(String[] args) {
        Editor editor = new Editor();
        EditorCareTaker editorCareTaker = new EditorCareTaker(editor);

        editor.type("Hello");
        editor.type(" World");
        LOGGER.info(editor.getText());

        editorCareTaker.takeEditorSnapshot(editor.createSnapshot());

        editor.type(" Software Engineering");
        LOGGER.info(editor.getText());
        
        
        editorCareTaker.restore();
        LOGGER.info(editor.getText());

    }
}
