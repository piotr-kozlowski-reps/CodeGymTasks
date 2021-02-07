package com.codegym.task.task25.task2506;

import javax.swing.plaf.nimbus.State;

public class LoggingStateThread extends Thread{

    private Thread monitoredThread;

    public LoggingStateThread(Thread monitoredThread){
        this.monitoredThread = monitoredThread;
    }

    @Override
    public void run() {
//        this.execute = true;

        State currentState = monitoredThread.getState();
        System.out.println(currentState);

        State newState;
        do{
            if ((newState = monitoredThread.getState()) != currentState){
                currentState = newState;
                System.out.println(currentState);
            }
        } while (monitoredThread.getState() != State.TERMINATED);
    }
}