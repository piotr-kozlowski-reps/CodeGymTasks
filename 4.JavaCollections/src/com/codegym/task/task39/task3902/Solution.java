package com.codegym.task.task39.task3902;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Bits were bits

*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Please enter a number: ");

        long l = Long.parseLong(reader.readLine());
        String result = isWeightEven(l) ? "even" : "odd";
        System.out.println("The entered number has " + result + "ones");

    }

    public static boolean isWeightEven(long number) {

        number ^= number >>> 32;
        number ^= number >>> 16;
        number ^= number >>> 8;
        number ^= number >>> 4;
        number ^= number >>> 2;
        number ^= number >>> 1;
        

        return (number & 1) == 0 ? true : false;
    }
}