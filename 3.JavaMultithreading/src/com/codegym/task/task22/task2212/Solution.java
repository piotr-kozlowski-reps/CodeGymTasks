package com.codegym.task.task22.task2212;

/* 
Phone number verification

*/

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static boolean checkPhoneNumber(String phoneNumber) {

//        Pattern pattern1 = Pattern.compile("(^\\+\\d{12}$)");                                  //+380501234567
//        Pattern pattern2 = Pattern.compile("^\\+\\d{1,3}(\\(\\d{3}\\))\\d{7}$");               //+38(050)1234567
//        Pattern pattern3 = Pattern.compile("\\+\\d{8}-\\d{2}-\\d{2}$");                         //+38050123-45-67
//        Pattern pattern4 = Pattern.compile("\\d{6}-\\d{4}$");                                   //050123-4567

        if (phoneNumber == null) return false;

        Pattern pattern = Pattern.compile("(^\\+\\d{12}$)|^\\+\\d{1,3}(\\(\\d{3}\\))\\d{7}$|\\+\\d{8}-\\d{2}-\\d{2}$|\\d{6}-\\d{4}$");
        Matcher matcher = pattern.matcher(phoneNumber);

        if (matcher.matches())return true;
        else  return false;
    }

    public static void main(String[] args) {

    }
}
