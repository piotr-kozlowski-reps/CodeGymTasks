package pl.codegym.task.task17.task1722;

/* 
Policzmy
*/

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        Counter counter1 = new Counter();
        Counter counter2 = new Counter();
        Counter counter3 = new Counter();
        Counter counter4 = new Counter();

        counter1.start();
        counter2.start();
        counter3.start();
        counter4.start();

        counter1.join();
        counter2.join();
        counter3.join();
        counter4.join();

//        counter1.start();
//        try{
//            counter1.join();
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }
//
//        counter2.start();
//        try{
//            counter1.join();
//            counter2.join();
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }
//
//        counter3.start();
//        try{
//            counter1.join();
//            counter2.join();
//            counter3.join();
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }
//
//        counter4.start();
//        try{
//            counter1.join();
//            counter2.join();
//            counter3.join();
//            counter4.join();
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }


        for (int i = 1; i <= 100; i++) {
            if (values[i] != 1) {
                System.out.println("Tablica wartości zawiera elementy różne od 1");
                break;
            }
        }
    }

    public volatile static Integer count = 0;
    public static int[] values = new int[105];

    static {
        for (int i = 0; i < 105; i++) {
            values[i] = 0;
        }
    }

    public static void incrementCount() {
        count++;
    }

    public static int getCount() {
        return count;
    }

    public static class Counter extends Thread {
        @Override
        public void run() {
            do {
                synchronized (values) {
                    values[getCount()]++;
                    incrementCount();
                }

                try {
                    Thread.sleep(1);
                } catch (InterruptedException ignored) {
                }
            } while (getCount() < 101);
        }
    }
}

