package com.codegym.task.task22.task2209;

/* 
Make a word chain

*/

/*
File:
c:\!!programowanie\cwiczenia_pliki\pliki32\pliki32.txt

*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

//    private String wordsFromFile;

    public static void main(String[] args) {

        String fileName = "";
        String wordsFromFile = "";

        //1. The main method must read the filename from the keyboard.
        try{
            BufferedReader bufferedReaderFromConsole = new BufferedReader(new InputStreamReader(System.in));
            fileName = bufferedReaderFromConsole.readLine();

            bufferedReaderFromConsole.close();
        } catch (Exception e) {e.printStackTrace();}

        //Read words from file
        try{
            BufferedReader bufferedReaderFromFile = new BufferedReader(new FileReader(fileName));
            String line = "";
            while ((line = bufferedReaderFromFile.readLine()) != null){
                wordsFromFile += line + " ";
            }

            bufferedReaderFromFile.close();
        } catch (Exception e) {e.printStackTrace();}

        String[] splittedString = wordsFromFile.split("\\s+");

        // ...
        StringBuilder result = getLine(splittedString);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {

        StringBuilder result = new StringBuilder();

        if (words.length == 0) {
            return result;
        }

        List<String> wordsList = Arrays.asList(words.clone());
        List<Character> firstLettersList = fillWithFirstLetters(wordsList);
        List<Character> lastLettersList = fillWithLastLetters(wordsList);

        wordsList = getRidOfWordsThatCannotBeUsed(wordsList, firstLettersList, lastLettersList);
        wordsList = getRidOfDuplicates(wordsList);

        // update ListsOfLetters
        firstLettersList = fillWithFirstLetters(wordsList);
        lastLettersList = fillWithLastLetters(wordsList);

        //first word can start with a letter, that is not a last letter for any other word
        wordsList = setFirstWord(wordsList, firstLettersList, lastLettersList);
        wordsList = arrangeRestOfTheWords(wordsList);

        for (int i = 0; i < wordsList.size(); i++){
            if (i < (wordsList.size() - 1)) result.append(wordsList.get(i)).append(" ");
            else result.append(wordsList.get(i));
        }

        return result;
    }

    private static List<Character> fillWithFirstLetters(List<String> wordsList){
        List<Character> listOfFirstLetters = new ArrayList<>();
        for (int i = 0; i < wordsList.size(); i++){
            String word = wordsList.get(i);
            listOfFirstLetters.add(Character.toLowerCase(word.charAt(0)));
        }

        return listOfFirstLetters;
    }

    private static List<Character> fillWithLastLetters(List<String> wordsList){
        List<Character> listOfLastLetters = new ArrayList<>();
        for (int i = 0; i < wordsList.size(); i++){
            String word = wordsList.get(i);
            int howManyLetters = word.length();
            listOfLastLetters.add(Character.toLowerCase(word.charAt(howManyLetters - 1)));
        }

        return listOfLastLetters;
    }

    private static List<String> getRidOfWordsThatCannotBeUsed(List<String> wordsList, List<Character> firstLettersList, List<Character> lastLettersList){
        List<String> wordsListResult = new ArrayList<>();

        for (int i = 0; i < wordsList.size(); i++){

            boolean wordCanBeUsed = false;
            String word = wordsList.get(i);

            for (int j = 0; j < wordsList.size(); j++){
                char firstLetterInWord = Character.toLowerCase(word.charAt(0));
                char lastLetterInWord = Character.toLowerCase(word.charAt(word.length() - 1));
                char firstLetterToCompare = Character.toLowerCase(firstLettersList.get(j));
                char lastLetterToCompare = Character.toLowerCase(lastLettersList.get(j));

                if (j != i){
                    if(firstLetterInWord == lastLetterToCompare || lastLetterInWord == firstLetterToCompare) wordCanBeUsed = true;
                }
            }
            if (wordCanBeUsed) wordsListResult.add(word);
        }


        return wordsListResult;
    }

    private static List<String> getRidOfDuplicates(List<String> wordsList){
        List<String> wordsListResult = wordsList;

        Iterator iterator = wordsListResult.iterator();
        while (iterator.hasNext()){
            int howManyTimes = 0;
            String wordToBeCompared = (String) iterator.next();
            for(String wordsFromArrayToCompare : wordsListResult){
                if (wordToBeCompared.equals(wordsFromArrayToCompare)){
                    howManyTimes++;
                    if (howManyTimes == 2){
                        iterator.remove();
                        break;
                    }
                }
            }
        }

        return wordsListResult;
    }

    private static List<String> setFirstWord(List<String> wordsList, List<Character> firstLettersList, List<Character> lastLettersList){
        List<String> wordsListResult = new ArrayList<>();
        List<String> wordsThatCanBeFirst = new ArrayList<>();           // word(s) that can start with a letter, but That letter is not an ending for any other words

        for (int i = 0; i < wordsList.size(); i++){

            int checkIfComparisionWasAtLeastOnceTrue = 0;
            String word = wordsList.get(i);

            for (int j = 0; j < wordsList.size(); j++){
                char firstLetterInWord = Character.toLowerCase(word.charAt(0));
                char lastLetterToCompare = Character.toLowerCase(lastLettersList.get(j));

                if (j != i){
                    if(firstLetterInWord == lastLetterToCompare) checkIfComparisionWasAtLeastOnceTrue++;
                }
            }
            if (checkIfComparisionWasAtLeastOnceTrue == 0) wordsThatCanBeFirst.add(word);
        }

        //add first word and rest of the words to wordsListResult
        if (wordsThatCanBeFirst.size() > 0){

            //first word
            for (String word : wordsThatCanBeFirst){
                wordsListResult.add(word);
            }

            //rest of the words
            for (String wordToBeAdded : wordsList){

                for (String wordToBeChecked : wordsThatCanBeFirst){
                    if (!wordToBeAdded.equals(wordToBeChecked)) wordsListResult.add(wordToBeAdded);
                }

            }

            return wordsListResult;
        } else {
            return wordsList;
        }

        }

    private static List<String> arrangeRestOfTheWords(List<String> wordsList){
        List<String> wordsListResult = new ArrayList<>();

        // add first word to temporary wordsListResult and delete it from entering ArrayLIst
        wordsListResult.add(wordsList.get(0));
        wordsList.remove(0);

        // arrange rest of the words - from 1 to the end of ArrayLIst
        for (int i = 0; i < wordsList.size(); i++){
            for (int j = 0; j < wordsList.size(); j++){

                String wordToBeCompared = wordsListResult.get(i);
                char lastLetterOfWordToBeCompared = Character.toLowerCase(wordToBeCompared.charAt(wordToBeCompared.length() - 1));

                String searchedWord = wordsList.get(j);
                char firstLetterOfSearchedWord = Character.toLowerCase(searchedWord.charAt(0));

                if (lastLetterOfWordToBeCompared == firstLetterOfSearchedWord){
                    wordsListResult.add(searchedWord);
                    wordsList.set(j, "##");
                    break;
                }
            }

        }

        return wordsListResult;
    }
}