package com.codegym.task.task32.task3209.listeners;

import com.codegym.task.task32.task3209.View;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FrameListener extends WindowAdapter {

    //fields
    private View view;


    //constructors
    public FrameListener(View view){
        this.view = view;
    }


    //


    @Override
    public void windowClosing(WindowEvent windowEvent) {
        view.exit();
    }
}
