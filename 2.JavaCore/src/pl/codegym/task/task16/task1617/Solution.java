package pl.codegym.task.task16.task1617;

/* 
Odliczanie na wyścigach
*/

public class Solution {
    public static volatile int numSeconds = 4;

    public static void main(String[] args) throws InterruptedException {
        RacingClock clock = new RacingClock();
        Thread.sleep(3500);
        clock.interrupt();
    }

    public static class RacingClock extends Thread {
        public RacingClock() {
            start();
        }

        public void run() {

            try{

                while(numSeconds >= 0){

                    if (numSeconds > 0) {
                        System.out.print(numSeconds + " ");
                        numSeconds--;
                        Thread.sleep(1000);
                    } else {
                        System.out.print("Start!");
                        return;
                    }

                }

/*                for (int i = numSeconds; i >= 0; i--) {
                    if (i == numSeconds) {
                        System.out.print(i);
                        Thread.sleep(1000);
                    } else if (i < numSeconds && i > 0) {
                        System.out.print(" " + i);
                        Thread.sleep(1000);
                    } else {
                        System.out.print(" Start!");
                    }
                }*/

            } catch (InterruptedException e){
                System.out.print("Przerwane!");
            }

        }
    }
}
