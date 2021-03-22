package com.codegym.task.task38.task3803;

/* 
Runtime exceptions (unchecked exceptions)

*/

public class VeryComplexClass {
    public void methodThrowsClassCastException() {

        Object x = new Integer(12);
        System.out.println((String) x);


    }

    public void methodThrowsNullPointerException() {
        String stringA = null;
        String[] x = stringA.split("\\s+");

    }

    public static void main(String[] args) {

    }
}