package com.codegym.task.task27.task2712.kitchen;

public enum Dish {
    Fish(25),
    Steak(30),
    Soup(15),
    Juice(5),
    Water(3);

    private int duration;

    public int getDuration() {
        return duration;
    }

    private Dish(int duration) {
        this.duration = duration;
    }

    public static String allDishesToString() {
        String result = "";

        for (com.codegym.task.task27.task2712.kitchen.Dish dish : com.codegym.task.task27.task2712.kitchen.Dish.values()) {
            if ("".equals(result)) {
                result += dish.name();
            } else {
                result += ", " + dish.name();
            }
        }
        return result;
    }
}
