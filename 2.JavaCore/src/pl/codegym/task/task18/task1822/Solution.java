package pl.codegym.task.task18.task1822;

/* 
Wyszukiwanie danych wewnątrz pliku
*/

/*
nazwa pliku do testow:
c:\!!programowanie\cwiczenia_pliki\file1_6.txt
*/


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {

        File nazwaPliku = null;         // nazwa pliku z konsoli
        int idArgument = Integer.parseInt(args[0]);       // jeden argument: id (int).
        List<Integer> idProduktow = new ArrayList<Integer>();        // Lista z ID produktow
        List<String> nazwyProduktow = new ArrayList<String>();        // Lista z nazwami produktow
        List<Double> cenyProduktow = new ArrayList<Double>();        // Lista z cenami produktow
        List<Integer> ilosciProduktow = new ArrayList<Integer>();        // Lista z ilosciami produktow


        //Wczytaj nazwę pliku z konsoli.
        try{
            BufferedReader czytamZKonsoli = new BufferedReader(new InputStreamReader(System.in));
            nazwaPliku = new File(czytamZKonsoli.readLine());
            czytamZKonsoli.close();
        } catch (Exception e){}


        //Utwórz strumień wejściowy dla tego pliku.
        try{
            BufferedReader strumienWejsciowyZPliku = new BufferedReader(new FileReader(nazwaPliku));

            // wczytuje linie z pliku
            String liniaOdczytanaZPliku;
            while((liniaOdczytanaZPliku = strumienWejsciowyZPliku.readLine()) != null){

                //rozdzielam linie po spacji
                String rozdzielonaLiniaZPliku[] = liniaOdczytanaZPliku.split("\\s+");

                //rozdzielam informacje z pliku do odpowiednich list

                //listaID - index[0]
                idProduktow.add(Integer.parseInt(rozdzielonaLiniaZPliku[0]));

                //listaNazwa - index[1] do index[last - 3]
                StringBuilder laczeStringiWNazwe = new StringBuilder();
                for (int i = 1; i <= (rozdzielonaLiniaZPliku.length - 3); i++){
                    if (i != rozdzielonaLiniaZPliku.length - 3){
                        laczeStringiWNazwe.append(rozdzielonaLiniaZPliku[i] + " ");
                    } else {
                        laczeStringiWNazwe.append(rozdzielonaLiniaZPliku[i]);
                    }
                }
                nazwyProduktow.add(laczeStringiWNazwe.toString());

                //lista cen - index [last -2]
                cenyProduktow.add(Double.parseDouble(rozdzielonaLiniaZPliku[rozdzielonaLiniaZPliku.length - 2]));

                //ilości produktów - index [last -1]
                ilosciProduktow.add(Integer.parseInt(rozdzielonaLiniaZPliku[rozdzielonaLiniaZPliku.length - 1]));

            }

            //Przeszukaj plik w poszukiwaniu informacji związanych z podanym id. Wyświetl je w formacie używanym w pliku.
            //sprawdzam jaki ID jest argumentem i określam jego index w idProduktow
            int indexIdArgumentu = 0;
            for(int i = 0; i < idProduktow.size(); i++){
                if (idProduktow.get(i) == idArgument){
                    indexIdArgumentu = i;
                }
            }

            //Wyświetl je w formacie używanym w pliku.
            System.out.println(idProduktow.get(indexIdArgumentu) + " " + nazwyProduktow.get(indexIdArgumentu) + " " + cenyProduktow.get(indexIdArgumentu) + " " + ilosciProduktow.get(indexIdArgumentu));



            //Strumień wykorzystywany do odczytu pliku musi zostać zamknięty.
            strumienWejsciowyZPliku.close();

        }catch (Exception e){}










//Przeszukaj plik w poszukiwaniu informacji związanych z podanym id. Wyświetl je w formacie używanym w pliku.
//Program jest uruchamiany z jednym argumentem: id (int).
//Zamknij strumienie.
//
//Dane w pliku są oddzielone spacjami i zapisane w następującej kolejności:
//id productName price quantity
//gdzie id to int
//productName to String — może zawierać spacje
//price to double
//quantity to int
//
//Informacje dotyczące każdego produktu są zapisane w osobnej linii.
//


//3. Program powinien przeszukiwać plik i wyświetlać informacje związane z danym id przekazanym jako pierwszy argument.
//4.

    }
}
