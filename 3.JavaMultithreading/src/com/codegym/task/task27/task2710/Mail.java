package com.codegym.task.task27.task2710;

public class Mail {
    private volatile String text;

    public synchronized String getText() {
        return text;
    }

    public synchronized void setText(String text) {
        this.text = text;
    }
}
