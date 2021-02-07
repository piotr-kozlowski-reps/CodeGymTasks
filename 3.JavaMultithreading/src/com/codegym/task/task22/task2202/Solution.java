package com.codegym.task.task22.task2202;

/* 
Find a substring

*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("CodeGym is the best place to learn Java."));
    }

    public static String getPartOfString(String string) {

        if (string == null) throw new StringTooShortException();

        int count = 0;
        for(int i = 0; i < string.length(); i++) {
            if(Character.isWhitespace(string.charAt(i))) count++;
        }
        if (count < 4) throw new StringTooShortException();

        String[] splittedString = string.split("\\s");

        StringBuilder result = new StringBuilder();
        result.append(splittedString[1]).append(" ").append(splittedString[2]).append(" ").append(splittedString[3]).append(" ").append(splittedString[4]);

        return result.toString();
    }

    public static class StringTooShortException extends RuntimeException{
    }
}