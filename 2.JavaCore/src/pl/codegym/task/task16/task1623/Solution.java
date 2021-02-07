package pl.codegym.task.task16.task1623;

/* 
Rekurencyjne tworzenie wątków
*/

public class Solution {
    static int count = 15;
    static volatile int createdThreadCount = 0;

    public static void main(String[] args) {
        System.out.println(new GenerateThread());
    }

    public static class GenerateThread extends Thread{


        public GenerateThread(){
            super(String.valueOf(++createdThreadCount));
            start();
        }

        @Override
        public String toString() {
            return getName() + " utworzony";
        }

        public void run(){
            if (createdThreadCount < Solution.count) {
 //               new GenerateThread();
                System.out.println(new GenerateThread());
            }
        }
    }
}
