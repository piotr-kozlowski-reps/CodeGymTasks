package pl.codegym.task.task18.task1817;

/* 
Spacje
*/

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;

public class Solution {
    public static void main(String[] args){

        File nazwaPliku;
        FileInputStream fis = null;
        int wszystkieZnaki = 0;
        int sameSpacje = 0;
        double wynik = 0;

        // plik nazwa
        try{
            nazwaPliku = new File(args[0]);
            fis = new FileInputStream(nazwaPliku);

            // wszytskie znaki
            wszystkieZnaki = fis.available();

            // spacje
            while (fis.available() > 0){
                char aktualnyZnak = (char) fis.read();
                if (aktualnyZnak == ' ') sameSpacje++;
            }

            // stosunek spacji do wszystkich znaków w pliku
            //1. Policz wszystkie znaki (n1).
            //2. Policz spacje (n2).
            //3. Wyświetl n2/n1*100, zaokrąglając do 2 miejsc po przecinku.
            wynik = (double) (sameSpacje * 1.0) / (wszystkieZnaki * 1.0) * 100;
            DecimalFormat df = new DecimalFormat("###.##");
            System.out.println(df.format(wynik));
            fis.close();

        }
        catch (Exception f){
        }










    }
}
