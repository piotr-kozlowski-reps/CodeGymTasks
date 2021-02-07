package com.codegym.task.task30.task3004;

import java.util.concurrent.RecursiveTask;

public class BinaryRepresentationTask extends RecursiveTask<String> {

    private int x;

    public BinaryRepresentationTask(int x) {
        this.x = x;
    }

    @Override
    protected String compute() {

        int a = x % 2;
        int b = x / 2;

        String result = String.valueOf(a);

        if (b > 0) {
            BinaryRepresentationTask binaryRepresentationTask = new BinaryRepresentationTask(b);
            binaryRepresentationTask.fork();
            return binaryRepresentationTask.join() + result;
        }

        return result;
    }
}