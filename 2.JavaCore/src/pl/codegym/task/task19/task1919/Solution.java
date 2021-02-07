package pl.codegym.task.task19.task1919;

/* 
Obliczanie wynagrodzeń
*/

/*
//Pierwszym parametrem metody main jest nazwa pliku.
//Każdy wiersz określonego pliku ma następujący format:
//name value
//gdzie [name] to String, a [value] to double. [name] i [value] są oddzielone spacją.

parametry:
c:\!!programowanie\cwiczenia_pliki\pliki18\pliki18.txt
*/


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) {

        List<String> linesFromFile = new ArrayList<>();
        List<String> names = new ArrayList<>();
        List<Double> values = new ArrayList<>();
        Map<String, Double> mapaNameValue = new TreeMap<String, Double>();

        //2. Program musi odczytywać zawartość pliku (użyj konstruktora FileReader).
        try {
            BufferedReader bufferedReaderFile = new BufferedReader(new FileReader(args[0]));
            String lineFromFileString = "";
            while ((lineFromFileString = bufferedReaderFile.readLine()) != null){
                linesFromFile.add(lineFromFileString);
            }

            //3. Strumień wejściowy pliku (FileReader) musi zostać zamknięty.
            bufferedReaderFile.close();

        } catch (IOException e){}

        //rozdział do List names/values
        for (String liniaString : linesFromFile){
            StringTokenizer tokens = new StringTokenizer(liniaString, " ");
            names.add(tokens.nextToken());
            values.add(Double.parseDouble(tokens.nextToken()));
        }

        //dodanie do TreeMap
        for (String namesInArrayList : names){
            mapaNameValue.put(namesInArrayList, new Double(0.0));
        }

        //Znajdź sumę wszystkich wartości dla każdego nazwiska.
        // sumowanie Values (jeżeli jest co sumować)
        for (int i = 0; i < names.size(); i++){
            String aktualnyName = names.get(i);
            Double aktualnyDouble = values.get(i);

            for(Map.Entry<String, Double> paraZTreeMapy : mapaNameValue.entrySet()){
                String stringDoPorownania = paraZTreeMapy.getKey();
                Double doubleDoPorownania = paraZTreeMapy.getValue();

                if (stringDoPorownania.equals(aktualnyName)) paraZTreeMapy.setValue(doubleDoPorownania + aktualnyDouble);

                }
            }

        //4. Program powinien zapisywać w konsoli każde nazwisko, posortowane w kolejności rosnącej oraz sumę wszystkich jego wartości.
        //Przykładowy wynik:
        //Baxter 1.35
        //Peterson 5.1
        //Smith 6.0
        for (Map.Entry<String, Double> paraZTreeMapy : mapaNameValue.entrySet()){
            String stringDoWyswietlenia = paraZTreeMapy.getKey();
            Double doubleDoWyswietlenia = paraZTreeMapy.getValue();

            System.out.println(stringDoWyswietlenia + " " + doubleDoWyswietlenia);
        }
    }
}
