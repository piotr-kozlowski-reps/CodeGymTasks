package pl.codegym.task.task20.task2010;

import java.io.Serializable;

/*
Jak serializować coś własnego?
*/
public class Solution {

    public static class Object implements Serializable {
        public String string1;
        public String string2;
    }

    public static int stringCount;

    public static class String implements Serializable{

        private final int number;

        public String() {
            number = ++stringCount;
        }

        public void print() {
            System.out.println("ciąg #" + number);
        }
    }

    public static void main(String[] args) {

    }
}