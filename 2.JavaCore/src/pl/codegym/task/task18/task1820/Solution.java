package pl.codegym.task.task18.task1820;

/* 
Zaokrąglanie liczb
*/

/*
pliki:
c:\!!programowanie\cwiczenia_pliki\file1_5.txt
c:\!!programowanie\cwiczenia_pliki\file2_5.txt
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        File plik1 = null;
        File plik2 = null;
        List<String> linieZPliku = new ArrayList<String>();
        List<Double> listaDoublePlik1 = new ArrayList<Double>();
        List<Long> listaZaokraglonychLiczb = new ArrayList<Long>();


        //1. Program powinien dwukrotnie odczytywać nazwę pliku z konsoli.
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            plik1 = new File(br.readLine());
            plik2 = new File(br.readLine());
            br.close();
        } catch (Exception e){}

        //2. Utwórz strumień wejściowy dla pierwszego pliku. Utwórz strumień wyjściowy dla drugiego pliku.
        //3. Odczytaj liczby z pierwszego pliku, zaokrąglij je i zapisz do drugiego pliku, oddzielając je spacjami.
        try{
            BufferedReader bis1 = new BufferedReader(new FileReader(plik1));
            BufferedWriter bos2 = new BufferedWriter(new FileWriter(plik2));

            //zapisuje linie do ArrayList<String>
            String linia;
            while ((linia = bis1.readLine()) != null){
                linieZPliku.add(linia);
            }

            // rozdziela po spacji
            for (String liniaPoszczegolna : linieZPliku){
                String[] splittedString = liniaPoszczegolna.split("\\s+");

                for (String splitedElement : splittedString){
                    listaDoublePlik1.add(Double.parseDouble(splitedElement));
                }

            }

            //Zaokrąglij liczby do liczb całkowitych
            for (Double pojedynczyDouble : listaDoublePlik1){
                listaZaokraglonychLiczb.add(Math.round(pojedynczyDouble));
            }

            //zapisz je, oddzielone spacjami, do drugiego pliku.
            for (Long pojedynczyLong : listaZaokraglonychLiczb){
                bos2.write(pojedynczyLong.toString() + " ");
            }



        //5. Strumienie pliku muszą zostać zamknięte.
            bis1.close();
            bos2.close();
        } catch (Exception e){}



    }
}
