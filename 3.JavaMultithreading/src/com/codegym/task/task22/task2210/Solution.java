package com.codegym.task.task22.task2210;

/* 
StringTokenizer

*/

//StringTokenizer
//Using a StringTokenizer, split the query into parts using the String delimiter.
//
//For example: getTokens("level22.lesson13.task01", ".") returns a string array {"level22", "lesson13", "task01"}


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {

    }
    public static String [] getTokens(String query, String delimiter) {

        StringTokenizer stringTokenizer = new StringTokenizer(query, delimiter);

        List<String> tokensArrayList = new ArrayList<>();
        while (stringTokenizer.hasMoreElements()){
            tokensArrayList.add(stringTokenizer.nextToken());
        }

        Object[] objectTokens = tokensArrayList.toArray();
        String[] stringTokens = new String[objectTokens.length];
        for (int i = 0; i < objectTokens.length; i++){
            stringTokens[i] = (String) objectTokens[i];
        }

        return stringTokens;
    }
}
