package pl.codegym.task.task18.task1801;

import java.io.*;

/* 
Maksymalna liczba bajtów
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        long maxLiczbaBajtow = 0;

        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String jakiPlik = rd.readLine();
        rd.close();
        File nazwaPliku = new File(jakiPlik);

        try{
            FileInputStream fis = new FileInputStream(nazwaPliku);

            while (fis.available() > 0){
                long aktualnyBajt = (long) fis.read();
                if (aktualnyBajt > maxLiczbaBajtow){
                    maxLiczbaBajtow = aktualnyBajt;
                }
            }
            fis.close();
        } catch (IOException e){

        }

        System.out.println(maxLiczbaBajtow);

    }
}
