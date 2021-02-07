package pl.codegym.task.task16.task1616;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Liczenie sekund
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(in);
        // Tworzy i uruchamia wątek
        Stopwatch stopwatch = new Stopwatch();
        stopwatch.start();
        // Wczytuje ciąg
        reader.readLine();
        stopwatch.interrupt();
        // Zamyka strumienie
        reader.close();
        in.close();
    }

    public static class Stopwatch extends Thread {
        private int seconds;

        public void run() {
            try {
                while (true){
                    Thread.sleep(1000);
                    seconds += 1;
                }
            } catch (InterruptedException e) {
                System.out.println(seconds);
            }
        }
    }
}
