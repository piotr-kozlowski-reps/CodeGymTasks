package com.codegym.task.task23.task2305;

/* 
Inner

*/

//Inner
//Implement the getTwoSolutions method, which should return an array of 2 instances of the Solution class.
//For each instance of the Solution class, initialize the innerClasses field with two values.
//All data must be initialized only in the getTwoSolutions method.
//
//


//4. The getTwoSolutions method must return a Solution array filled according to the task conditions.


public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {

        Solution[] solutionArray = new Solution[2];

        Solution solution1 = new Solution();
        Solution solution2 = new Solution();

        Solution.InnerClass innerClass1_1 = solution1.new InnerClass();
        Solution.InnerClass innerClass1_2 = solution1.new InnerClass();

        Solution.InnerClass innerClass2_1 = solution2.new InnerClass();
        Solution.InnerClass innerClass2_2 = solution2.new InnerClass();

        solution1.innerClasses[0] = innerClass1_1;
        solution1.innerClasses[1] = innerClass1_2;

        solution2.innerClasses[0] = innerClass2_1;
        solution2.innerClasses[1] = innerClass2_2;

        solutionArray[0] = solution1;
        solutionArray[1] = solution2;

        return solutionArray;
    }

    public static void main(String[] args) {

    }
}
