package pl.codegym.task.task19.task1925;

/* 
Long words
*/

/*
files:
c:\!!programowanie\cwiczenia_pliki\pliki23\pliki23_source.txt
c:\!!programowanie\cwiczenia_pliki\pliki23\pliki23_destination.txt
*/



import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Solution {

    private String file1;
    private String file2;
    private List<String> listaWyrazow = new ArrayList<>();

    public static void main(String[] args) {

        Solution solution = new Solution();

        //Pierwszy parametr metody main to file1, a drugi to file2.
        solution.file1 = args[0];
        solution.file2 = args[1];

        String odczytanaZawartosc = solution.odczytajZawatroscPierwszegoPliku();
        solution.dodajWyrazyDoListy(odczytanaZawartosc);
        solution.wyrzucWyrazyKrotszeNiz6Znakow();

        solution.zapiszFile2ZUaktualnionymiWyrazami();
    }


    private String odczytajZawatroscPierwszegoPliku(){

        //2. Program musi odczytywać zawartość pierwszego pliku (użyj konstruktora z parametrem String).
        StringBuilder stringBuilder = new StringBuilder();
        try{
            BufferedReader bufferedReaderFromFile = new BufferedReader(new FileReader(file1));
            int znak;
            while ((znak = bufferedReaderFromFile.read()) != -1){
                stringBuilder.append((char) znak);
            }

            //3. Strumień wejściowy pliku (FileReader) musi zostać zamknięty.
            bufferedReaderFromFile.close();
        } catch(IOException e) {}

        return stringBuilder.toString();
    }


    private void dodajWyrazyDoListy(String odczytanaZawartosc){
        String[] wyrazyZeStringu = odczytanaZawartosc.split("\\s+");
        for(int i = 0; i < wyrazyZeStringu.length; i++){
            listaWyrazow.add(wyrazyZeStringu[i]);
        }
    }


    private void wyrzucWyrazyKrotszeNiz6Znakow(){
        Iterator<String> iterator = listaWyrazow.iterator();
        while (iterator.hasNext()){
            String wyrazIteratora = iterator.next();
            if (wyrazIteratora.length() <= 6) iterator.remove();
        }
    }

    private void zapiszFile2ZUaktualnionymiWyrazami(){
        //4. Program powinien zapisywać do drugiego pliku wszystkie słowa z pierwszego pliku o długości większej niż 6 znaków,
        // oddzielone przecinkami (użyj FileWriter).
        try{
            BufferedWriter bufferedWriterToFile = new BufferedWriter(new FileWriter(file2));
            StringBuilder zlozonyStringDoZapisu = new StringBuilder();
            for (int i = 0; i < listaWyrazow.size(); i++){
                if (i < listaWyrazow.size() -1 ) zlozonyStringDoZapisu.append(listaWyrazow.get(i) + ",");
                else zlozonyStringDoZapisu.append(listaWyrazow.get(i));
            }
            bufferedWriterToFile.write(zlozonyStringDoZapisu.toString());

            //5. Strumień wyjściowy pliku (FileWriter) musi zostać zamknięty.
            bufferedWriterToFile.close();
        } catch (IOException e){}


    }


}
