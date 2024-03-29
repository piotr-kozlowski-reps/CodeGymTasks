package com.codegym.task.task27.task2711;

import java.util.concurrent.CountDownLatch;

/* 
CountDownLatch

*/

//1. The lock field must be removed from the Solution class.
//2. The synchronized block must be removed from the someMethod method.
//3. The someMethod method must call the await method without parameters on the object stored in the latch field.
//4. The someMethod method must call the retrieveValue method.
//5. The someMethod method must call countDown on the object stored in the latch field.


public class Solution {

    CountDownLatch latch = new CountDownLatch(1);

    public void someMethod() throws InterruptedException {
        latch.await();
        retrieveValue();
    }

    void retrieveValue() {
        System.out.println("Value retrieved.");
        latch.countDown();
    }

    public static void main(String[] args) {

    }
}
