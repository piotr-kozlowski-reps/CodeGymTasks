package com.codegym.task.task25.task2511;

import java.util.TimerTask;

/* 
Arming ourselves to the teeth!

*/

public class Solution extends TimerTask {
    protected TimerTask original;
    protected final Thread.UncaughtExceptionHandler handler;

    public Solution(TimerTask original) {
        if (original == null) {
            throw new NullPointerException();
        }
        this.original = original;
        this.handler = new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {

                String description = e.getMessage();
                int howManyCharsInThreadName = t.getName().length();

                StringBuilder asterixes = new StringBuilder();
                for (int i = 0; i < howManyCharsInThreadName; i++){
                    asterixes.append("*");
                }

                System.out.println(description.replace(t.getName(), asterixes.toString()));

            }
        };
    }

    public void run() {
        try {
            original.run();
        } catch (Throwable cause) {
            Thread currentThread = Thread.currentThread();
            handler.uncaughtException(currentThread, new Exception("Blah " + currentThread.getName() + " blah-blah-blah", cause));
        }
    }

    public long scheduledExecutionTime() {
        return original.scheduledExecutionTime();
    }

    public boolean cancel() {
        return original.cancel();
    }

    public static void main(String[] args) {

    }
}
