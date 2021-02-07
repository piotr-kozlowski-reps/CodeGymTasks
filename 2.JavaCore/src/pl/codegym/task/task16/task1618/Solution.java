package pl.codegym.task.task16.task1618;

/* 
Kolejne przerwanie
*/

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        TestThread test = new TestThread();
        test.start();
        test.interrupt();
    }

    //tutaj wpisz swój kod
    public static class TestThread extends Thread{

        public void run(){

        }
    }
}