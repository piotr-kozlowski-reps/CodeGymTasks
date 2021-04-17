package com.codegym.task.task34.task3410.controller;

import com.codegym.task.task34.task3410.model.Direction;
import com.codegym.task.task34.task3410.model.Model;
import com.codegym.task.task34.task3410.view.View;


public class Controller implements EventListener{

    //fields
    private View view;
    private Model model;

    //constr
    public Controller() {
        view = new View(this);
        model = new Model();
        view.init();
    }

    //
    public static void main(String[] args) {
        Controller controller = new Controller();
    }


    @Override
    public void move(Direction direction) {

    }

    @Override
    public void restart() {

    }

    @Override
    public void startNextLevel() {

    }

    @Override
    public void levelCompleted(int level) {

    }
}


//9.3. Add the EventListener interface to the Controller class, and write the stubs required to implement the interface.
//9.4. Add an EventListener eventListener field to the Model and Board classes.
//9.5. Add the setEventListener(EventListener eventListener) method to the Model, View, and Board classes. In the View class,
// this method must call the analogous method on the board object. In the Model and Field classes, it must set the value of
// the internal eventListener fields.

//3. Add the EventListener interface to the Controller class, and write the stubs required to implement the interface.
//4. Add an EventListener eventListener field to the Model and Board classes.
//5. Implement the setEventListener(EventListener eventListener) method in the Model, View and Board classes.