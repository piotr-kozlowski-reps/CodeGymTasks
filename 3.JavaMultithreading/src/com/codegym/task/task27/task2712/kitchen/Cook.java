package com.codegym.task.task27.task2712.kitchen;

import com.codegym.task.task27.task2712.ConsoleHelper;
import com.codegym.task.task27.task2712.Tablet;
import com.codegym.task.task27.task2712.statistics.StatisticsManager;
import com.codegym.task.task27.task2712.statistics.event.OrderReadyEventDataRow;

import java.util.concurrent.LinkedBlockingQueue;

public class Cook implements Runnable {
    private final String name;
    private LinkedBlockingQueue<Order> queue;
    private boolean busy;

    public Cook(String name) {
        this.name = name;
    }

    //set/get
    public boolean isBusy() {
        return busy;
    }
    public void setQueue(LinkedBlockingQueue<Order> queue) {
        this.queue = queue;
    }

    public void startCookingOrder(Order order) {
        this.busy = true;

        Tablet tablet = order.getTablet();

        ConsoleHelper.writeMessage(name + " Start cooking - " + order);

        int totalCookingTime = order.getTotalCookingTime();
        OrderReadyEventDataRow row = new OrderReadyEventDataRow(order.getTablet().toString(), name, totalCookingTime * 60, order.getDishes());
        StatisticsManager.getInstance().record(row);

        try {
            Thread.sleep((long) (totalCookingTime * 10));
        } catch (InterruptedException ignored) {
        }

        this.busy = false;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void run() {

        Thread thread = new Thread() {
            @Override
            public void run() {

                try {
                    while (true) {
                        Thread.sleep(10);
                        if (!queue.isEmpty()) {

                            if(busy == false){
                                startCookingOrder(queue.take());
                            }

                        }
                    }
                } catch (InterruptedException e) {
                }

            }
        };
        thread.setDaemon(true);
        thread.start();

    }
}
