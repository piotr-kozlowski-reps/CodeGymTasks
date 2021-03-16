package com.codegym.task.task37.task3710.decorators;

import com.codegym.task.task37.task3710.shapes.Shape;

public class RedShapeDecorator extends ShapeDecorator {

    //fields
    private Shape decoratedShape;

    //constr
    public RedShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
        this.decoratedShape = decoratedShape;
    }


    @Override
    public void draw() {
        setBorderColor(decoratedShape);
        decoratedShape.draw();
    }

    private void setBorderColor(Shape shape) {

        String className = shape.getClass().getSimpleName();
        System.out.println(String.format("Setting the border color for %s to red.", className));

    }

}




//3) Override the draw method. First, use the setBorderColor method to change the color
// of the object being displayed, and then draw it.

//2. The setBorderColor method must display the phrase outlined in the task condition.
//3. The setBorderColor method must be private.
//4. In the RedShapeDecorator class's draw method, the color of the decorated object must
// be changed and its draw method called.
//5. The RedShapeDecorator class's public constructor must accept one Shape argument.
