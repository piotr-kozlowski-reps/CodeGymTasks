package pl.codegym.task.task16.task1620;

import java.util.ArrayList;
import java.util.List;

/* 
Jeden za wszystkich, wszyscy za jednego
*/

public class Solution {
    public static byte threadCount = 3;
    static List<Thread> threads = new ArrayList<>(threadCount);

    public static void main(String[] args) throws InterruptedException {
        initThreadsAndStart();
        Thread.sleep(3000);
        ourInterrupt();
    }

    public static void ourInterrupt() {
        try{
            for (Thread watek : threads){
                watek.interrupt();
            }
        } catch (Exception ignore){
        }
    }

    private static void initThreadsAndStart() {
        Water water = new Water("woda");
        for (int i = 0; i < threadCount; i++) {
            threads.add(new Thread(water, "#" + i));
        }

        for (int i = 0; i < threadCount; i++) {
            threads.get(i).start();
        }
    }

    public static class Water implements Runnable {
        private String sharedResource;

        public Water(String sharedResource) {
            this.sharedResource = sharedResource;
        }

        public void run() {
            //popraw 2 zmienne
            boolean isCurrentThreadInterrupted = Thread.currentThread().isInterrupted();
            String threadName = Thread.currentThread().getName();

            try {
                while (!isCurrentThreadInterrupted) {

                    System.out.println("Obiekt " + sharedResource + ", wątek " + threadName);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
            }
        }
    }
}
