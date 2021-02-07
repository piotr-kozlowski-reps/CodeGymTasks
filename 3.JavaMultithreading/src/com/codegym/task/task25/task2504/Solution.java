package com.codegym.task.task25.task2504;

/* 
A switch for threads

*/

public class Solution {
    public static void processThreads(Thread... threads) {
        for (Thread threadFromArray : threads){

            switch (threadFromArray.getState()){

                case NEW:
                    threadFromArray.start();
                    break;

                case WAITING:
                    threadFromArray.interrupt();
                    break;

                case TIMED_WAITING:
                    threadFromArray.interrupt();
                    break;

                case BLOCKED:
                    threadFromArray.interrupt();
                    break;

                case RUNNABLE:
                    threadFromArray.isInterrupted();
                    break;

                case TERMINATED:
                    System.out.println(threadFromArray.getPriority());
            }
        }
    }

    public static void main(String[] args) {

    }
}
