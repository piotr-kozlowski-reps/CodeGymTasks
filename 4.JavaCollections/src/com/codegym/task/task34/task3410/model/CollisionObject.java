package com.codegym.task.task34.task3410.model;

public abstract class CollisionObject extends GameObject{

    //constr
    public CollisionObject(int x, int y) {
        super(x, y);
    }

    //
    public boolean isCollision(GameObject gameObject, Direction direction) {

        switch (direction) {
            case LEFT:
                return ((x - Model.BOARD_CELL_SIZE) == gameObject.getX()) && (y == gameObject.getY());
            case RIGHT:
                return ((x + Model.BOARD_CELL_SIZE) == gameObject.getX()) && (y == gameObject.getY());
            case UP:
                return ((x == gameObject.getX()) && (gameObject.getY() == (y - Model.BOARD_CELL_SIZE)));
            case DOWN:
                return ((x == gameObject.getX()) && (gameObject.getY() == (y + Model.BOARD_CELL_SIZE)));
        }

        return false;

    }
}

