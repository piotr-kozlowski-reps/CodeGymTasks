package com.codegym.task.task34.task3410.view;

import com.codegym.task.task34.task3410.controller.EventListener;
import com.codegym.task.task34.task3410.model.Player;
import com.codegym.task.task34.task3410.model.Box;

import javax.swing.*;
import java.awt.*;

public class Board extends JPanel {

    //fields
    private View view;
    private EventListener eventListener;

    //constr
    public Board(View view) {
        this.view = view;
    }

    public void setEventListener(EventListener eventListener) {
        this.eventListener = eventListener;
    }

    public void paint(Graphics g) {

        //todo: wywal
//        Player player = new Player(20, 20);
//        player.draw(g);
//        Box box = new Box(100, 100);
//        box.draw(g);

    }


}
