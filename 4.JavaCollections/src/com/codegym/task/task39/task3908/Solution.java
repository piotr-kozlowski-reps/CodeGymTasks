package com.codegym.task.task39.task3908;

/*
Is a palindrome possible?

*/

public class Solution {
    public static void main(String[] args) {

    }

    public static boolean isPalindromePermutation(String s) {
        boolean foundOdd = false;
        int[] tableCount = new int[256];

        for(char c : s.toLowerCase().toCharArray()) {
            tableCount[c] += 1;
        }

        for(int count : tableCount) {
            if (count % 2 != 0) {
                if (foundOdd) {
                    return false;
                }
                foundOdd = true;
            }
        }

        return true;
    }
}




















//moje rozwiazanie

//package com.codegym.task.task39.task3908;
//
///*
//Is a palindrome possible?
//
//*/
//
//public class Solution {
//
//    //fields
//    private static boolean isPalindrome = false;
//
//    public static void main(String[] args) {
//        // System.out.println(isPalindromePermutation("aB/baĀ"));
//    }
//
//    public static boolean isPalindromePermutation(String s) {
//
//        if (!s.matches("\\A\\p{ASCII}*\\z")) return false;
//
//        boolean checkPermutationString = everyPermutationMaker(s.toLowerCase(), "");
//        if (isPalindrome) return true;
//        else return false;
//
//    }
//
//    private static boolean everyPermutationMaker(String str, String ans) {
//
//        if (isPalindrome) return true;
//
//        boolean temporaryPalindrome = false;
//        if (str.length() == 0) {
//            temporaryPalindrome = checkIfPalindrome(ans);
//            if (temporaryPalindrome) isPalindrome = true;
//        }
//
//        for (int i = 0; i < str.length(); i++) {
//            char ch = str.charAt(i);
//            String result = str.substring(0, i) +
//                    str.substring(i + 1);
//            everyPermutationMaker(result, ans + ch);
//        }
//
//        return false;
//    }
//
//    private static boolean checkIfPalindrome(String ans) {
//        StringBuilder stringBuilder = new StringBuilder(ans);
//        stringBuilder = stringBuilder.reverse();
//        if (ans.equals(stringBuilder.toString())) return true;
//        else return false;
//    }
//}
