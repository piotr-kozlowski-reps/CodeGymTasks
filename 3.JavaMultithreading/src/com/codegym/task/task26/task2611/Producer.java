package com.codegym.task.task26.task2611;

import java.util.concurrent.ConcurrentHashMap;

public class Producer implements Runnable{

    private ConcurrentHashMap<String, String> map;

    public Producer (ConcurrentHashMap<String, String> map){
        this.map = map;
    }


    @Override
    public void run() {

        try{
            int counter = 1;
            while (true){
                map.put(String.valueOf(counter++), String.format("Some text for %d", counter - 1));
                Thread.sleep(500);
            }

        } catch (InterruptedException exc){
            System.out.println(String. format("%s thread was terminated", Thread.currentThread().getName()));
        }

    }
}
