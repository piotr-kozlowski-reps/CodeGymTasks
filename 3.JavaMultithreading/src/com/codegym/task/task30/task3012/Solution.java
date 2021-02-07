package com.codegym.task.task30.task3012;

/* 
Derive a specific number

*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.createExpression(2);
    }

    public void createExpression(int number) {
        int[] numbersAvailable = {1, 3, 9, 27, 81, 243, 729, 2187};
        String numberConvertedToBalancedTernary = convertToBalancedTernary(number);


        String numberConvertedAndReversed = new StringBuilder(numberConvertedToBalancedTernary).reverse().toString();
        StringBuilder resultSB = new StringBuilder();

        resultSB.append(number).append(" = ");

        for (int i = 0; i < numberConvertedAndReversed.length(); i++) {

            char sign = numberConvertedAndReversed.charAt(i);
            if (sign == '0') continue;
            if (sign == '1') {
                resultSB.append(" + ").append(numbersAvailable[i]);
            }
            if (sign == 'Z') {
                resultSB.append(" - ").append(numbersAvailable[i]);
            }

        }

        System.out.println(resultSB.toString());


    }

    private String convertToBalancedTernary(int number) {

        String output = "";

        while (number > 0) {
            int rem = number % 3;
            number = number / 3;

            if (rem == 2) {
                rem = -1;
                number++;
            }
            output = (rem == 0 ? '0' : (rem == 1) ? '1' : 'Z') + output;
        }

        return output;
    }
}