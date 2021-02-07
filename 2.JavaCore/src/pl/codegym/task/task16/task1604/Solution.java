package pl.codegym.task.task16.task1604;

/* 
Wyświetlanie śladu stosu
*/

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new SpecialThread());
        thread.start();

        System.out.println("*****************");

        for (StackTraceElement element : Thread.currentThread().getStackTrace()) {
            System.out.println(element);
        }
    }

    public static class SpecialThread implements Runnable{

        public void run(){
            for (StackTraceElement element2 : Thread.currentThread().getStackTrace()){
                System.out.println(element2);
            }
        }

    }
}
