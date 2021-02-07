package com.codegym.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;

/* 
Word search

*/
public class Solution {

    private static List<Word> foundWords;

    public static void main(String[] args) {
        //oryginal
        int[][] wordSearch = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };

/*        int[][] wordSearch = new int[][]{
                {'e', 'a', 'a', 'a', 'a', 'a'},
                {'b', 'b', 'b', 'b', 'b', 'b'},
                {'c', 'c', 'c', 'c', 'c', 'c'},
                {'d', 'd', 'd', 'd', 'd', 'd'},
                {'e', 'e', 'e', 'e', 'e', 'e'}
        };*/




        foundWords = detectAllWords(wordSearch, "home", "same");
        writeAllWordsToConsole(foundWords);
        /*
Expected result
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] wordSearch, String... words) {

        List<Word> temporaryListOfWords = new ArrayList<>();

        for (int i = 0; i < words.length; i++){

            String currentWord = words[i];
            char[] currentSearchedWordLetters = currentWord.toCharArray();
            char firstLetterOfSearchedWord = currentSearchedWordLetters[0];

            for(int wiersz = 0; wiersz < wordSearch.length; wiersz++){
                for (int kolumna = 0; kolumna < 6; kolumna++){
                    char currentLetterFromArray = (char) wordSearch[wiersz][kolumna];
                    if (currentLetterFromArray == firstLetterOfSearchedWord){
                        List<Word> newFoundWord = searchEveryDirection(currentSearchedWordLetters, wordSearch, wiersz, kolumna);
                        for (Word newWord : newFoundWord){
                            if (newWord != null) temporaryListOfWords.add(newWord);
                        }
                    }
                }
            }
        }

        return temporaryListOfWords;
    }

    private static List<Word> searchEveryDirection(char[] currentSearchedWordLetters, int[][] wordSearch, int wiersz, int kolumna){
        List<Word> temporaryListOfExactWordFromFoundFirstLetter = new ArrayList<>();

        temporaryListOfExactWordFromFoundFirstLetter.add(lookLeft(currentSearchedWordLetters, wordSearch, wiersz, kolumna));
        temporaryListOfExactWordFromFoundFirstLetter.add(lookTopLeft(currentSearchedWordLetters, wordSearch, wiersz, kolumna));
        temporaryListOfExactWordFromFoundFirstLetter.add(lookTop(currentSearchedWordLetters, wordSearch, wiersz, kolumna));
        temporaryListOfExactWordFromFoundFirstLetter.add(lookTopRight(currentSearchedWordLetters, wordSearch, wiersz, kolumna));
        temporaryListOfExactWordFromFoundFirstLetter.add(lookRight(currentSearchedWordLetters, wordSearch, wiersz, kolumna));
        temporaryListOfExactWordFromFoundFirstLetter.add(lookDownRight(currentSearchedWordLetters, wordSearch, wiersz, kolumna));
        temporaryListOfExactWordFromFoundFirstLetter.add(lookDown(currentSearchedWordLetters, wordSearch, wiersz, kolumna));
        temporaryListOfExactWordFromFoundFirstLetter.add(lookDownLeft(currentSearchedWordLetters, wordSearch, wiersz, kolumna));

        return temporaryListOfExactWordFromFoundFirstLetter;
    }


    private static Word lookLeft(char[] currentSearchedWordLetters, int[][] wordSearch, int wiersz, int kolumna) {

        int czyDodacNastepnaLitere = 0;
        int startX = kolumna;
        int startY = wiersz;
        int endX = 0;
        int endY = 0;
        int ileLiterZWyrazuWykorzystane = 1;

        for (int i = 1; i < currentSearchedWordLetters.length; i++) {

            for (int aktualnaKolumna = kolumna - 1; aktualnaKolumna >= 0; aktualnaKolumna--) {
                ileLiterZWyrazuWykorzystane++;
                char letterFromWord;
                try {
                    letterFromWord = currentSearchedWordLetters[i + czyDodacNastepnaLitere];
                } catch (ArrayIndexOutOfBoundsException e) {
                    break;
                }

                char letterFromArray = (char) wordSearch[wiersz][aktualnaKolumna];

                if (letterFromWord == letterFromArray) {
                    endX = aktualnaKolumna;
                    endY = wiersz;
//                    if (aktualnaKolumna != 0) aktualnaKolumna--;
                    czyDodacNastepnaLitere++;
                    continue;
                } else return null;
            }
            break;
        }

        if (ileLiterZWyrazuWykorzystane >= currentSearchedWordLetters.length){
            String jakiWyraz = String.valueOf(currentSearchedWordLetters);
            return createNewWord(jakiWyraz, startX, startY, endX, endY);
        } else {
            return null;
        }

    }

    private static Word lookTopLeft(char[] currentSearchedWordLetters, int[][] wordSearch, int wiersz, int kolumna){

        int czyDodacNastepnaLitere = 0;
        int startX = kolumna;
        int startY = wiersz;
        int endX = 0;
        int endY = 0;
        int ileLiterZWyrazuWykorzystane = 1;

        for (int i = 1; i < currentSearchedWordLetters.length; i++){

            for (int aktualnyWiersz = wiersz - i; aktualnyWiersz >= 0; aktualnyWiersz--){
                for (int aktualnaKolumna = kolumna - i; aktualnaKolumna >= 0; aktualnaKolumna--){
                    ileLiterZWyrazuWykorzystane++;
                    char letterFromWord;
                    try{
                        letterFromWord = currentSearchedWordLetters[i + czyDodacNastepnaLitere];
                    } catch (ArrayIndexOutOfBoundsException e){
                        break;
                    }

                    char letterFromArray = (char) wordSearch[aktualnyWiersz][aktualnaKolumna];

                    if (letterFromWord == letterFromArray) {
                        endX = aktualnaKolumna;
                        endY = aktualnyWiersz;
                        if (aktualnyWiersz != 0) aktualnyWiersz--;
                        czyDodacNastepnaLitere++;
                        continue;
                    } else {
                        return null;
                    }
                }
            }
            break;
        }

        if (ileLiterZWyrazuWykorzystane >= currentSearchedWordLetters.length){
            String jakiWyraz = String.valueOf(currentSearchedWordLetters);
            return createNewWord(jakiWyraz, startX, startY, endX, endY);
        } else{
            return null;
        }
    }

    private static Word lookTop(char[] currentSearchedWordLetters, int[][] wordSearch, int wiersz, int kolumna) {

        int czyDodacNastepnaLitere = 0;
        int startX = kolumna;
        int startY = wiersz;
        int endX = 0;
        int endY = 0;
        int ileLiterZWyrazuWykorzystane = 1;

        for (int i = 1; i < currentSearchedWordLetters.length; i++) {

            for (int aktualnyWiersz = wiersz - 1; aktualnyWiersz >= 0; aktualnyWiersz--) {
                ileLiterZWyrazuWykorzystane++;
                char letterFromWord;
                try {
                    letterFromWord = currentSearchedWordLetters[i + czyDodacNastepnaLitere];
                } catch (ArrayIndexOutOfBoundsException e) {
                    break;
                }

                char letterFromArray = (char) wordSearch[aktualnyWiersz][kolumna];

                if (letterFromWord == letterFromArray) {
                    endX = kolumna;
                    endY = aktualnyWiersz;
                    czyDodacNastepnaLitere++;
                    continue;
                } else return null;
            }
            break;
        }

        if (ileLiterZWyrazuWykorzystane >= currentSearchedWordLetters.length){
            String jakiWyraz = String.valueOf(currentSearchedWordLetters);
            return createNewWord(jakiWyraz, startX, startY, endX, endY);
        } else {
            return null;
        }

    }

    private static Word lookTopRight(char[] currentSearchedWordLetters, int[][] wordSearch, int wiersz, int kolumna){

        int czyDodacNastepnaLitere = 0;
        int startX = kolumna;
        int startY = wiersz;
        int endX = 0;
        int endY = 0;
        int ileLiterZWyrazuWykorzystane = 1;

        for (int i = 1; i < currentSearchedWordLetters.length; i++){

            for (int aktualnyWiersz = wiersz - i; aktualnyWiersz >= 0; aktualnyWiersz--){
                for (int aktualnaKolumna = kolumna + i; aktualnaKolumna < 6; aktualnaKolumna++){
                    ileLiterZWyrazuWykorzystane++;
                    char letterFromWord;
                    try{
                        letterFromWord = currentSearchedWordLetters[i + czyDodacNastepnaLitere];
                    } catch (ArrayIndexOutOfBoundsException e){
                        break;
                    }

                    char letterFromArray = (char) wordSearch[aktualnyWiersz][aktualnaKolumna];

                    if (letterFromWord == letterFromArray) {
                        endX = aktualnaKolumna;
                        endY = aktualnyWiersz;
                        if (aktualnyWiersz != 0) aktualnyWiersz--;
                        czyDodacNastepnaLitere++;
                        continue;
                    } else {
                        return null;
                    }
                }
            }
            break;
        }

        if (ileLiterZWyrazuWykorzystane >= currentSearchedWordLetters.length){
            String jakiWyraz = String.valueOf(currentSearchedWordLetters);
            return createNewWord(jakiWyraz, startX, startY, endX, endY);
        } else {
            return null;
        }
    }

    private static Word lookRight(char[] currentSearchedWordLetters, int[][] wordSearch, int wiersz, int kolumna) {

        int czyDodacNastepnaLitere = 0;
        int startX = kolumna;
        int startY = wiersz;
        int endX = 0;
        int endY = 0;
        int ileLiterZWyrazuWykorzystane = 1;

        for (int i = 1; i < currentSearchedWordLetters.length; i++) {

            for (int aktualnaKolumna = kolumna + 1; aktualnaKolumna < 6; aktualnaKolumna++) {
                ileLiterZWyrazuWykorzystane++;
                char letterFromWord;
                try {
                    letterFromWord = currentSearchedWordLetters[i + czyDodacNastepnaLitere];
                } catch (ArrayIndexOutOfBoundsException e) {
                    break;
                }

                char letterFromArray = (char) wordSearch[wiersz][aktualnaKolumna];

                if (letterFromWord == letterFromArray) {
                    endX = aktualnaKolumna;
                    endY = wiersz;
//                    if (aktualnaKolumna != 0) aktualnaKolumna--;
                    czyDodacNastepnaLitere++;
                    continue;
                } else return null;
            }
            break;
        }

        if (ileLiterZWyrazuWykorzystane >= currentSearchedWordLetters.length){
            String jakiWyraz = String.valueOf(currentSearchedWordLetters);
            return createNewWord(jakiWyraz, startX, startY, endX, endY);
        } else {
            return null;
        }

    }

    private static Word lookDownRight(char[] currentSearchedWordLetters, int[][] wordSearch, int wiersz, int kolumna){

        int czyDodacNastepnaLitere = 0;
        int startX = kolumna;
        int startY = wiersz;
        int endX = 0;
        int endY = 0;
        int ileLiterZWyrazuWykorzystane = 1;

        for (int i = 1; i < currentSearchedWordLetters.length; i++){


            for (int aktualnyWiersz = wiersz + i; aktualnyWiersz < 5; aktualnyWiersz++){
                for (int aktualnaKolumna = kolumna + i; aktualnaKolumna < 6; aktualnaKolumna++){
                    ileLiterZWyrazuWykorzystane++;
                    char letterFromWord;
                    try{
                        letterFromWord = currentSearchedWordLetters[i + czyDodacNastepnaLitere];
                    } catch (ArrayIndexOutOfBoundsException e){
                        break;
                    }

                    char letterFromArray = '4';
                    if (aktualnyWiersz < 4 && aktualnaKolumna < 6){
                        letterFromArray = (char) wordSearch[aktualnyWiersz][aktualnaKolumna];
                    }

                    if (letterFromWord == letterFromArray) {
                        endX = aktualnaKolumna;
                        endY = aktualnyWiersz;
                        if (aktualnyWiersz != 0) aktualnyWiersz++;
                        czyDodacNastepnaLitere++;
                        continue;
                    } else {
                        return null;
                    }
                }
            }
            break;
        }

        if (ileLiterZWyrazuWykorzystane >= currentSearchedWordLetters.length){
            String jakiWyraz = String.valueOf(currentSearchedWordLetters);
            return createNewWord(jakiWyraz, startX, startY, endX, endY);
        } else {
            return null;
        }
    }

    private static Word lookDown(char[] currentSearchedWordLetters, int[][] wordSearch, int wiersz, int kolumna) {

        int czyDodacNastepnaLitere = 0;
        int startX = kolumna;
        int startY = wiersz;
        int endX = 0;
        int endY = 0;
        int ileLiterZWyrazuWykorzystane = 1;

        for (int i = 1; i < currentSearchedWordLetters.length; i++) {

            for (int aktualnyWiersz = wiersz + 1; aktualnyWiersz < 5; aktualnyWiersz++) {
                ileLiterZWyrazuWykorzystane++;
                char letterFromWord;
                try {
                    letterFromWord = currentSearchedWordLetters[i + czyDodacNastepnaLitere];
                } catch (ArrayIndexOutOfBoundsException e) {
                    break;
                }

                char letterFromArray = (char) wordSearch[aktualnyWiersz][kolumna];

                if (letterFromWord == letterFromArray) {
                    endX = kolumna;
                    endY = aktualnyWiersz;
                    czyDodacNastepnaLitere++;
                    continue;
                } else return null;
            }
            break;
        }

        if (ileLiterZWyrazuWykorzystane >= currentSearchedWordLetters.length){
            String jakiWyraz = String.valueOf(currentSearchedWordLetters);
            return createNewWord(jakiWyraz, startX, startY, endX, endY);
        } else {
            return null;
        }

    }

    private static Word lookDownLeft(char[] currentSearchedWordLetters, int[][] wordSearch, int wiersz, int kolumna){

        int czyDodacNastepnaLitere = 0;
        int startX = kolumna;
        int startY = wiersz;
        int endX = 0;
        int endY = 0;
        int ileLiterZWyrazuWykorzystane = 1;

        for (int i = 1; i < currentSearchedWordLetters.length; i++){


            for (int aktualnyWiersz = wiersz + i; aktualnyWiersz < 5; aktualnyWiersz++){
                for (int aktualnaKolumna = kolumna - i; aktualnaKolumna >= 0; aktualnaKolumna--){
                    ileLiterZWyrazuWykorzystane++;
                    char letterFromWord;
                    try{
                        letterFromWord = currentSearchedWordLetters[i + czyDodacNastepnaLitere];
                    } catch (ArrayIndexOutOfBoundsException e){
                        break;
                    }

                    char letterFromArray = (char) wordSearch[aktualnyWiersz][aktualnaKolumna];

                    if (letterFromWord == letterFromArray) {
                        endX = aktualnaKolumna;
                        endY = aktualnyWiersz;
                        if (aktualnyWiersz != 0) aktualnyWiersz++;
                        czyDodacNastepnaLitere++;
                        continue;
                    } else {
                        return null;
                    }
                }
            }
            break;
        }

        if (ileLiterZWyrazuWykorzystane >= currentSearchedWordLetters.length){
            String jakiWyraz = String.valueOf(currentSearchedWordLetters);
            return createNewWord(jakiWyraz, startX, startY, endX, endY);
        } else {
            return null;
        }
    }

    private static Word createNewWord(String jakiWyrazSzukany, int startX, int startY, int endX, int endY){
        Word word = new Word(jakiWyrazSzukany);
        word.startX = startX;
        word.startY = startY;
        word.endX = endX;
        word.endY = endY;

        return word;
    }

    private static void writeAllWordsToConsole(List<Word> foundWords){
        for (Word everyWordFromList : foundWords){
            System.out.println(everyWordFromList);
        }
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
