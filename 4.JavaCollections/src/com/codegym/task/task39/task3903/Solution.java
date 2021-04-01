package com.codegym.task.task39.task3903;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Unequal exchange

*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("Please enter a number: ");

        long number = Long.parseLong(reader.readLine());
        System.out.println("Please enter the first index: ");
        int i = Integer.parseInt(reader.readLine());
        System.out.println("Please enter the second index: ");
        int j = Integer.parseInt(reader.readLine());

        System.out.println("The result of swapping bits is " + swapBits(number, i, j));
    }

    // moje rozwiazanie
 /*   public static long swapBits(long number, int i, int j) {

        String numberAsString = Long.toString(number, 2);

        // 156 0 7
        // 10011100
        // 00011101
        if (i > (numberAsString.length() - 1) || j > (numberAsString.length() - 1)) return 0;

        char iChar = numberAsString.charAt(i);
        char jChar = numberAsString.charAt(j);

        StringBuilder stringBuilder = new StringBuilder();
        for (int index = 0; index < numberAsString.length(); index++) {
            if (index == i) {
                index++;
                stringBuilder.append(jChar);
            } else if (index == j) {
                index++;
                stringBuilder.append(iChar);
            } else {
                stringBuilder.append(numberAsString.charAt(index));
            }
        }


        return Long.parseLong(String.valueOf(stringBuilder), 10);
    }*/


    //ich rozwiazanie
    public static long swapBits(long number, int i, int j) {
        if (((number >>> i) & 1) != ((number >>> j) & 1)) {
            long bitMask = (1L << i) | (1L << j);
            number ^= bitMask;
        }
        return number;
    }
}
