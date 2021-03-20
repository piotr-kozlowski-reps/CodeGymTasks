package com.codegym.task.task37.task3714;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Ancient Rome

*/

// letters: IVXLCDM

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input a roman numeral to be converted to decimal: ");
        String romanString = bufferedReader.readLine();
        System.out.println("Conversion result: " + romanToInteger(romanString));
    }

    public static int romanToInteger(String s) {

        int result = 0;

        if (s.length() == 0) return result;

        Pattern patternOnlyIVXLCDM = Pattern.compile("^[IVXLCDM]+$", Pattern.CASE_INSENSITIVE);
        Matcher matcherOnlyIVXLCDM = patternOnlyIVXLCDM.matcher(s);
        boolean matcherOnlyIVXLCDMTrue = matcherOnlyIVXLCDM.find();

        if (!matcherOnlyIVXLCDMTrue) {
            return 0;
        } else {
            List<Integer> allLettersAsNumbers = createListOfNumbersFromLetters(s);
            result = addAllNumbers(allLettersAsNumbers);
        }


        return result;

    }

    private static int addAllNumbers(List<Integer> numbers) {

        int result = 0;
        for (int i = 0; i < numbers.size(); i++) {

            int currentNumber = numbers.get(i);

            int nextNumber = 0;
            if (i + 1 <= numbers.size() - 1) nextNumber = numbers.get(i + 1);

            int afterNextNumber = 0;
            if (i + 2 <= numbers.size() - 1) afterNextNumber = numbers.get(i + 2);

            if (currentNumber == 5 && nextNumber > 5
                    || currentNumber == 50 && nextNumber > 50
                    || currentNumber == 500 && nextNumber > 500) {
                return 0;
            }

            if (currentNumber == 1 && nextNumber == 5) {
                result += 4;
                i++;
                continue;
            }

            if (currentNumber == 1 && nextNumber == 10) {
                result += 9;
                i++;
                continue;
            }

            if (currentNumber == 10 && nextNumber == 50) {
                result += 40;
                i++;
                continue;
            }

            if (currentNumber == 10 && nextNumber == 100) {
                result += 90;
                i++;
                continue;
            }

            if (currentNumber == 100 && nextNumber == 500) {
                result += 400;
                i++;
                continue;
            }

            if (currentNumber == 100 && nextNumber == 1000) {
                result += 900;
                i++;
                continue;
            }

            result += currentNumber;

        }

        return result;
    }

    private static List<Integer> createListOfNumbersFromLetters(String s) {

        List<Character> allLetters = new ArrayList<>();
        List<Integer> allNumbersFromLetters = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            allLetters.add(s.charAt(i));
        }

        for (Character letter : allLetters) {
            switch (letter) {
                case 'I':
                    allNumbersFromLetters.add(1);
                    break;
                case 'V':
                    allNumbersFromLetters.add(5);
                    break;
                case 'X':
                    allNumbersFromLetters.add(10);
                    break;
                case 'L':
                    allNumbersFromLetters.add(50);
                    break;
                case 'C':
                    allNumbersFromLetters.add(100);
                    break;
                case 'D':
                    allNumbersFromLetters.add(500);
                    break;
                case 'M':
                    allNumbersFromLetters.add(1000);
                    break;
            }
        }


        return allNumbersFromLetters;

    }
}
