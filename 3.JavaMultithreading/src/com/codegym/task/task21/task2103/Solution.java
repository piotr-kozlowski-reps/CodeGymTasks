package com.codegym.task.task21.task2103;

/* 
Everything ingenious is simple!

*/

//Everything ingenious is simple!
//Simplify. Don't rename variables. Don't leave comments.
//
//
//Requirements:



//4. The calculate method should be as simple as possible (without changing the behavior).




public class Solution {
    public static boolean calculate(boolean a, boolean b, boolean c, boolean d) {
//        return (a && b && c && !d) || (!a && c) || (!b && c) || (c && d);
//        return (a && b && c && !d) || (!a && !b &&c) || (c && d); //good, but too long
        return c;
    }

    public static void main(String[] args) {

        System.out.println(calculate(true, true, true, true));      // true
        System.out.println(calculate(false, true, true, true));     // true
        System.out.println(calculate(true, true, true, false));     // true
        System.out.println(calculate(true, false, false, true));    // false
        System.out.println(calculate(false, false, false, false));  // false

    }
}
