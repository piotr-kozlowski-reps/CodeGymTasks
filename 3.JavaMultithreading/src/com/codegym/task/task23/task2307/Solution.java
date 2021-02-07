package com.codegym.task.task23.task2307;

/* 
How do I choose the right one?

*/

//How do I choose the right one?
//In the main method, assign an instance of the TEST class to the Object obj variable.
//Don't change anything except the main method.

//4. The main method must save a TEST object (instance of the TEST class) to the obj field.


public class Solution {
    public static final String TEST = "test";

    public static class TEST {
        @Override
        public String toString() {
            return "test class";
        }
    }

    static Object obj;

    public static void main(String[] args) {
        obj = new Solution.TEST();
        System.out.println(obj);
    }
}
