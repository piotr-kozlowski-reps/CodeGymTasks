package pl.codegym.task.task18.task1802;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Minimalna liczba bajtów
*/

public class Solution {
    public static void main(String[] args) throws Exception {


        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String plikNazwaString = bf.readLine();
        bf.close();

        File plikNazwaFile = new File(plikNazwaString);

        FileInputStream fst = new FileInputStream(plikNazwaFile);
        long minLiczbaBajtow = (long) fst.read();
        while (fst.available() > 0){
            long aktualnaLiczbaBajtu = (long) fst.read();
            if (aktualnaLiczbaBajtu < minLiczbaBajtow){
                minLiczbaBajtow = aktualnaLiczbaBajtu;
            }
        }

        fst.close();
        System.out.println(minLiczbaBajtow);

    }
}
