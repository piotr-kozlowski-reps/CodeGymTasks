package com.codegym.task.task27.task2712;

import com.codegym.task.task27.task2712.ad.AdvertisementManager;
import com.codegym.task.task27.task2712.ad.NoVideoAvailableException;
import com.codegym.task.task27.task2712.kitchen.Order;
import com.codegym.task.task27.task2712.kitchen.TestOrder;

import java.io.IOException;
import java.util.Observable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tablet{

    //fields
    private final int number;
    private static Logger logger = Logger.getLogger(com.codegym.task.task27.task2712.Tablet.class.getName());
    private LinkedBlockingQueue<Order> queue;

    //constr
    public Tablet(int number) {
        this.number = number;
    }

    //set/get
    public void setQueue(LinkedBlockingQueue<Order> queue) {
        this.queue = queue;
    }



    //
    public void createOrder() {
        Order order = null;
        try {
            order = new Order(this);
            processOrder(order);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "The console is unavailable.");
        } catch (NoVideoAvailableException e) {
            logger.log(Level.INFO, "No video is available for the following order: " + order);
        }
    }

    private boolean processOrder(Order order) {
        ConsoleHelper.writeMessage(order.toString());
        if (order.isEmpty())
            return true;

        queue.offer(order);

        new AdvertisementManager(order.getTotalCookingTime() * 60).processVideos();
        return false;
    }

    public void createTestOrder() {
        Order order = null;
        try {
            order = new TestOrder(this);
            processOrder(order);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "The console is unavailable.");
        } catch (NoVideoAvailableException e) {
            logger.log(Level.INFO, "No video is available for the following order: " + order);
        }
    }

    @Override
    public String toString() {
        return "Tablet{" +
                "number=" + number +
                '}';
    }

}
