package pl.codegym.task.task19.task1924;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Zastępowanie liczb
*/

/*
plik:
c:\!!programowanie\cwiczenia_pliki\pliki22\pliki22_source.txt
*/


public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();
    static String fileName;
    static String odczytanyStringZPliku;

    //1. W bloku statycznym, inicjalizuj mapę zawierającą pary (liczba, słowo) od 0 do 12 włącznie.
    //Na przykład, (0, "zero"), (1, "one"), (2, "two")
    static {
        map.put(0, "zero");
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(4, "four");
        map.put(5, "five");
        map.put(6, "six");
        map.put(7, "seven");
        map.put(8, "eight");
        map.put(9, "nine");
        map.put(10, "ten");
        map.put(11, "eleven");
        map.put(12, "twelve");
    }

    public static void main(String[] args) {

        odczytajNazwePliku();
        odczytajZawartoscPliku(fileName);

        //Przykładowa zawartość pliku:
        //To kosztuje 1 dolara, a to jest 12.
        //Nazwa zmiennej to file1.
        //110 to liczba.
        //
        //Przykładowy wynik konsoli:
        //To kosztuje one dolara, a to jest twelve.
        //Nazwa zmiennej to file1.
        //110 to liczba.
        //3. Użyj mapy, aby zastąpić wszystkie liczby słowami.
        odczytanyStringZPliku = zamienOdpowiednieLiczbyNaText(odczytanyStringZPliku);
        System.out.println(odczytanyStringZPliku);


    }

    private static void odczytajNazwePliku(){
        try{
            //2. Program musi odczytywać nazwę pliku z konsoli (użyj BufferedReader).
            BufferedReader bufferedReaderFromConsole = new BufferedReader(new InputStreamReader(System.in));
            fileName = bufferedReaderFromConsole.readLine();

            //3. BufferedReader używany do odczytu danych wejściowych z konsoli musi zostać zamknięty po jego zastosowaniu.
            bufferedReaderFromConsole.close();
        } catch (IOException e){}
    }

    private static void odczytajZawartoscPliku(String fileName){
        //4. Program musi odczytywać zawartość pliku (użyj konstruktora FileReader).
        StringBuilder stringOdczytany = new StringBuilder();
        try{
            BufferedReader bufferedReaderFromFile = new BufferedReader(new FileReader(fileName));
            int znakZPliku;
            while ((znakZPliku = bufferedReaderFromFile.read()) != -1){
                stringOdczytany.append((char)znakZPliku);
            }
            odczytanyStringZPliku = stringOdczytany.toString();

            //5. Strumień wejściowy pliku (FileReader) musi zostać zamknięty.
            bufferedReaderFromFile.close();
        } catch (IOException e) {}
    }

    private static String zamienOdpowiednieLiczbyNaText(String odczytanyStringZPliku){

        String rezultat = odczytanyStringZPliku;

        for (Map.Entry<Integer, String> paraMapa : map.entrySet()){

            // white space || digits || whilespace
            rezultat = rezultat.replaceAll("\\s" + paraMapa.getKey() + "\\s", " " + paraMapa.getValue() + " ");

            // white space || digits || comma
            rezultat = rezultat.replaceAll(" " + paraMapa.getKey() + ",", " " + paraMapa.getValue() + ",");

            // white space || digits || dot
            rezultat = rezultat.replaceAll(" " + paraMapa.getKey() + "\\.", " " + paraMapa.getValue() + ".");

            // start || digits || whitespace
            rezultat = rezultat.replaceAll("^" + paraMapa.getKey() + "\\s", paraMapa.getValue() + " ");

            // start || digits || comma
            rezultat = rezultat.replaceAll("^" + paraMapa.getKey() + ",", paraMapa.getValue() + ",");

            // start || digits || dot
            rezultat = rezultat.replaceAll("^" + paraMapa.getKey() + "\\.", paraMapa.getValue() + ".");

            // white space || digits || end
            rezultat = rezultat.replaceAll("\\s" + paraMapa.getKey() + "$", " " + paraMapa.getValue());

        }
        return rezultat;
    }

}
