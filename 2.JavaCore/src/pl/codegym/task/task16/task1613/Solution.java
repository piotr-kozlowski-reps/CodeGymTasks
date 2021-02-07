package pl.codegym.task.task16.task1613;

/* 
Big Ben
*/

public class Solution {
    public static volatile boolean isStopped = false;

    public static void main(String[] args) throws InterruptedException {
        Clock clock = new Clock("Londyn", 23, 59, 57);
        Thread.sleep(4000);
        isStopped = true;
        Thread.sleep(1000);
    }

    public static class Clock extends Thread {
        private String cityName;
        private int hours;
        private int minutes;
        private int seconds;

        public Clock(String cityName, int hours, int minutes, int seconds) {
            this.cityName = cityName;
            this.hours = hours;
            this.minutes = minutes;
            this.seconds = seconds;
            start();
        }

        public void run() {
            try {
                while (!isStopped) {
                    printTime();
                }
            } catch (InterruptedException e) {
            }
        }

        private void printTime() throws InterruptedException {

                // blok dodawania czasu
                if (seconds >= 0 && seconds < 59){
                    seconds++;
                } else {
                    seconds = 0;
                    if (minutes >= 0 && minutes < 59){
                        minutes++;
                    } else {
                        minutes = 0;
                        if (hours >= 0 && hours < 23){
                            hours++;
                        } else {
                            hours = 0;
                        }
                    }
                }

                Thread.sleep(1000);

                if (hours == 0 && minutes == 0 && seconds == 0) {
                    System.out.println(String.format("Wybiła północ w %s!", cityName));
                } else {
                    System.out.println(String.format("W %s jest teraz godzina %02d:%02d:%02d!", cityName, hours, minutes, seconds));
                }




        }
    }
}
