package com.javarush.task.task32.task3209.listeners;

import com.javarush.task.task32.task3209.actions.UndoAction;

import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

/**
 * Created by work on 16.02.2017.
 */
public class UndoListener implements UndoableEditListener {

    private UndoManager undoManager;

    public UndoListener(UndoManager undoManager) {
        this.undoManager = undoManager;
    }

    @Override
    public void undoableEditHappened(UndoableEditEvent e) {
        undoManager.addEdit(e.getEdit());

    }
}
