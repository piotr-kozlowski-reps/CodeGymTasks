package com.codegym.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution{
    public static List<Thread> threads = new ArrayList<>(5);

    static{

        Thread thread1 = new Thread(new Thread1());
        threads.add(thread1);

        Thread thread2 = new Thread(new Thread2());
        threads.add(thread2);

        Thread thread3 = new Thread(new Thread3());
        threads.add(thread3);

        Thread thread4 = new Thread4();
        threads.add(thread4);


//        Thread thread4 = new Thread(new Thread4());
//        threads.add(thread4);

        Thread thread5 = new Thread(new Thread5());
        threads.add(thread5);


    }

    public static void main(String[] args) throws Exception{

        threads.get(0).start();                     //rusza thread1
        threads.get(1).start();                     //rusza thread2
        threads.get(2).start();                     //rusza thread3
        threads.get(3).start();                     //rusza thread4
        threads.get(4).start();                     //rusza thread5

    }

    static class Thread1 implements Runnable{
        @Override
        public void run() {
            while(true){

            }
        }
    }

    static class Thread2 implements Runnable{
        @Override
        public void run(){
            try{
                while (true){
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e){
                System.out.println("InterruptedException");
            }
        }
    }

    static class Thread3 implements Runnable{
        @Override
        public void run() {
            try{
                while (true){
                    System.out.println("Hurray");
                    Thread.sleep(500);
                }
            } catch (InterruptedException e){
            }
        }
    }


    public static class Thread4 extends Thread implements Message{

        @Override
        public void run() {
            while (isAlive()) {
                // showWarning();
            }
        }

        @Override
        public void showWarning() {
            this.stop();
        }
    }


    static class Thread5 implements Runnable{
        @Override
        public void run() {
            List<Integer> listaLiczb = new ArrayList<Integer>();

            try{
                BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
                String linia;
                while (!((linia = bf.readLine()) == "N")){
                    listaLiczb.add(Integer.parseInt(linia));
                }
                bf.close();
            } catch (Exception e){
                e.printStackTrace();
            }
            Integer suma = new Integer(0);
            for (Integer liczba : listaLiczb){
                suma += liczba;
            }
            System.out.println(suma);

        }
    }


}