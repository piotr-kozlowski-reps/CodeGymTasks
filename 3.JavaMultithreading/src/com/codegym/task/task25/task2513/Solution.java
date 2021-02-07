package com.codegym.task.task25.task2513;

import java.util.Random;

/* 
Ensuring important operations aren't interrupted

*/

//Ensuring important operations aren't interrupted
//Take a look at the moveMoney() method.
//If RANDOM.nextInt(5000) is greater than THRESHOLD_VALUE, then ensure the time slice is surrendered (yield the right of way to the current thread).
//Add this code to the only acceptable place.
//
//
//Requirements:
//1. The Solution class must have an Account class.
//2. The moveMoney() method must transfer the value of the amount field from the "from" account to the "to" account.
//3. In the moveMoney() method, call Thread.yield() if RANDOM.nextInt(5000) is greater than THRESHOLD_VALUE.
//4. Thread.yield() must be called in the correct place.

public class Solution {
    private static final Integer THRESHOLD_VALUE = 500;
    private static final Random RANDOM = new Random();

    public synchronized void moveMoney(Account from, Account to, int amount) {
        from.setBalance(from.getBalance() - amount);
        if (RANDOM.nextInt(5000) > THRESHOLD_VALUE) Thread.yield();
        to.setBalance(to.getBalance() + amount);
    }

    class Account {
        private int balance;

        public int getBalance() {
            return balance;
        }

        public void setBalance(int balance) {
            this.balance = balance;
        }
    }

    public static void main(String[] args) {
    }
}
