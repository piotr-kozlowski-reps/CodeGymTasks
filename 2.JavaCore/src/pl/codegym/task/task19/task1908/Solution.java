package pl.codegym.task.task19.task1908;

/* 
Wybieranie numerów
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

/*
pliki:
c:\!!programowanie\cwiczenia_pliki\pliki15\plik15source.txt
c:\!!programowanie\cwiczenia_pliki\pliki15\plik15destination.txt
*/



public class Solution {
    public static void main(String[] args) {

        List<String> wyrazyZPliku = new ArrayList<String>();

        //Wczytaj 2 nazwy plików z konsoli.
        String fileSource = "";
        String fileDestination = "";
        try{
            BufferedReader bufferedReaderConsole = new BufferedReader(new InputStreamReader(System.in));
            fileSource = bufferedReaderConsole.readLine();
            fileDestination = bufferedReaderConsole.readLine();

            //2. BufferedReader używany do odczytu danych wejściowych z konsoli musi zostać zamknięty po jego zastosowaniu.
            bufferedReaderConsole.close();
        } catch (IOException e){}

        //3. Program musi odczytywać zawartość pliku (użyj konstruktora BufferedReader z parametrem FileReader).
        try {
            BufferedReader bufferedReaderSource = new BufferedReader(new FileReader(fileSource));
            BufferedWriter bufferedWriterDestination = new BufferedWriter(new FileWriter(fileDestination));

            //wczytuję plik do String'a
            StringBuilder wczytaneZnakiZPliku = new StringBuilder();
            int znakPliku;
            while ((znakPliku = bufferedReaderSource.read()) != -1){
                wczytaneZnakiZPliku.append((char) znakPliku);
            }

            // rozdzielam po spacji i dodaje do ArrayList
            StringTokenizer tokens = new StringTokenizer(wczytaneZnakiZPliku.toString(), " ");
            while (tokens.hasMoreTokens()){
                wyrazyZPliku.add(tokens.nextToken());
            }

            // weryfikuję każdy z elementów ArrayList czy jest liczbą i wyrzucam z ArrayList jeżeli tak nie jest
            Iterator<String> iterator = wyrazyZPliku.iterator();
            while (iterator.hasNext()){
                String wyraz = iterator.next();
                if (!czyWyrazJestLiczba(wyraz)) iterator.remove();
            }

            //5. Program musi zapisywać wszystkie liczby z pierwszego pliku, oddzielone spacjami, do drugiego pliku
            for (int i = 0; i < wyrazyZPliku.size(); i++){
                if (i < wyrazyZPliku.size()) bufferedWriterDestination.write(wyrazyZPliku.get(i) + " ");
                else bufferedWriterDestination.write(wyrazyZPliku.get(i));
            }

            //4. Strumień wejściowy pliku (BufferedReader) musi zostać zamknięty.
            //6. Strumień wyjściowy pliku (BufferedWriter) musi zostać zamknięty.
            bufferedReaderSource.close();
            bufferedWriterDestination.close();

        } catch (IOException e){}

    }

    public static boolean czyWyrazJestLiczba(String wyraz){
        boolean jestLiczba = false;

        String regex = "[0-9]+";
        jestLiczba = wyraz.matches(regex);

        return jestLiczba;
    }

}
