package pl.codegym.task.task18.task1809;

/* 
Odwracanie pliku
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/*
file1:
file2:
c:\!!programowanie\cwiczenia_pliki\file1.txt
c:\!!programowanie\cwiczenia_pliki\file2.txt
*/


public class Solution {
    public static void main(String[] args) throws Exception{

        List<Byte> listaBajtow = new ArrayList<Byte>();

        // wczytuje z konsoli 2 pliki
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        File file1 = new File(br.readLine());
        File file2 = new File(br.readLine());
        br.close();

        // wczytuje bajty z pierwszego pliku do Listy
        FileInputStream fis = new FileInputStream(file1);
        while (fis.available() > 0){
            int aktualnyBajt = fis.read();
            listaBajtow.add((byte)aktualnyBajt);
        }
        fis.close();

        // odwracam ArrayLIst
        Collections.reverse(listaBajtow);

        // zapisuję do drugiego pliku
        FileOutputStream fos = new FileOutputStream(file2);
        for (int aktualnyBajt : listaBajtow){
            fos.write(aktualnyBajt);
        }
        fos.close();



    }
}
