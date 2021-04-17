package com.codegym.task.task34.task3410.model;

import java.awt.*;

public class StorageLocation extends GameObject{


    //constr
    public StorageLocation(int x, int y) {
        super(x, y, 2, 2);
    }

    //
    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.RED);
        graphics.drawOval(x, y, width, height);

    }
}


