package com.codegym.task.task27.task2701;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Getting rid of labels

*/

//String: Maman isnta juz.
//subString: aman

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = reader.readLine();
        String substring = reader.readLine();

        if (isSubstringPresent(substring, string)) {
            System.out.println("String: \n" + substring + "\nis present in the string: \n" + string);
        } else {
            System.out.println("String: \n" + substring + "\nis not present in the string: \n" + string);
        }
    }

    static boolean isSubstringPresent(String substring, String string) {
        boolean found = false;
        int max = string.length() - substring.length();
        for (int i = 0; i <= max; i++) {
            int subsequentCharsAmount = 0;
            int length = substring.length();
            int originalLength = length;
            int j = i;
            int k = 0;
            while (length-- != 0) {
                if (string.charAt(j++) != substring.charAt(k++)) {
                } else subsequentCharsAmount++;
            }

            if (subsequentCharsAmount == originalLength) found = true;
        }

        return found;
    }
}

