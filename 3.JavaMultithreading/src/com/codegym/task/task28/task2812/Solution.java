package com.codegym.task.task28.task2812;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* 
shutdownNow!

*/

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 1; i <= 10; i++) {
            final int localId = i;
            executor.submit(new Runnable() {
                public void run() {
                    doExpensiveOperation(localId);
                }
            });
        }

        List<Runnable> listOfStoppedTasks = executor.shutdownNow();
        for (Runnable taskStopped : listOfStoppedTasks){
            System.out.println(taskStopped + " was not completed");
        }

    }

    private static void doExpensiveOperation(int localId) {
        System.out.println(Thread.currentThread().getName() + ", localId="+localId);
    }
}

//shutdownNow!
//Understand the difference between the shutdown and shutdownNow methods. Display a list of all the incomplete tasks on the screen.
//
//It should look something like:
//
//pool-1-thread-1, localId=1
//pool-1-thread-2, localId=2
//pool-1-thread-3, localId=3
//pool-1-thread-4, localId=4
//pool-1-thread-5, localId=5
//java.util.concurrent.FutureTask@7e6cbb7a was not completed
//java.util.concurrent.FutureTask@7c3df479 was not completed
//java.util.concurrent.FutureTask@7106e68e was not completed
//java.util.concurrent.FutureTask@7eda2dbb was not completed
//java.util.concurrent.FutureTask@6576fe71 was not completed
//
//Requirements:
//1. The executor object's shutdownNow method must be called in the Solution class's main method.
//2. The Solution class's main method must display all of the tasks that the executor didn't have time to execute.
//3. The main method must be public.
//4. The main method must be static.
