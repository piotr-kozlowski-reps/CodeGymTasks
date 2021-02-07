package pl.codegym.task.task16.task1626;

import java.nio.channels.ScatteringByteChannel;

public class Solution {
    public static int number = 5;

    public static void main(String[] args) {
        new Thread(new CountdownRunnable(), "Zmniejsz").start();
        new Thread(new CountUpRunnable(), "Zwiększ").start();
    }

    public static class CountUpRunnable implements Runnable{
        private int countUpIndex = 1;

        public void run(){
            try{
//                Thread.currentThread().join();
                while(true){
                    System.out.println(Thread.currentThread().getName() + ": " + countUpIndex);
                    countUpIndex++;
                    Thread.sleep(500);
                    if(countUpIndex == Solution.number + 1) return;
                }
            } catch (InterruptedException e){
            }
        }

    }


    public static class CountdownRunnable implements Runnable {
        private int countdownIndex = Solution.number;

        public void run() {
            try {
                Thread.sleep(2500);
                while (true) {
                    System.out.println(toString());
                    countdownIndex -= 1;
                    if (countdownIndex == 0) return;
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
            }
        }

        public String toString() {
            return Thread.currentThread().getName() + ": " + countdownIndex;
        }
    }
}
