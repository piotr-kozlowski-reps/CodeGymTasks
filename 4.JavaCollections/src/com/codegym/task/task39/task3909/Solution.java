package com.codegym.task.task39.task3909;

/* 
One change

*/

public class Solution {
    public static void main(String[] args) {

//        System.out.println("adrt / 6785 (false): " + isOneEditAway("adrt", "6785"));
//        System.out.println("------------------");
//        System.out.println("adrt / adt (true): " + isOneEditAway("adrt", "adt"));
//        System.out.println("adt / adrt (true): " + isOneEditAway("adt", "adrt"));
//        System.out.println("adt / adrrrt (false): " + isOneEditAway("adt", "adrrrt"));
//        System.out.println("------------------");
//        System.out.println("aft / adt (true): " + isOneEditAway("aft", "adt"));
//        System.out.println("adt / aft (true): " + isOneEditAway("adt", "aft"));
//        System.out.println("adt / adrrrt (false): " + isOneEditAway("adt", "adrrrt"));
//        System.out.println("adrrrt / adt (false): " + isOneEditAway("adrrrt", "adt"));
//        System.out.println("------------------");
//        System.out.println("aft / atdfe (false): " + isOneEditAway("aft", "atdfe"));
//        System.out.println("after / afte (true): " + isOneEditAway("after", "afte"));
//        System.out.println("afte / after (true): " + isOneEditAway("afte", "after"));
//        System.out.println("  /   (true): " + isOneEditAway("", ""));
//        System.out.println(" a /   (true): " + isOneEditAway("a", ""));
//        System.out.println("  / !  (true): " + isOneEditAway("", "!"));

    }

    public static boolean isOneEditAway(String first, String second) {

        if (first.equals("") && second.equals("")) return true;


        //adding
        if (checkAdding(first, second)) return true;
        if (checkAdding(second, first)) return true;

        //editing
        if (checkEditing(first, second)) return true;
        if (checkEditing(second, first)) return true;

        //deleting
        if (checkDeleting(first, second)) return true;
        if (checkDeleting(second, first)) return true;



        return false;

    }

    private static boolean checkDeleting(String second, String first) {

        String firstToLowerCase = first.toLowerCase();
        String secondToLowerCase = second.toLowerCase();

        for (int index = 0; index < first.length(); index++) {

            StringBuilder stringBuilder = new StringBuilder(firstToLowerCase);
            stringBuilder = stringBuilder.deleteCharAt(index);

            if (stringBuilder.toString().equals(secondToLowerCase)) return true;

        }

        return false;


    }

    private static boolean checkEditing(String first, String second) {

        String firstToLowerCase = first.toLowerCase();
        String secondToLowerCase = second.toLowerCase();

        for (int letter = 0; letter < first.length(); letter++) {
            for (int i = 0; i < 256; i++) {
                char[] charArray = new char[first.length()];
                char newASCIletter = (char) i;

                for (int j = 0; j < charArray.length; j++) {
                    if (j != letter) charArray[j] = firstToLowerCase.charAt(j);
                    else charArray[j] = newASCIletter;
                }

                if (String.valueOf(charArray).equals(secondToLowerCase)) return true;
            }
        }




        return false;

    }

    private static boolean checkAdding(String first, String second) {

        String firstToLowerCase = first.toLowerCase();
        String secondToLowerCase = second.toLowerCase();

        for (int letter = 0; letter < first.length(); letter++) {
            for (int i = 0; i < 256; i++) {
                char newASCIletter = (char) i;
                String temporaryString = firstToLowerCase.substring(0, letter) + newASCIletter+ firstToLowerCase.substring(letter);
                if (temporaryString.equals(secondToLowerCase)) return true;
            }

        }

        return false;


    }
}
