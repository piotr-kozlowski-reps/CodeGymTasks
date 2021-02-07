package pl.codegym.task.task19.task1923;

/* 
Słowa z liczbami
*/

/*
argumenty:
c:\!!programowanie\cwiczenia_pliki\pliki21\pliki21_source.txt c:\!!programowanie\cwiczenia_pliki\pliki21\pliki21_destination.txt
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Solution {
    public static void main(String[] args) {

        List<String> wyrazyZPliku = new ArrayList<>();
        //Pierwszy parametr metody main to file1, a drugi to file2.
        String fileSource = args[0];
        String fileDestination = args[1];

        //2. Program musi odczytywać zawartość pierwszego pliku (użyj konstruktora z parametrem String).
        //file1 zawiera wiersze z wyrazami oddzielonymi spacjami.
        try{
            BufferedReader bufferedReaderFromFile = new BufferedReader(new FileReader(fileSource));
            String liniaZPliku;
            while ((liniaZPliku = bufferedReaderFromFile.readLine()) != null){
                String[] stringPodzialPoSpacji = liniaZPliku.split("\\s+");

                for (String wyrazZArray : stringPodzialPoSpacji){
                    wyrazyZPliku.add(wyrazZArray);
                }

            }
            //3. Strumień wejściowy pliku (FileReader) musi zostać zamknięty.
            bufferedReaderFromFile.close();
        } catch (IOException e){}

        //Zapisz do file2 wszystkie słowa, które zawierają liczby, np. a1 lub abc3d. Oddziel te słowa spacjami.
        //4. Program powinien zapisywać do drugiego pliku wszystkie słowa z pierwszego pliku zawierające liczby (użyj FileWriter).

        //czyszczę ArrayList z wyrazow bez liczb
        Iterator<String> iterator = wyrazyZPliku.iterator();
        while (iterator.hasNext()){
            String aktualnyInterator = iterator.next();
            if(!hasDigits(aktualnyInterator)) iterator.remove();
        }

        // zapisuję
        try{
            BufferedWriter bufferedWriterToDestinationFile = new BufferedWriter(new FileWriter(fileDestination));

            for (int i = 0; i < wyrazyZPliku.size(); i++){
                if (i < wyrazyZPliku.size() - 1) bufferedWriterToDestinationFile.write(wyrazyZPliku.get(i) + " ");
                if (i == wyrazyZPliku.size() - 1) bufferedWriterToDestinationFile.write(wyrazyZPliku.get(i));
            }

            //5. Strumień wyjściowy pliku (FileWriter) musi zostać zamknięty.
            bufferedWriterToDestinationFile.close();
        } catch (IOException w) {}

    }

    private static boolean hasDigits(String stringFromIterator){
        boolean yesHasDigits = false;
        for (int i = 0; i < stringFromIterator.length(); i++){
            char znak = stringFromIterator.charAt(i);
            if (Character.isDigit(znak)){
                yesHasDigits = true;
                break;
            }
        }
        return yesHasDigits;
    }
}
