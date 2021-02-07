package com.codegym.task.task28.task2805;

import java.util.concurrent.atomic.AtomicInteger;

public class MyThread extends Thread{

    private static AtomicInteger priority = new AtomicInteger(1);
    private static AtomicInteger indexOfIncrementation = new AtomicInteger(1);


    private static int setPriorityInLoop(ThreadGroup group){

        if (group.getName().equals("main")){

            if (indexOfIncrementation.get() <= Thread.MAX_PRIORITY){
                indexOfIncrementation.getAndIncrement();
                return priority.getAndIncrement();
            }else {
                indexOfIncrementation.set(Thread.MIN_PRIORITY);
                priority.set(Thread.MIN_PRIORITY);
                return priority.getAndIncrement();
            }

        } else {

            int maxPriorityOfGroup = group.getMaxPriority();

            if (indexOfIncrementation.get() <= Thread.MAX_PRIORITY){
                indexOfIncrementation.getAndIncrement();
                if (priority.get() <= maxPriorityOfGroup) return priority.getAndIncrement();
                else return maxPriorityOfGroup;
            } else {
                indexOfIncrementation.set(Thread.MIN_PRIORITY);
                priority.set(Thread.MIN_PRIORITY);
                return priority.getAndIncrement();
            }

        }

    }


    //constr
    public MyThread() {
        this.setPriority(setPriorityInLoop(Thread.currentThread().getThreadGroup()));
    }

    public MyThread(Runnable target) {
        super(target);
        this.setPriority(setPriorityInLoop(Thread.currentThread().getThreadGroup()));
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        this.setPriority(setPriorityInLoop(Thread.currentThread().getThreadGroup()));
    }

    public MyThread(String name) {
        super(name);
        this.setPriority(setPriorityInLoop(Thread.currentThread().getThreadGroup()));
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        this.setPriority(setPriorityInLoop(Thread.currentThread().getThreadGroup()));
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        this.setPriority(setPriorityInLoop(Thread.currentThread().getThreadGroup()));
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        this.setPriority(setPriorityInLoop(Thread.currentThread().getThreadGroup()));
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        this.setPriority(setPriorityInLoop(Thread.currentThread().getThreadGroup()));
    }

}
