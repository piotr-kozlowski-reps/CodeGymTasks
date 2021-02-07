package pl.codegym.task.task19.task1926;

/* 
Lustrzane odbicie
*/

/*
plik:
c:\!!programowanie\cwiczenia_pliki\pliki24\pliki24_source.txt
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    private static String nazwaPliku;
    private static List<String> linieZPliku = new ArrayList<>();


    public static void main(String[] args) {

        wczytajNazwePlikuZKonsoli();
        dodajLinieZPlikuDoArrayListy(nazwaPliku);
        odwrocKolejnoscZnakowWLiniach();
        wyswietlWynik();

    }

    private static void wczytajNazwePlikuZKonsoli(){
        try{
            //1. Program musi odczytywać nazwę pliku z konsoli (użyj BufferedReader).
            BufferedReader bufferedReaderFromConsole = new BufferedReader(new InputStreamReader(System.in));
            nazwaPliku = bufferedReaderFromConsole.readLine();
            //2. BufferedReader używany do odczytu danych wejściowych z konsoli musi zostać zamknięty po jego zastosowaniu.
            bufferedReaderFromConsole.close();
        } catch(IOException e){}
    }


    private static void dodajLinieZPlikuDoArrayListy(String nazwaPliku){
        try{
            //3. Program musi odczytywać zawartość pliku (użyj konstruktora FileReader).
            BufferedReader bufferedReaderFromFile = new BufferedReader(new FileReader(nazwaPliku));
            String linia;
            while ((linia = bufferedReaderFromFile.readLine()) != null){
                linieZPliku.add(linia);
            }

            //4. Strumień wejściowy pliku (FileReader) musi zostać zamknięty.
            bufferedReaderFromFile.close();
        } catch (IOException e){}
    }


    private static void odwrocKolejnoscZnakowWLiniach(){
        for (int i = 0; i < linieZPliku.size(); i++){
            StringBuilder liniaDoOdwrocenia = new StringBuilder(linieZPliku.get(i));
            liniaDoOdwrocenia.reverse();
            linieZPliku.set(i, liniaDoOdwrocenia.toString());
        }
    }


    private static void wyswietlWynik(){
        for (int i = 0; i < linieZPliku.size(); i++){
            System.out.println(linieZPliku.get(i));
        }
    }


}
