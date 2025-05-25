package DesignPattern.BehavioralPatterns.MementoEditor;

import java.util.ArrayDeque;
import java.util.Deque;

public class EditorCareTaker {
    private final Deque<Editor.EditorMemento> history;
    private final Editor editor;

    EditorCareTaker(Editor editor) {
        history = new ArrayDeque<>();
        this.editor = editor;
    }

    public void takeEditorSnapshot(Editor.EditorMemento memento) {
        history.push(memento);
    }

    public void restore() {
        if (history.isEmpty()) {
            return;
        }
        editor.undo(history.pop());
    }

}
