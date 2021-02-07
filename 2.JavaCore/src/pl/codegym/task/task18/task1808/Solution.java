package pl.codegym.task.task18.task1808;

/* 
Dzielenie pliku
*/

import javax.imageio.IIOException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


/*
file1, file2, file3:
c:\!!programowanie\cwiczenia_pliki\file1_2.txt
c:\!!programowanie\cwiczenia_pliki\file2_2.txt
c:\!!programowanie\cwiczenia_pliki\file3_2.txt
*/


public class Solution {
    public static void main(String[] args) {

        List<Integer> listaBajtow = new ArrayList<Integer>();
        File file1 = null;
        File file2 = null;
        File file3 = null;


        // wczytanie 3 nazw plików z konsoli
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            file1 = new File(br.readLine());
            file2 = new File(br.readLine());
            file3 = new File(br.readLine());
            br.close();
        } catch (IOException e){
            e.printStackTrace();
        }

        // wczytanie bajtow do ArrayList
        try{
            FileInputStream fis = new FileInputStream(file1);
            while (fis.available() > 0){
                listaBajtow.add(fis.read());
            }
            fis.close();

        } catch (IOException e){
            e.printStackTrace();
        }

        // ile bajtow w ArrayList? i czy parzysta liczba
        int ileBajtowWArrayList = listaBajtow.size();

        boolean czyParzystaLiczbaBajtow = false;
        if ((ileBajtowWArrayList % 2) == 0){
            czyParzystaLiczbaBajtow = true;
        }

        // zapisuję do plików
        int polowka = ileBajtowWArrayList / 2;

        try{
            FileOutputStream fosFile2 = new FileOutputStream(file2);
            FileOutputStream fosFile3 = new FileOutputStream(file3);

            if(czyParzystaLiczbaBajtow){
                for (int i = 0; i < polowka; i++){
                    fosFile2.write(listaBajtow.get(i));
                }
                for (int i = polowka; i < ileBajtowWArrayList; i++){
                    fosFile3.write(listaBajtow.get(i));
                }
            } else {
                for (int i = 0; i <= polowka; i++){
                    fosFile2.write(listaBajtow.get(i));
                }
                for (int i = polowka + 1; i < ileBajtowWArrayList; i++){
                    fosFile3.write(listaBajtow.get(i));
                }
            }

            fosFile2.close();
            fosFile3.close();

        }catch (IOException e){
            e.printStackTrace();
        }






    }
}
