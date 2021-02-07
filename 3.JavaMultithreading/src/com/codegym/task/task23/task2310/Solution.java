package com.codegym.task.task23.task2310;

/* 
Strain your brain!

*/
//Strain your brain!
//The printName method must display its own name field, i.e. "sout"
//Make the fewest changes possible.
//
//
//Requirements:
//1. The screen output must match the task conditions.
//2. The Solution class should have a sout method without parameters.
//3. The Solution class must have a name field.
//4. The getName method's access modifier must be expanded.


public class Solution {
    private String name;

    Solution(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void sout() {
        new Solution("sout") {
            void printName() {
                System.out.println(getName());
            }
        }.printName();
    }

    public static void main(String[] args) {
        new Solution("main").sout();
    }
}
