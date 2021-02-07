package com.codegym.task.task20.task2016;

/* 
Minimum changes

*/

//Minimum changes
//With minimum code changes, make it possible to serialize the C class.


//6. The A class should support the Serializable interface.
//7. The B class should not explicitly support the Serializable interface.
//8. The C class should not explicitly support the Serializable interface.


import java.io.Serializable;

public class Solution {
    public class A implements Serializable{
        String name = "A";

        public A(String name) {
            this.name += name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public class B extends A{
        String name = "B";

        public B(String name) {
            super(name);
            this.name += name;
        }
    }

    public class C extends B{
        String name = "C";

        public C(String name) {
            super(name);
            this.name = name;
        }
    }

    public static void main(String[] args) {

    }
}
