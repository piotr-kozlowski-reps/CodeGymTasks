package pl.codegym.task.task18.task1803;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* 
Najczęściej występujące bajty
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        // listy i mapa: cala / odsiana / mapa odsianych
        List<Integer> listaBajtow = new ArrayList<Integer>();
        List<Integer> listaBajtowBezDuplikatow = new ArrayList<Integer>();
        Map<Integer, Integer> mapaBajtow = new HashMap<Integer, Integer>();

        //wczytuje nazwe pliku
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String plikString = br.readLine();
        br.close();

        // wczytuje bajty z pliku i dodaje do listy
        File plikFile = new File(plikString);
        FileInputStream fis = new FileInputStream(plikFile);
        while (fis.available() > 0){
            int aktualnyBajt = (int) fis.read();
            listaBajtow.add(aktualnyBajt);
        }
        fis.close();

        // dodaje unikatowe bajty do listy bez duplikatow
        for (int bajtZListy : listaBajtow){
            if (!listaBajtowBezDuplikatow.contains(bajtZListy)){
                listaBajtowBezDuplikatow.add(bajtZListy);
            }
        }

        // wypelniam HashMap
        for (int bajtZlListy : listaBajtowBezDuplikatow){
            mapaBajtow.put(bajtZlListy, 0);
        }


        // zliczam ilosc bajtow i dodaje wartosi do mapy
        for (int bajtyZListy : listaBajtow){

            for(Map.Entry<Integer, Integer> wpisMapy : mapaBajtow.entrySet()){
                int aktualnyKlucz = wpisMapy.getKey();
                int aktualnaWartosc = wpisMapy.getValue();

                if (aktualnyKlucz == bajtyZListy){
                    wpisMapy.setValue(aktualnaWartosc + 1);
                }
            }

        }

        //sprawdzam ktora wartosc jest najwieksza
        int wartoscNajwiekszaTakichSamychBajtow = 0;
        for(Map.Entry<Integer, Integer> wpisMapy : mapaBajtow.entrySet()){
            int aktualnaWartosc = wpisMapy.getValue();

            if (aktualnaWartosc > wartoscNajwiekszaTakichSamychBajtow){
                wartoscNajwiekszaTakichSamychBajtow = aktualnaWartosc;
            }
        }

        //wyswietlam bajty ktorych jest najwiecej
        for(Map.Entry<Integer, Integer> wpisMapy : mapaBajtow.entrySet()){
            int aktualnyKlucz = wpisMapy.getKey();
            int aktualnaWartosc = wpisMapy.getValue();

            if (aktualnaWartosc == wartoscNajwiekszaTakichSamychBajtow){
                System.out.print(aktualnyKlucz + " ");
            }
        }

    }
}
