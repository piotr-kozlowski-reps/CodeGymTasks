package com.codegym.task.task32.task3204;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.*;

/* 
Password generator

*/

public class Solution {
    public static void main(String[] args) throws Exception{
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() throws Exception{

        List<Character> password = new ArrayList<>(8);

        // ASCI number range: 48-57
        for (int i = 0; i < 3; i++) {
            password.add((char) getRandomNumberWithinARange(48, 57));
        }

        // ASCI uppercase range: 65-90
        for (int i = 3; i < 6; i++) {
            password.add((char) getRandomNumberWithinARange(65, 90));
        }

        // ASCI lowercase range: 97-122
        for (int i = 6; i < 8; i++) {
            password.add((char) getRandomNumberWithinARange(97, 122));
        }

        Collections.shuffle(password);

        StringBuilder stringBuilder = new StringBuilder();
        for (Character character : password) {
            stringBuilder.append(character);
        }

        InputStream inputStream = new ByteArrayInputStream(stringBuilder.toString().getBytes());
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        while (inputStream.available() > 0) {
            int data = inputStream.read();
            byteArrayOutputStream.write(data);
        }

        return byteArrayOutputStream;
    }

    private static int getRandomNumberWithinARange(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }
}

//Password generator
//Implement the getPassword() method, which must return a ByteArrayOutputStream with the bytes comprising the password.
//Password requirements:
//1) 8 characters.
//2) Only numbers and uppercase and lowercase Latin letters.
//3) At least one numeral, one lowercase letter, and one uppercase letter.
//All generated passwords must be unique.
//
//Example of a valid password:
//wMh7smNu
//
//
//Requirements:
//1. The Solution class must have a getPassword() method that returns a ByteArrayOutputStream with the generated password.
//2. The password must be 8 characters long.
//3. The password must have at least one numeral.
//4. The password must have at least one lowercase Latin letter.
//5. The password must have at least one uppercase Latin letter.
//6. The password must not have characters other than numerals and uppercase and lowercase Latin letters.
//7. Generated passwords must be unique.
