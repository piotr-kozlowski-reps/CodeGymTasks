package com.codegym.task.task30.task3002;

/* 
Mastering the methods of the Integer class

*/


public class Solution {

    public static void main(String[] args) {
        System.out.println(convertToDecimalSystem("0x16")); // 22
        System.out.println(convertToDecimalSystem("012"));  // 10
        System.out.println(convertToDecimalSystem("0b10")); // 2
        System.out.println(convertToDecimalSystem("62"));   // 62
    }

    public static String convertToDecimalSystem(String s) {

        String enterNumber = null;
        int resultInt = 0;

        if (s.matches("0[xX][0-9a-fA-F]+")) {
            enterNumber = s.substring(2);
            resultInt = Integer.parseInt(enterNumber, 16);
            return resultInt + "";
        }

        if (s.matches("0[0-7]+")) {
            enterNumber = s.substring(1);
            resultInt = Integer.parseInt(enterNumber, 8);
            return resultInt + "";
        }

        if (s.matches("0[bB][0-1]+")) {
            enterNumber = s.substring(2);
            resultInt = Integer.parseInt(enterNumber, 2);
            return resultInt + "";
        }

        if (s.matches("^[1-9][0-9]*$")) {
            resultInt = Integer.parseInt(s);
            return resultInt + "";
        }




        return s;
    }
}
