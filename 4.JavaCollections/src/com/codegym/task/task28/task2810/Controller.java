package com.codegym.task.task28.task2810;

import com.codegym.task.task28.task2810.model.Model;

public class Controller {

    //fields
    Model model;

    //constr
    public Controller(Model model) throws IllegalArgumentException{
        this.model = model;
        if (model == null) throw new IllegalArgumentException();
    }


    //
    public void onCitySelected(String cityName) {
        model.selectCity(cityName);
    }

}