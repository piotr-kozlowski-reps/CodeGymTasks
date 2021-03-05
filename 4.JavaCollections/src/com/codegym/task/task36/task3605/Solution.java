package com.codegym.task.task36.task3605;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/* 
Using TreeSet

*/

public class Solution {
    public static void main(String[] args) throws IOException {

        File file = new File(args[0]);

        //reading from file
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        StringBuilder readFile = new StringBuilder();
        String lineRead = null;
        while ((lineRead = bufferedReader.readLine()) != null) {
            readFile.append(lineRead);
        }

        //getting rid of nonLatinLetters
        String onlyLettersToLowerCase = readFile.toString().replaceAll("\\p{Punct}", "").toLowerCase();
        onlyLettersToLowerCase = onlyLettersToLowerCase.replaceAll("\\s+", "");


        TreeSet<Character> lettersSet = new TreeSet<>();
        for (int i = 0; i < onlyLettersToLowerCase.length(); i++) {
            lettersSet.add(onlyLettersToLowerCase.charAt(i));
        }

        StringBuilder result = new StringBuilder();
        for (Character character : lettersSet) {
            result.append(character);
        }

/*        List<Character> lettersList = new ArrayList<>();
        for (int i = 0; i < onlyLettersToLowerCase.length(); i++) {
            lettersList.add(onlyLettersToLowerCase.charAt(i));
        }

        Collections.sort(lettersList);

        TreeSet<Character> lettersSet = new TreeSet<>();
        lettersSet.addAll(lettersList);

        StringBuilder result = new StringBuilder();
        for (Character character : lettersSet) {
            result.append(character);
        }*/

        int maxFiveLettersOrLess = 5;
        if (lettersSet.size() < 5) maxFiveLettersOrLess = lettersSet.size();
        String finalResult = result.substring(0, maxFiveLettersOrLess);

        System.out.println(finalResult);

    }
}