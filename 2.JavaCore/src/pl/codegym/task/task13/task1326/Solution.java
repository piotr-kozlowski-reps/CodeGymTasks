package pl.codegym.task.task13.task1326;

/* 
Sortowanie liczb parzystych z pliku
*/

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String linkDoPliku = reader.readLine();

        List<Integer> listaLiczbParzystych = new ArrayList<Integer>();
        List<Integer> listaLiczbWszytskich = new ArrayList<Integer>();


        FileInputStream inputStream = new FileInputStream(linkDoPliku);
        BufferedReader czytaZPliku = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));


        while (true){
            String liniaZPliku = czytaZPliku.readLine();
            if (liniaZPliku != null){
                listaLiczbWszytskich.add(Integer.parseInt(liniaZPliku));
//                System.out.println(liniaZPliku);
            } else {
                break;
            }
        }


        for (int i = 0; i < listaLiczbWszytskich.size(); i++){
            if (listaLiczbWszytskich.get(i) % 2 == 0){
                listaLiczbParzystych.add(listaLiczbWszytskich.get(i));
            }
        }

        Collections.sort(listaLiczbParzystych);

        for (int i = 0; i < listaLiczbParzystych.size(); i++){
            System.out.println(listaLiczbParzystych.get(i));
        }


        inputStream.close();
        reader.close();
        czytaZPliku.close();

        /*

        String aktualnaLiczba = "";

        while (inputStream.available() > 0){

            char znak = (char) inputStream.read();
//            System.out.print(znak);

            if(znak != ' '){
                aktualnaLiczba = (String) aktualnaLiczba + znak;
                System.out.println(aktualnaLiczba);
            } else {
//                listaLiczbWszytskich.add(aktualnaLiczba);
//                System.out.println(aktualnaLiczba);
            }
        }

        System.out.println(inputStream);


        String liniaZPliku = czytaZPliku.readLine();
        System.out.println(liniaZPliku);

*/








/*
        while (skaner.hasNext()){
            String wczytanaLinia = skaner.nextLine();
            int liczba = Integer.parseInt(wczytanaLinia);

            if (liczba % 2 == 0){
                listaLiczb.add(liczba);
            }
        }
   */



/*
        Collections.sort(listaLiczb);


        for (int i = 0; i < listaLiczb.size(); i++){
            System.out.println(listaLiczb.get(i));
        }
*/



/*
        InputStream inputStream = new FileInputStream(linkDoPliku);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);

        while (bufferedInputStream.available() > 0){
            char liczba = (char) bufferedInputStream.read();
            System.out.println(liczba);
        }

        */


    }
}
