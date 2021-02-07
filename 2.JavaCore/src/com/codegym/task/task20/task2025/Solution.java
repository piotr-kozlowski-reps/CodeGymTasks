package com.codegym.task.task20.task2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Number algorithms

*/

public class Solution {

    public static long[] getNumbers(long N) {
        long[] result = null;
        List<Long> resultAsArrayList = new ArrayList<>();
//        long startTime = System.currentTimeMillis();

        for (long i = 1; i < N; i++){
            long number = i;
            long sumOfMultipliedDigitsOfNumber = multiplyDigits(number);

            if (number == sumOfMultipliedDigitsOfNumber){
                resultAsArrayList.add(number);
            }
        }

        Object[] arrayAsObject = resultAsArrayList.toArray();
        result = new long[arrayAsObject.length];
        for (int i = 0; i < arrayAsObject.length; i++){
            result[i] = (long) arrayAsObject[i];
//            long currentTime = System.currentTimeMillis();
//            if (((currentTime - startTime) / 1000) == 10) System.exit(0);
//            if (((Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024)) > 51200) System.exit(0);
        }

        return result;
    }

    private static long multiplyDigits(long number){
        long howManyDigitsInNumber = howManyDigits(number);
        List<Long> exactDigitsFromNumber = digitsFromNumber(number);
        long result = 0;

        for (int i = 0; i < howManyDigitsInNumber; i++){
            long numberSolo = exactDigitsFromNumber.get(i);
            long powerOfNumberSolo = (long) Math.pow(numberSolo, howManyDigitsInNumber);
            result += powerOfNumberSolo;
        }

        return result;
    }

    private static long howManyDigits(long number){
        long result = 0;
        while (number != 0){
            result++;
            number = number / 10;
        }

        return result;
    }

    private static ArrayList<Long> digitsFromNumber(long number){
        ArrayList<Long> result = new ArrayList<>();
        String numberAsString = String.valueOf(number);

        for (int i = 0; i < numberAsString.length(); i++){
            char numberToParseAsChar = numberAsString.charAt(i);
            String numberToParse = Character.toString(numberToParseAsChar);
            result.add(Long.parseLong(numberToParse));
        }

        return result;
    }

    public static void main(String[] args) {
        long a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(1000)));
        long b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);

        a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(1000000)));
        b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);
    }
}
