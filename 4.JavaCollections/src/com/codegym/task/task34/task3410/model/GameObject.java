package com.codegym.task.task34.task3410.model;

import com.codegym.task.task34.task3410.controller.Controller;

import java.awt.*;

public abstract class GameObject {

    //fields
    int x;
    int y;
    int width;
    int height;

    //set/get
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }

    //constr
    public GameObject(int x, int y) {
        this.x = x;
        this.y = y;
        width = Model.BOARD_CELL_SIZE;
        height = Model.BOARD_CELL_SIZE;
    }
    public GameObject(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    //
    public abstract void draw(Graphics graphics);
}
