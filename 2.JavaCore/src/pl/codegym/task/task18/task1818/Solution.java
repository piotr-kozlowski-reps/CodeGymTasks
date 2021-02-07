package pl.codegym.task.task18.task1818;

/* 
Dwa w jednym
*/

/*
pliki:
c:\!!programowanie\cwiczenia_pliki\file1_3.txt
c:\!!programowanie\cwiczenia_pliki\file2_3.txt
c:\!!programowanie\cwiczenia_pliki\file3_3.txt
*/


import java.io.*;

public class Solution {
    public static void main(String[] args) {
        File plik1 = null;
        File plik2 = null;
        File plik3 = null;



        // odczytuje z konsoli 3 pliki
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            plik1 = new File(br.readLine());
            plik2 = new File(br.readLine());
            plik3 = new File(br.readLine());
            br.close();
        }
        catch (Exception e){}



        //strumienie i kopiowanie
        try{
            FileOutputStream fos = new FileOutputStream(plik1);                             //nadpisywanie pliku
            BufferedOutputStream bwPlik1 = new BufferedOutputStream(fos);

            FileOutputStream fosAppend = new FileOutputStream(plik1, true);          //append - dodawanie pliku
            BufferedOutputStream bosAppend = new BufferedOutputStream(fosAppend);


            FileInputStream fisPlik2 = new FileInputStream(plik2);
            BufferedInputStream bisPlik2 = new BufferedInputStream(fisPlik2);

            FileInputStream fisPlik3 = new FileInputStream(plik3);
            BufferedInputStream bisPlik3 = new BufferedInputStream(fisPlik3);

            //kopiuje 2gi plik do pierwszego
            int byteZPliku;
            while((byteZPliku = bisPlik2.read()) != -1){
                bwPlik1.write(byteZPliku);
            }

            //dodaję 3gi plik do pierwszego
            while((byteZPliku = bisPlik3.read()) != -1){
                bosAppend.write(byteZPliku);
            }


            bwPlik1.close();
            bosAppend.close();
            bisPlik2.close();
            bisPlik3.close();
        }
        catch (Exception e){}



    }
}
