package pl.codegym.task.task18.task1805;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* 
Sortowanie bajtów
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        // lista bajtow
        List<Integer> listaBajtow = new ArrayList<Integer>();
        List<Integer> listaBajtowOdsiana = new ArrayList<Integer>();

        //wczytuję nazwę pliku z konsoli
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String plikString = rd.readLine();
        rd.close();


        File plikNazwa = new File(plikString);
        FileInputStream fis = new FileInputStream(plikNazwa);
        while (fis.available() > 0){
            int aktualnyBajt = (int) fis.read();
            listaBajtow.add(aktualnyBajt);
        }
        fis.close();

        for (int intZListy : listaBajtow){
            if (!listaBajtowOdsiana.contains(intZListy)){
                listaBajtowOdsiana.add(intZListy);
            }
        }

        Collections.sort(listaBajtowOdsiana);

        for (int intZListyOdsianej : listaBajtowOdsiana){
            System.out.print(intZListyOdsianej + " ");
        }


    }
}
