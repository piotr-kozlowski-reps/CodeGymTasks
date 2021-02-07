package pl.codegym.task.task18.task1823;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* 
Wątki i bajty
*/

/*
pliki:
c:\!!programowanie\cwiczenia_pliki\file1_6.txt
c:\!!programowanie\cwiczenia_pliki\file2_2.txt
c:\!!programowanie\cwiczenia_pliki\file2_3.txt
exit
*/

public class Solution {

    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) {

        //Odczytuj nazwy plików z konsoli do momentu wprowadzenia słowa "exit".
        try{
            String nazwaPliku;      // nazwa pliku zczytana z konsoli
            BufferedReader bufferedReaderFromConsole = new BufferedReader(new InputStreamReader(System.in));
            while(!(nazwaPliku = bufferedReaderFromConsole.readLine()).equals("exit")){

                //Przekaż nazwę pliku do ReadThread thread.
                ReadThread thread = new ReadThread(nazwaPliku);
                thread.start();
            }

            // zamykam strumień bufferedReaderFromConsole
            bufferedReaderFromConsole.close();
        } catch (Exception e){}

    }


    public static class ReadThread extends Thread {
        String fileNameInThread;          // nazwa pliku
        List<Integer> wczytaneBajtyZPliku = new ArrayList<Integer>();           // ArrayList z wczytanym kompletem bajtów z pliku
        Map<Integer, Integer> mapaUnikalnychBajtow = new HashMap<Integer, Integer>();           // HashMap z kompletem unikalnych bajtów i ich ilością w pliku

        // Dla każdego pliku należy utworzyć i uruchomić ReadThread thread.
        public ReadThread(String fileName) {
            this.fileNameInThread = fileName;
        }


        public void run(){

            //ReadThread thread powinien odnajdywać bajt, który występuje w pliku najczęściej i dodawać go do resultMap,
            //gdzie parametr String jest nazwą pliku, a parametr Integer jest odpowiednim bajtem.
            // Następnie każdy z wątków musi odnajdywać w swoim pliku najczęściej występujący bajt i dodawać go do resultMap.

            try{
                //Strumien wejsciowy pliku
                BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(fileNameInThread));

                // wczytuje wszytskie bajty do ArrayList
                while (bufferedInputStream.available() > 0){
                    wczytaneBajtyZPliku.add(bufferedInputStream.read());
                }

                // wczytuje bajty jako klucze do HashMap -> mapaUnikalnychBajtow
                for (Integer pojedynczyBajt : wczytaneBajtyZPliku){
                    mapaUnikalnychBajtow.put(pojedynczyBajt, 0);
                }

                //zliczam ilość powtorzeń bajtów
                for (Integer bajtZArrayList : wczytaneBajtyZPliku){
                    for (Map.Entry<Integer, Integer> paraKluczWartosc : mapaUnikalnychBajtow.entrySet()){

                        if (paraKluczWartosc.getKey().equals(bajtZArrayList)){
                            paraKluczWartosc.setValue(paraKluczWartosc.getValue() + 1);
                        }

                    }
                }


                // szukam najwiekszej wartości powtorzen bajtu
                Integer kluczBajtuWystepujacegoNajczesciej = 0;
                int najwiekszaIloscPowtorzen = 0;
                for (Map.Entry<Integer, Integer> paraKluczWartosc : mapaUnikalnychBajtow.entrySet()){
                    int iloscPowtorzenBajtu = paraKluczWartosc.getValue();

                    if (najwiekszaIloscPowtorzen < iloscPowtorzenBajtu){
                        najwiekszaIloscPowtorzen = iloscPowtorzenBajtu;
                    }

                }
                // określam klucz ->  bajtu, ktory występuje najczęściej
                for (Map.Entry<Integer, Integer> paraKluczWartosc : mapaUnikalnychBajtow.entrySet()){

                    if (paraKluczWartosc.getValue() == najwiekszaIloscPowtorzen){
                        kluczBajtuWystepujacegoNajczesciej = paraKluczWartosc.getKey();
                        break;
                    }

                }

                // dodaje rezultat do ResultMap
                synchronized (resultMap){
                    resultMap.put(fileNameInThread, kluczBajtuWystepujacegoNajczesciej);
                }


                //Strumień wejściowy pliku w każdym z wątków musi zostać zamknięty.
                bufferedInputStream.close();

            } catch (Exception e){}

        }
    }
}
