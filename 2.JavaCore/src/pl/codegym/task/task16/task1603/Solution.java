package pl.codegym.task.task16.task1603;

import java.util.ArrayList;
import java.util.List;

/* 
Lista i kilka wątków
*/

public class Solution {
    public static volatile List<Thread> list = new ArrayList<>(5);

    public static void main(String[] args) {

        SpecialThread sp1 = new SpecialThread();
        Thread thr1 = new Thread(sp1);
        list.add(thr1);

        SpecialThread sp2 = new SpecialThread();
        Thread thr2 = new Thread(sp2);
        list.add(thr2);

        SpecialThread sp3 = new SpecialThread();
        Thread thr3 = new Thread(sp3);
        list.add(thr3);

        SpecialThread sp4 = new SpecialThread();
        Thread thr4 = new Thread(sp4);
        list.add(thr4);

        SpecialThread sp5 = new SpecialThread();
        Thread thr5 = new Thread(sp5);
        list.add(thr5);

    }

    public static class SpecialThread implements Runnable {
        public void run() {
            System.out.println("To jest metoda run wewnątrz SpecialThread");
        }
    }
}
