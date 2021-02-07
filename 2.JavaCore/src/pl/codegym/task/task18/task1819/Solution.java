package pl.codegym.task.task18.task1819;

/* 
Łączenie plików
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
pliki:
c:\!!programowanie\cwiczenia_pliki\file1_4.txt
c:\!!programowanie\cwiczenia_pliki\file2_4.txt
*/


public class Solution {
    public static void main(String[] args) {
        File file1 = null;
        File file2 = null;
        List<Integer> pierwszyPlikInts = new ArrayList<Integer>();

        //Program powinien dwukrotnie odczytywać nazwę pliku z konsoli
        try{
            BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
            file1 = new File(rd.readLine());
            file2 = new File(rd.readLine());
            rd.close();
        } catch (Exception e){}


        try{
            //2. Utwórz strumień wejściowy dla pierwszego pliku i odczytaj jego zawartość.
            BufferedInputStream bufferedInputStreamPlik1 = new BufferedInputStream(new FileInputStream(file1));
            int bytePliku;
            while((bytePliku = bufferedInputStreamPlik1.read()) != -1 ){
                pierwszyPlikInts.add(bytePliku);
            }

            // Następnie utwórz strumień wyjściowy dla pierwszego pliku. I strumień wejściowy dla drugiego pliku.
            BufferedOutputStream bufferedOutputStreamPlik1 = new BufferedOutputStream(new FileOutputStream(file1));
            BufferedInputStream bufferedInputStreamPlik2 = new BufferedInputStream(new FileInputStream(file2));

            //4. Zawartość pierwszego i drugiego pliku musi zostać połączona w pierwszym pliku.
            //5. W pierwszej kolejności należy zapisać zawartość drugiego pliku, a po niej zawartość pierwszego pliku.
            while((bytePliku = bufferedInputStreamPlik2.read()) != -1){
                bufferedOutputStreamPlik1.write(bytePliku);
            }

            for(int byteZArrayList : pierwszyPlikInts){
                bufferedOutputStreamPlik1.write(byteZArrayList);
            }



            //6. Strumienie pliku muszą zostać zamknięte.
            bufferedInputStreamPlik1.close();
            bufferedInputStreamPlik2.close();
            bufferedOutputStreamPlik1.close();

        } catch (Exception e){}

    }
}
