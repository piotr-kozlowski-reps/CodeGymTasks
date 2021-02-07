package com.codegym.task.task26.task2612;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* 
The whole world is a comedy

*/

public class Solution {
    private Lock lock = new ReentrantLock();

    public void someMethod() {

        boolean wasLockBusy = false;

        try{
            if (lock.tryLock()) actionIfLockIsFree();
            else {
                actionIfLockIsBusy();
                wasLockBusy = true;
            }
        } catch (Exception ignored){}
        finally {
            if (!wasLockBusy) lock.unlock();
        }

    }

    public void actionIfLockIsFree() {
    }

    public void actionIfLockIsBusy() {
    }
}
