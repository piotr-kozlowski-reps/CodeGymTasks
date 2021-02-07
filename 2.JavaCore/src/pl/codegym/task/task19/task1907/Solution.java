package pl.codegym.task.task19.task1907;

/* 
Liczenie słów
*/


/*
plik:
c:\!!programowanie\cwiczenia_pliki\pliki12\plik12.txt
*/


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {

        //1. Program musi odczytywać nazwę pliku z konsoli (użyj BufferedReader).
        String fileName = "";
        try{
            BufferedReader bufferedReaderConsole = new BufferedReader(new InputStreamReader(System.in));
            fileName = bufferedReaderConsole.readLine();

            //2. BufferedReader używany do odczytu danych wejściowych z konsoli musi zostać zamknięty po jego zastosowaniu.
            bufferedReaderConsole.close();
        } catch (IOException e){}


        //3. Program musi odczytywać zawartość pliku (użyj konstruktora FileReader z parametrem String).
        StringBuilder wczytaneZnakiZPliku = new StringBuilder();
        try{
            FileReader fileReader = new FileReader(fileName);

            while (fileReader.ready()){
                wczytaneZnakiZPliku.append((char)fileReader.read());
            }

            //4. Strumień wejściowy pliku (FileReader) musi zostać zamknięty.
            fileReader.close();
        } catch (IOException e) {}

        //dzielę string na wyrazy po znakach intepunkcyjnych
        StringTokenizer tokenizer = new StringTokenizer(wczytaneZnakiZPliku.toString(), " \t\n\r\f,.:;?![]'()");

        //5. Program musi wyprowadzić do konsoli liczbę powtórzeń słowa "świat" w pliku.
        int ileRazySlowoSwiat = 0;
        while (tokenizer.hasMoreTokens()){
            if (tokenizer.nextToken().equals("świat")) ileRazySlowoSwiat++;
        }

        System.out.println(ileRazySlowoSwiat);

    }
}
