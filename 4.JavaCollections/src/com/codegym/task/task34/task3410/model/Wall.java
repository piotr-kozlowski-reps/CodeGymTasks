package com.codegym.task.task34.task3410.model;

import java.awt.*;

public class Wall extends CollisionObject{


    //constr
    public Wall(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(new Color(145, 80, 15));
        graphics.drawRect(x, y, width, height);
    }
}

