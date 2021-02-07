package com.codegym.task.task32.task3209.actions;

import com.codegym.task.task32.task3209.View;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class UndoAction extends AbstractAction {

    //fields
    private View view;


    //constructors
    public UndoAction(View view){
        this.view = view;
    }


    //
    @Override
    public void actionPerformed(ActionEvent e) {
        view.undo();
    }

}
