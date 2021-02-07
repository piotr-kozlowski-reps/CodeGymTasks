package com.codegym.task.task24.task2410;

import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.List;

/* 
Refactoring, anonymous classes

*/

//Refactoring, anonymous classes
//Be sure that the getIterator method returns an anonymous class.
//Transfer the LocalIterator logic to an anonymous class.
//Only change the body of the getIterator method.
//
//
//Requirements:
//1. The getIterator method must return an Iterator object.
//2. The object returned by the getIterator method must be an instance of an anonymous class.
//3. The program should display data on the screen.
//4. The behavior of the program should remain the same.

public class Solution {
    public static List<Iterator> iterators = new LinkedList<>();

    private int itemCount;

/*    public Iterator getIterator(final String name) {

        Iterator it = new Iterator() {
            @Override
            public Iterator next() {
                itemCount++;
                System.out.println(name + " item " + itemCount);
                return null;
            }
        };

        return it;

    }*/

    public Iterator getIterator(final String name) {
        class LocalIterator implements Iterator {
            public LocalIterator() {
                itemCount++;
                System.out.println(name + " item " + itemCount);
            }

            public Iterator next() {
                return new LocalIterator();
            }
        }
        return new LocalIterator(){
        };
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        Iterator iterator = solution.getIterator("iterator");
        for (int i = 1; i < 5; i++) {
            iterators.add(iterator.next());
        }
    }
}
