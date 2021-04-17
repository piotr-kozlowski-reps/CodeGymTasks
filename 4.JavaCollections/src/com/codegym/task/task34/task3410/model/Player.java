package com.codegym.task.task34.task3410.model;

import java.awt.*;

public class Player extends CollisionObject implements Movable{


    //constr
    public Player(int x, int y) {
        super(x, y);
    }

    //
    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.blue);
        graphics.drawOval(x, y, width, height);
    }

    @Override
    public void move(int x, int y) {
        this.x += x;
        this.y += y;
    }
}




//Hint: you can draw the player as a solid yellow circle, and boxes — as orange squares with diagonals. But these
// are just examples. You can choose the colors yourself. The appearance of your objects is limited only by your
// imagination and the methods available in the Graphics class.
//
//To check how your box and player are drawn, you can create a Box or Player object in the Board class's paint() method
// and call the object's draw() method. Do this only do to test the draw() methods. We'll implement the paint() method differently in the future.
//
//
//Requirements:
//1. Create a Player class and a Box class in the model package. Make each of them inherit the most appropriate class.
//2. The Player and Box classes must support the interface responsible for object movement.
//3. Add Player and Box class constructors that accept int x and int y arguments.
//4. In the Player and Box classes, implement the method responsible for movement. It must shift the object's (x, y)
// coordinates by the passed values.
//5. In the Player and Box classes, implement the method responsible for drawing.