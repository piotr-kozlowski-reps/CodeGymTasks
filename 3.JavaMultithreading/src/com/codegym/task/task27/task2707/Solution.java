package com.codegym.task.task27.task2707;

/* 
Determining locking order

*/

import java.util.concurrent.atomic.AtomicBoolean;

public class Solution {

    public void someMethodWithSynchronizedBlocks(Object obj1, Object obj2) {
        synchronized (obj1) {
            synchronized (obj2) {
                System.out.println(obj1 + " " + obj2);
            }
        }
    }

    public static boolean isLockOrderNormal(final Solution solution, final Object o1, final Object o2) throws Exception {

        Solution solutionForTestind = new Solution();
        AtomicBoolean areBothThreadsLocked = new AtomicBoolean(true);

        Thread threadSynchronizingO2 = new Thread(){
            @Override
            public void run() {

                synchronized (o2){

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        };



        Thread threadRunMethodTested = new Thread() {
            @Override
            public void run() {
                solution.someMethodWithSynchronizedBlocks(o1, o2);
            }
        };




        Thread threadcheckingIfBothObjectsAreLocked = new Thread(){
            @Override
            public void run() {

/*                try{
                    Thread.sleep(50);
                } catch (InterruptedException ignored){}*/

                synchronized (o1){
                    areBothThreadsLocked.set(false);
                }

            }
        };

        threadSynchronizingO2.start();
        threadRunMethodTested.start();
        threadcheckingIfBothObjectsAreLocked.start();

        try{
            Thread.sleep(20);
        } catch (InterruptedException ignored){}


        if (areBothThreadsLocked.get()) return true;
        else return false;

    }

    public static void main(String[] args) throws Exception {
        final Solution solution = new Solution();
        final Object o1 = new Object();
        final Object o2 = new Object();

        System.out.println(isLockOrderNormal(solution, o1, o2));
    }
}
