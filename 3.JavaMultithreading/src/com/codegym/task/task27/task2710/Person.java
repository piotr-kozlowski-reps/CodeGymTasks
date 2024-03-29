package com.codegym.task.task27.task2710;

import java.util.concurrent.BlockingQueue;

public class Person implements Runnable {
    private final Mail mail;

    public Person(Mail mail) {
        this.mail = mail;
    }

    @Override
    public void run() {


            String name = Thread.currentThread().getName();

            try {
                Thread.sleep(1000);

                synchronized (mail){
                    mail.setText("Person [" + name + "] wrote an email 'AAA'");
                    mail.notify();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }


    }
}
