package com.codegym.task.task32.task3213;

import java.io.IOException;
import java.io.StringReader;

/* 
Caesar cipher

*/

public class Solution {
    public static void main(String[] args) throws IOException {
        StringReader reader = new StringReader("Khoor#Dpljr#&C,₷B'3");
        System.out.println(decode(reader, -3));  // Hello Amigo #@)₴?$0
    }

    public static String decode(StringReader reader, int key) throws IOException {

        StringBuilder stringBuilder = new StringBuilder();

        try {
            int letter;

            while ((letter = reader.read()) != -1) {
                letter += key;
                stringBuilder.append((char) letter);
            }

            return stringBuilder.toString();

        } catch (Exception e) {
            return stringBuilder.toString();
        }

    }
}