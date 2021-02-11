package com.codegym.task.task22.task2213;

public class GamePiece {

    //vars
    private int x;
    private int y;
    private int[][] matrix;

    //set/get
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public int[][] getMatrix() {
        return matrix;
    }

    //constr
    public GamePiece(int x, int y, int[][] matrix) {
        this.x = x;
        this.y = y;
        this.matrix = matrix;
    }


    //
    public void left(){}

    public void right(){}

    public void down(){}

    public void up(){}

    public void rotate(){}

    public void downMaximum(){}

    public boolean isCurrentPositionAvailable(){return true;}

    public void land(){}

}