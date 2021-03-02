package com.codegym.task.task35.task3512;

public class Generator<T> {

    Class<T> clazz;

    public Generator(Class<T> clazz) {
        this.clazz = clazz;
    }


    T newInstance() {

        T newInstanceCreated = null;

        try {
            newInstanceCreated = clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return newInstanceCreated;
    }
}
