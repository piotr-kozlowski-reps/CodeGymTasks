package com.codegym.task.task25.task2515;

import com.fasterxml.jackson.databind.ser.Serializers;

public abstract class BaseObject {

    //fields
    private double x;
    private double y;
    private double radius;
    private boolean isAlive;

    //constr
    public BaseObject(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        isAlive = true;
    }

    //set/get
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public double getRadius() {
        return radius;
    }
    public boolean isAlive() {
        return isAlive;
    }

    public void setX(double x) {
        this.x = x;
    }
    public void setY(double y) {
        this.y = y;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }


    //
    public void draw() {
    }

    public void move() {
    }

    public void die() {
        isAlive = false;
    }

    public boolean intersects(Object o) {
        return
        distance_between_objects < max(radius_of_the_first_object, radius_of_the_second_object).
    }

}
