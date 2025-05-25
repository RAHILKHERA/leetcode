package DesignPattern.BehavioralPatterns.MementoEditor;

import java.util.Date;

public class Editor {
    private StringBuilder content;

    Editor() {
        content = new StringBuilder();
    }

    private void init() {
        content.setLength(0);
    }

    public void type(String text) {
        content.append(text);
    }

    private void setText(String text) {
        init();
        type(text);
    }

    public String getText() {
        return content.toString();
    }

    public EditorMemento createSnapshot() {
        return new EditorMemento(this.content.toString());
    }

    public void undo(EditorMemento memento) {
        setText(memento.getContent());
    }

    static class EditorMemento {

        private final String content;
        private final Date timeStamp;

        EditorMemento(String content) {
            this.content = content;
            this.timeStamp = new Date();
        }

        public String getContent() {
            return content;
        }

        public Date getTimeStamp() {
            return timeStamp;
        }
    }
}
