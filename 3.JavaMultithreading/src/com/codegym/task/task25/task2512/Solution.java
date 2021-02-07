package com.codegym.task.task25.task2512;

/* 
Charting our own course

*/

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {

        //1. Interrupt the thread that threw the exception.
        t.interrupt();

        //2. Display the exception's stack trace, starting with the innermost exception.
        List<Throwable> listOfThrowables = new LinkedList<>();
        listOfThrowables.add(e);

        Throwable temporaryThrowable = e.getCause();
        while (temporaryThrowable != null){
            listOfThrowables.add(temporaryThrowable);
            temporaryThrowable = temporaryThrowable.getCause();
        }
        Collections.reverse(listOfThrowables);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < listOfThrowables.size(); i++){
            if (i < listOfThrowables.size() - 1) result.append(listOfThrowables.get(i).getClass().getName()).append(": ").append(listOfThrowables.get(i).getMessage()).append("\n");
            else result.append(listOfThrowables.get(i).getClass().getName()).append(": ").append(listOfThrowables.get(i).getMessage());
        }

        System.out.println(result.toString());
        }


    public static void main(String[] args) throws Exception{
    }
}