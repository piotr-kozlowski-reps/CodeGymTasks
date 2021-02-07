package com.codegym.task.task22.task2207;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

/* 
Inverted words

*/

/*
file:
c:\!!programowanie\cwiczenia_pliki\pliki31\pliki31.txt

*/

public class Solution {
    public static List<Pair> result = new LinkedList<>();
    private static StringBuilder readStringBuilderFromFile = new StringBuilder();

    public static void main(String[] args) {

        //1. The main method must read the filename from the keyboard.
        String fileName = null;

        try{
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            fileName = bufferedReader.readLine();
            bufferedReader.close();
        } catch (IOException e){
            e.printStackTrace();
        }

        //read from file and append to StringBuilder readStringBuilderFromFile
        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            String lineFromFile;
            while ((lineFromFile = bufferedReader.readLine()) != null){
                readStringBuilderFromFile.append(lineFromFile).append(" ");
            }
            bufferedReader.close();
        } catch (Exception e){
            e.printStackTrace();
        }

        String[] splittedStringArray = readStringBuilderFromFile.toString().split("\\s+");

        for (int i = 0; i < splittedStringArray.length; i++){
            if (splittedStringArray[i] != null) checkForInversedWord(splittedStringArray, splittedStringArray[i], i);
        }

//        for (Pair pair : result){
//            System.out.println(pair);
//        }

    }

    private static void checkForInversedWord(String[] splittedStringArray, String stringToBeChecked, int iArg){
        for (int i = 0; i < splittedStringArray.length; i++){
            if (i != iArg) {
                StringBuilder stringInversed = new StringBuilder(splittedStringArray[i]);
                stringInversed = stringInversed.reverse();
                if (stringInversed.toString().equals(stringToBeChecked)){
                    addToListOfPairs(stringToBeChecked, stringInversed.reverse().toString());
                }
            }
        }
    }

    private static void addToListOfPairs(String stringChecked, String stringInversed){
        boolean isTheStringOnList = false;
        for (Pair pair : result){
            if (stringChecked.equals(pair.first) || stringChecked.equals(pair.second)) isTheStringOnList = true;
        }

        if (!isTheStringOnList) {
            Pair pair = new Pair();
            pair.first = stringChecked;
            pair.second = stringInversed;
            result.add(pair);
        }
    }



    public static class Pair {
        String first;
        String second;

        public Pair(){
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null ? second :
                            second == null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;
        }
    }

}
