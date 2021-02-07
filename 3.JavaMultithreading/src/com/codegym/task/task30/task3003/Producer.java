package com.codegym.task.task30.task3003;

import java.util.concurrent.TransferQueue;

public class Producer implements Runnable {

    private TransferQueue<SharedItem> queue;

    public Producer(TransferQueue<SharedItem> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {

        try {

            for (int i = 1; i <= 9; i++) {

                if (Thread.currentThread().isInterrupted()) break;

                String name = String.format("SharedItem-%d", i);
                SharedItem sharedItem = new SharedItem(name, i);
                System.out.format("'SharedItem-%d' added" + "\n", i);

                queue.offer(sharedItem);

                Thread.sleep(100);

                if (this.queue.hasWaitingConsumer()) {
                    System.out.format("Consumer is waiting!" + "\n");
                }

            }

        } catch (InterruptedException e){}


    }
}