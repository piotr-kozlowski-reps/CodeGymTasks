package com.codegym.task.task29.task2912;

public abstract class AbstractLogger implements Logger{

    //fields
    int level;
    Logger next;


    @Override
    public void inform(String message, int level) {
        if (this.level <= level) {
            info(message);
        }
        if (next != null) {
            next.inform(message, level);
        }
    }

    @Override
    public void setNext(Logger next) {
        this.next = next;
    }


}
