package com.codegym.task.task32.task3209.listeners;

import com.codegym.task.task32.task3209.View;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

public class UndoMenuListener implements MenuListener{

    //fields
    private View view;
    private JMenuItem undoMenuItem;
    private JMenuItem redoMenuItem;

    //constructors
    public UndoMenuListener(View view, JMenuItem undoMenuItem, JMenuItem redoMenuItem){
        this.view = view;
        this.undoMenuItem = undoMenuItem;
        this.redoMenuItem = redoMenuItem;
    }


    //
    @Override
    public void menuSelected(MenuEvent e) {

        if(!view.canUndo()){
            undoMenuItem.setEnabled(false);
        } else {
            undoMenuItem.setEnabled(true);
        }


        if(!view.canRedo()){
            redoMenuItem.setEnabled(false);
        } else {
            redoMenuItem.setEnabled(true);
        }

    }

    @Override
    public void menuDeselected(MenuEvent e) {

    }

    @Override
    public void menuCanceled(MenuEvent e) {

    }
}
