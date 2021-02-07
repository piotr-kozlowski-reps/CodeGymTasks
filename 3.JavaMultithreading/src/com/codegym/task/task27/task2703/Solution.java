package com.codegym.task.task27.task2703;

/* 
Causing deadlock

*/

//Causing deadlock
//Arrange modifiers so that this code causes deadlock.
//The main method causes deadlock, so it isn't tested.
//
//
//Requirements:
//1. The Solution.Friend class should NOT be private.
//2. The Solution.Friend class must be static.
//3. The bow method must be declared with the synchronized modifier.
//4. The bowBack method must be declared with the synchronized modifier.

public class Solution {
    static class Friend {
        private final String name;

        public Friend(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        public synchronized void bow(Friend bower) {
            System.out.format("%s: %s"
                            + " bowed to me!%n",
                    this.name, bower.getName());

            synchronized (bower){
                bower.bowBack(this);
            }

        }

        public synchronized void bowBack(Friend bower) {
            System.out.format("%s: %s"
                            + " bowed back to me!%n",
                    this.name, bower.getName());
        }
    }

    public static void main(String[] args) {
        final Friend alphonse =
                new Friend("Alphonse");
        final Friend gaston =
                new Friend("Gaston");
        new Thread(new Runnable() {
            public void run() {
                alphonse.bow(gaston);
            }
        }).start();
        new Thread(new Runnable() {
            public void run() {
                gaston.bow(alphonse);
            }
        }).start();
    }
}
