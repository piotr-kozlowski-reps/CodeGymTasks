package com.codegym.task.task32.task3209.listeners;

import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;
import javax.swing.undo.UndoableEdit;

public class UndoListener implements UndoableEditListener {

    //fields
    private UndoManager undoManager;

    //constructors
    public UndoListener(UndoManager undoManager){
        this.undoManager = undoManager;
    }

    //
    @Override
    public void undoableEditHappened(UndoableEditEvent e) {
        undoManager.addEdit(e.getEdit());
    }
}