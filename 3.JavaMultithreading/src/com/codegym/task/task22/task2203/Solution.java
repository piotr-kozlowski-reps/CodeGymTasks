package com.codegym.task.task22.task2203;

/* 
Between tabs

*/

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

        public static String getPartOfString(String string) throws StringTooShortException{

            if (string == null) throw new StringTooShortException();

            int indexFirstTab = string.indexOf("\t");
            if (indexFirstTab == -1) throw new StringTooShortException();
            String stringFrontCut = string.substring(indexFirstTab+1, string.length());

            int indexSecondTab = stringFrontCut.indexOf("\t");
            if (indexSecondTab == -1) throw new StringTooShortException();
            String result = stringFrontCut.substring(0, indexSecondTab);

            return result;
        }

    public static class StringTooShortException extends Exception {
    }

    public static void main(String[] args) throws StringTooShortException {
//        System.out.println(getPartOfString("\tCodeGym is the best place \tto learn Java\t."));
        System.out.println(getPartOfString(null));
    }
}