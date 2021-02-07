package com.codegym.task.task27.task2712;

import com.codegym.task.task27.task2712.kitchen.Cook;
import com.codegym.task.task27.task2712.kitchen.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class Restaurant {
    private static final int ORDER_CREATION_INTERVAL = 100;
    private final static LinkedBlockingQueue<Order> orderQueue = new LinkedBlockingQueue(200);

    public static void main(String[] args) {
        List<Tablet> tablets = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            tablets.add(new Tablet(i + 1));
        }

        Cook cook1 = new Cook("John Arne Riise");
        cook1.setQueue(orderQueue);
        Cook cook2 = new Cook("Milan Baros");
        cook2.setQueue(orderQueue);

        Thread cook1Thread = new Thread(cook1);
        Thread cook2Thread = new Thread(cook2);
        cook1Thread.start();
        cook2Thread.start();

        for (Tablet tablet :
                tablets) {
            tablet.setQueue(orderQueue);
        }

        Thread thread = new Thread(new RandomOrderGeneratorTask(tablets, ORDER_CREATION_INTERVAL));
        thread.start();

        try {
            Thread.sleep(1000);
            thread.interrupt();
            thread.join();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }

        ManagerTablet managerTablet = new ManagerTablet();
        managerTablet.printAdRevenue();
        managerTablet.printCookUtilization();
        managerTablet.printActiveVideoSet();
        managerTablet.printArchivedVideoSet();
    }
}
