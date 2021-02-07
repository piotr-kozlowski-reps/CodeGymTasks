package pl.codegym.task.task18.task1810;

/* 
DownloadException
*/

/*
files (mniej niz 1000):
c:\!!programowanie\cwiczenia_pliki\file1_2.txt

files (wiecej niz 1000):
c:\!!programowanie\cwiczenia_pliki\file_ponadtysiac.txt

*/


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws DownloadException, Exception {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String plik;

        while (true) {
            plik = rd.readLine();
            FileInputStream isr = new FileInputStream(plik);
            if (isr.available() >= 1000) {
                isr.read();
/*            rd.close();
              isr.close();
              throw new DownloadException();*/
            } else {
                isr.close();
                throw new DownloadException();
            }
        }
//        rd.close();
//        throw new DownloadException();

    }

    public static class DownloadException extends Exception {

    }
}
