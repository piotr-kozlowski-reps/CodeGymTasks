package com.codegym.task.task39.task3901;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* 
Unique substrings

*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter your string: ");
        String s = bufferedReader.readLine();

        System.out.println("The longest unique substring length is: \n" + lengthOfLongestUniqueSubstring(s));
    }

    public static int lengthOfLongestUniqueSubstring(String s) {

        if (s == null || s.length() == 0) return 0;

        int longestSubstringNumber = 0;
        for (int i = 0; i < s.length(); i++) {
            List<Character> uniqueCharactersSubstring = new ArrayList<>();

            //a123bcbcqwezxcvbnmlkjiop
            //aa123bcbcqwe
            for (int j = i; j < s.length(); j++) {
                char letter = s.charAt(j);

                if (!uniqueCharactersSubstring.contains(letter)) {
                    uniqueCharactersSubstring.add(letter);
                    if (j == (s.length() - 1)) {
                        if (uniqueCharactersSubstring.size() > longestSubstringNumber) longestSubstringNumber = uniqueCharactersSubstring.size();
                    }

                } else if (uniqueCharactersSubstring.size() > longestSubstringNumber) {
                    longestSubstringNumber = uniqueCharactersSubstring.size();
                    break;
                } else if (uniqueCharactersSubstring.size() <= longestSubstringNumber){
                    break;
                }
            }
        }

        return longestSubstringNumber;
    }
}