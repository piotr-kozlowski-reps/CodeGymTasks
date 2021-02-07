package pl.codegym.task.task19.task1918;

/* 
Wprowadzanie znaczników
*/

/*
plik:
c:\!!programowanie\cwiczenia_pliki\pliki25\pliki25.txt
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {

        String fileName = "";
        StringBuilder fileRead = new StringBuilder();
        String znacznik;
        List<String> podzialPoKoncuZnacznika = new ArrayList<>();
        List<String> polaczoneStringi = new ArrayList<>();
        List<String> finalneStringiArrayList = new ArrayList<>();

        znacznik = args[0];

        //1. Program musi odczytywać nazwę pliku z konsoli (użyj BufferedReader).
        try{
            BufferedReader bufferedReaderFromConsole = new BufferedReader(new InputStreamReader(System.in));
            fileName = bufferedReaderFromConsole.readLine();

            //2. BufferedReader używany do odczytu danych wejściowych z konsoli musi zostać zamknięty po jego zastosowaniu.
            bufferedReaderFromConsole.close();
        } catch (IOException e){}

        //3. Program musi odczytywać zawartość pliku (użyj konstruktora FileReader).
        try{
            FileReader fileReaderFromFile = new FileReader(fileName);
            int znak;
            while ((znak = fileReaderFromFile.read()) != -1){
                fileRead = fileRead.append((char) znak);
            }


            //4. Strumień wejściowy pliku (FileReader) musi zostać zamknięty.
            fileReaderFromFile.close();
        } catch (IOException e){}


        //5. Program musi zapisywać w konsoli wszystkie znaczniki,
        // które odpowiadają znacznikowi określonemu przez argument przekazany do metody main.

        // podzial po koncu znacznika
        String regexKoniecZnacznika = "/" + znacznik + ">";
        String[] tokens = fileRead.toString().split(regexKoniecZnacznika);
        for (int i = 0; i < tokens.length; i++){
            podzialPoKoncuZnacznika.add(tokens[i] + "/" + znacznik + ">");
        }

        //dodaje Stringi gdy bylo kilka znacznikow wewnetrznych
        //licze ile znacznikow w kazdym Stringu
        String regexPoczatekZnacznika = "<" + znacznik;
        ListIterator<String> listIterator = podzialPoKoncuZnacznika.listIterator();
        while (listIterator.hasNext()){

            // ile w Stringu bylo znacznikow
            int ileZnacznikowWStringu = 0;
            String aktualnyStringZListy = listIterator.next();
            Matcher matcher = Pattern.compile(regexPoczatekZnacznika).matcher(aktualnyStringZListy);
            while (matcher.find()){
                ileZnacznikowWStringu++;
            }

            //lacze stringi gdy znacznikow bylo wiecej niz jeden
            for (int i = 0; i < ileZnacznikowWStringu - 1; i++){
                aktualnyStringZListy += listIterator.next();
            }

            polaczoneStringi.add(aktualnyStringZListy);
        }

        // odcinam wszystko przed pierwszym znacznikiem
        listIterator = polaczoneStringi.listIterator();
        while (listIterator.hasNext()){
            String aktualnyStringZListy = listIterator.next();
            String finalnyString = "";
            tokens = aktualnyStringZListy.split(regexPoczatekZnacznika);
            for (int i = 1; i < tokens.length; i++){
                finalnyString += "<" + znacznik + tokens[i];
            }

            finalneStringiArrayList.add(finalnyString);
        }

        //Liczba spacji, znaków nowej linii (\n) lub powrotów karetki (\r) nie ma wpływu na wynik.
        //wyrzucam (\n) i (\r)
        for (int i = 0; i < finalneStringiArrayList.size(); i++){
            String aktualnyStringZListy = finalneStringiArrayList.get(i);
            aktualnyStringZListy = aktualnyStringZListy.replaceAll("[\\r\\n]", "");
            finalneStringiArrayList.set(i, aktualnyStringZListy);
        }


        //wyjscie do konsoli
        for(String liniaArrayList : finalneStringiArrayList){
            System.out.println(liniaArrayList);
        }


    }
}
