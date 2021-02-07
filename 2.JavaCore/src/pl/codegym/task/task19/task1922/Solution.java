package pl.codegym.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Wyszukiwanie właściwych linii
*/

/*
plik:
c:\!!programowanie\cwiczenia_pliki\pliki20\pliki20.txt
*/

public class Solution {
    public static List<String> words = new ArrayList<>();

    static {
        words.add("file");
        words.add("view");
        words.add("In");
    }

    public static void main(String[] args) {

        String fileName = "";
        List<String> linieZPliku = new ArrayList<>();
        List<String> linieRezultat = new ArrayList<>();

        //3. Program musi odczytywać nazwę pliku z konsoli (użyj BufferedReader).
        try{
            BufferedReader bufferedReaderFromConsole = new BufferedReader(new InputStreamReader(System.in));
            fileName = bufferedReaderFromConsole.readLine();

            //4. BufferedReader używany do odczytu danych wejściowych z konsoli musi zostać zamknięty po jego zastosowaniu.
            bufferedReaderFromConsole.close();
        } catch (IOException e){}

        //5. Program musi odczytywać zawartość pliku (użyj konstruktora FileReader).
        try{
            BufferedReader bufferedReaderFromFile = new BufferedReader(new FileReader(fileName));
            String pojedynczaLinia;
            while ((pojedynczaLinia = bufferedReaderFromFile.readLine()) != null){
                linieZPliku.add(pojedynczaLinia);
            }

            //6. Strumień wejściowy pliku (FileReader) musi zostać zamknięty.
            bufferedReaderFromFile.close();
        } catch (IOException e){}

        //7. Program powinien wyświetlać wszystkie linie pliku, które zawierają tylko 2 słowa na liście words.
        //words zawiera słowa A, B i C
        //
        //Linie:
        //C B A D // 3 słowa z words, odrzucone
        //A B A D // 3 słowa z words, odrzucone
        //D A D // 1 słowa z words, odrzucone
        //D A B D // 2 słowa z words, zaakceptowane, wyświetl to
        //D A A D // 2 słowa z words, zaakceptowane, wyświetl to
        for (String liniaZArrayList : linieZPliku){
            int ileRazySlowaSiePojawily = 0;
            String[] podzialNaSlowa = liniaZArrayList.split("\\s+");

            for (int i = 0; i < podzialNaSlowa.length; i++){
                for (int j = 0; j < words.size(); j++){
                    if (podzialNaSlowa[i].equals(words.get(j))) ileRazySlowaSiePojawily++;
                }
            }

            if (ileRazySlowaSiePojawily == 2) linieRezultat.add(liniaZArrayList);

        }

        for (String linia : linieRezultat){
            System.out.println(linia);
        }





    }
}
