package com.codegym.task.task32.task3209.listeners;

import com.codegym.task.task32.task3209.View;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class TabbedPaneChangeListener implements ChangeListener {

    //fields
    private View view;

    //constructors
    public TabbedPaneChangeListener(View view){
        this.view = view;
    }


    //
    @Override
    public void stateChanged(ChangeEvent e) {
        view.selectedTabChanged();
    }
}
