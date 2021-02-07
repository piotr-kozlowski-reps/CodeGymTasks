package pl.codegym.task.task13.task1318;

import java.io.*;
import java.util.Scanner;

/* 
Wczytywanie pliku
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String sciezka = reader.readLine();

        FileInputStream inputStream = new FileInputStream(sciezka);
        BufferedReader czytaZPliku = new BufferedReader(new InputStreamReader(inputStream));
        String liniaPliku;

        while ((liniaPliku = czytaZPliku.readLine()) != null){
            System.out.println(liniaPliku);
        }
//        System.out.println();

        reader.close();
        inputStream.close();
        czytaZPliku.close();


    }
}