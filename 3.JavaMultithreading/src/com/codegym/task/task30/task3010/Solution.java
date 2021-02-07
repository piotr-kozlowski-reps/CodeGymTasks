package com.codegym.task.task30.task3010;

/* 
Smallest possible radix

*/

public class Solution {
    public static void main(String[] args) {

        try {
            String number = args[0];
            char[] allPossibleChars = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

             if (number.length() < 256 && checkIfnumberSourceIsNumber(number, allPossibleChars)) {

                //checking the index of furtherest letter of number in digits/letters
                int indexOfFurtherestLetter = 0;
                int arrayLenght = allPossibleChars.length;

                for (int i = 0; i < number.length(); i++) {

                    char letter = number.charAt(i);
                    int index = 0;

                    for (int j = 0; j < arrayLenght; j++) {
                        if (allPossibleChars[j] == letter) {
                            index = j;
                            if (index > indexOfFurtherestLetter) indexOfFurtherestLetter = index;
                            break;
                        }

                    }

                }

                //minimal base for that number
                if (indexOfFurtherestLetter < 2) System.out.println(2);
                else System.out.println(indexOfFurtherestLetter + 1);

            } else {
                System.out.println("Invalid");
            }

        } catch (Exception e){}


    }

    private static boolean checkIfnumberSourceIsNumber(String number, char[] allPossibleChars) {

        number = number.toLowerCase();

        if (number == null) return false;

        if (number.length() == 0) return false;

        //  if (number.charAt(0) == '-' && number.length() == 1) return false;

        // if (number.charAt(0) == '0' && number.length() > 1) return false;

        for (int i = 0; i < number.length(); i++) {

            char letter = number.charAt(i);

            boolean isMatchingAnyChar = false;
            for (char entry : allPossibleChars) {
                if (letter == entry) isMatchingAnyChar = true;
            }
            if (!isMatchingAnyChar) return false;
        }

        return true;

    }
}