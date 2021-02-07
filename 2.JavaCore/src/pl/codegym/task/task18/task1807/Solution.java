package pl.codegym.task.task18.task1807;

/* 
Liczenie przecinków
*/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;


// plik: c:\!!programowanie\cwiczenia_pliki\przecinki.txt

public class Solution {
    public static void main(String[] args) throws Exception{

        int ilePrzecinkow = 0;

        // wczytuję nazwę pliku z konsoli
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        File nazwaPLiku = new File(br.readLine());
        br.close();

        // odczytuję plik i zliczam przecinki (ASCI przecinka 108)
        FileInputStream fis = new FileInputStream(nazwaPLiku);
        while (fis.available() > 0){
            int aktualnyBajt = fis.read();
            if (aktualnyBajt == 44){
                ilePrzecinkow++;
            }
        }
        fis.close();

        System.out.println(ilePrzecinkow);



    }
}
