package com.codegym.task.task36.task3604;

/* 
Understanding red-black trees

*/

import java.util.TreeMap;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) {

        RedBlackTree redBlackTree = new RedBlackTree();
        int[] digits = {10, 18, 7, 15, 16, 30, 25, 40, 60};
        for (int digit : digits) {
            redBlackTree.insert(digit);
            boolean isReallyEmpty = redBlackTree.isEmpty();
            System.out.println();
        }
    }
}
