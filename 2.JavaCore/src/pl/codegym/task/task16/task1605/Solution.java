package pl.codegym.task.task16.task1605;

import java.util.Date;

/* 
Porozmawiajmy o muzyce
*/

public class Solution {
    public static int delay = 1000;

    public static void main(String[] args) {
        Thread violin = new Thread(new Violin("Muzyk"));
        violin.start();
    }

    public static void sleepNSeconds(int n) {
        try {
            Thread.sleep(n * delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public interface MusicalInstrument extends Runnable {
        Date startPlaying();

        Date stopPlaying();
    }

    public static class Violin implements MusicalInstrument{
        private String owner;

        public Violin(String owner) {
            this.owner = owner;
        }

        public Date startPlaying() {
            System.out.println(this.owner + " zaczyna grać");
            return new Date();
        }

        public Date stopPlaying() {
            System.out.println(this.owner + " przestaje grać");
            return new Date();
        }

        public void run(){
            Date poczatekGrania = startPlaying();
            sleepNSeconds(1);
            Date koniecGrania = stopPlaying();
            long dlugosc = koniecGrania.getTime() - poczatekGrania.getTime();
            System.out.println("Grałeś przez " + dlugosc + " ms");
        }
    }
}
