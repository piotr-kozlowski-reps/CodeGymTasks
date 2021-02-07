package com.codegym.task.task25.task2514;

/* 
Finagle's first law: if an experiment succeeds, then something went wrong...

*/

//Finagle's first law: if an experiment succeeds, then something went wrong...
//Ensure the time slice is surrendered (yield the right of way to the current thread) for consistent console output.
//
//
//Requirements:
//1. The Solution class must have a nested YieldRunnable class that implements the Runnable interface.
//2. The YieldRunnable class must have a field with an index that is initialized through the constructor.
//3. The run() method should display messages with the current index at the beginning and end of the method.
//4. Thread.yield() must be called at the right place.


public class Solution {
    public static class YieldRunnable implements Runnable {
        private int index;

        public YieldRunnable(int index) {
            this.index = index;
        }

        public void run() {
            System.out.println("begin-" + index);
            Thread.yield();
            System.out.println("end-" + index);
        }
    }

    public static void main(String[] args) {
    }
}
