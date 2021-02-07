package com.codegym.task.task26.task2603;

/* 
A convert can easily convert others

*/

import javax.swing.*;
import java.util.Collections;
import java.util.Comparator;

public class Solution {

    public static class CustomizedComparator<T> implements Comparator<T>{

        //fields
        private Comparator<T>[] comparators;

        //constructors
        public CustomizedComparator(Comparator<T>... compartors){
            this.comparators = compartors;
        }


        @Override
        public int compare(T o1, T o2) {

            for (int i = 0; i < comparators.length; i++){
                int result = comparators[i].compare(o1, o2);
                if (result != 0) return result;
                else continue;
            }

            return 0;
        }
    }

    public static void main(String[] args) {

    }
}

//2. sort data in the order that corresponds to the sequence of comparators.
//All the passed comparators sort the generic type T.
//At least one comparator is passed to the constructor.

//4. The CustomizedComparator class's compare() method must compare the objects according to the sequence of comparators in the comparators field.