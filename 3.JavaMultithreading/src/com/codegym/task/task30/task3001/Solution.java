package com.codegym.task.task30.task3001;

/* 
Numeral system converter

*/

import java.math.BigInteger;

public class Solution {
    public static void main(String[] args) {
        Number number = new Number(NumberSystemType._10, "6");
        Number result = convertNumberToOtherNumberSystem(number, NumberSystemType._2);
        System.out.println(result);    // 110 expected

        number = new Number(NumberSystemType._16, "6df");
        result = convertNumberToOtherNumberSystem(number, NumberSystemType._8);
        System.out.println(result);    // 3337 expected

        number = new Number(NumberSystemType._16, "abcdefabcdef");
        result = convertNumberToOtherNumberSystem(number, NumberSystemType._16);
        System.out.println(result);    // abcdefabcdef expected
    }

    public static Number convertNumberToOtherNumberSystem(Number number, NumberSystem expectedNumberSystem) throws NumberFormatException{
        Number result = null;

        int sourceBaseValue = number.getNumberSystem().getNumberSystemIntValue();
        int destinationBaseValue = expectedNumberSystem.getNumberSystemIntValue();
        BigInteger bigInteger = new BigInteger(number.getDigit(), sourceBaseValue);

        String resultAsString = bigInteger.toString(destinationBaseValue);
        result = new Number(expectedNumberSystem, resultAsString);

        return result;
    }

/*    public static Number convertNumberToOtherNumberSystem(Number number, NumberSystem expectedNumberSystem) throws NumberFormatException{
        Number result = null;

        //convert number to decimal
        String numberSource = number.getDigit();
        int sourceBaseValue = number.getNumberSystem().getNumberSystemIntValue();
        int destinationBaseValue = expectedNumberSystem.getNumberSystemIntValue();

        long parsedSourceNumber = Long.parseLong(numberSource, sourceBaseValue);

        if (parsedSourceNumber >= 0){
            String resultAsString = Long.toString(Long.parseLong(numberSource, sourceBaseValue), destinationBaseValue);
            result = new Number(expectedNumberSystem, resultAsString);
        }
        return result;
    }*/



}
