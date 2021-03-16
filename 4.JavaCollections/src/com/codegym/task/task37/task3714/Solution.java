package com.codegym.task.task37.task3714;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Ancient Rome

*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input a roman numeral to be converted to decimal: ");
        String romanString = bufferedReader.readLine();
        System.out.println("Conversion result: " + romanToInteger(romanString));
    }

    public static int romanToInteger(String s) {

        return 0;
    }
}
