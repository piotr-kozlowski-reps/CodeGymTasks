package com.codegym.task.task26.task2609;

/* 
Distributing items into baskets with their own lock

*/

//Distributing items into baskets with their own lock
//In the synchronized blocks, use the right lock.




//5. In the synchronized block of the Solution class's get() method, use a lock from the locks array,
// depending on the object hash and the number of lock objects.
//6. In the synchronized block of the Solution class's clear() method,
// use a lock from the locks array, depending on the element's index and the number of lock objects.


import java.util.concurrent.ConcurrentHashMap;

public class Solution {
    private static final int LOCK_COUNT = 12;
    private final Node[] buckets;
    private final Object[] locks;

    static class Node {
        public Node next;
        public Object key;
        public Object value;
    }

    public Solution(int bucketCount) {
        buckets = new Node[bucketCount];
        locks = new Object[LOCK_COUNT];
        for (int i = 0; i < LOCK_COUNT; i++) {
            locks[i] = new Object();
        }
    }

    private final int hash(Object key) {
        return Math.abs(key.hashCode() % buckets.length);
    }

    public Object get(Object key) {
        int hash = hash(key);
        synchronized (locks[hash % LOCK_COUNT]) {
            for (Node m = buckets[hash]; m != null; m = m.next) {
                if (m.key.equals(key)) return m.value;
            }
        }
        return null;
    }

    public void clear() {
        for (int i = 0; i < buckets.length; i++) {
            synchronized (locks[i % LOCK_COUNT]) {
                buckets[i] = null;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution(100);
    }
}
