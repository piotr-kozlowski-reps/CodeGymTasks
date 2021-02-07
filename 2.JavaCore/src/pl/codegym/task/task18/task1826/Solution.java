package pl.codegym.task.task18.task1826;

/* 
Szyfrowanie
*/

/*
argumenty:
-e c:\!!programowanie\cwiczenia_pliki\pliki8\plikDoZaszyfrowania.txt c:\!!programowanie\cwiczenia_pliki\pliki8\plikZaszyfrowany.txt
-d c:\!!programowanie\cwiczenia_pliki\pliki8\plikDoOdszyfrowania.txt c:\!!programowanie\cwiczenia_pliki\pliki8\plikOdszyfrowany.txt
*/


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Solution {
    public static void main(String[] args) throws Exception{

        //Program jest wykonywany z jednym z następujących zestawów argumentów:
        //-e fileName fileOutputName
        //-d fileName fileOutputName

        String fileName = args[1];          //fileName to nazwa pliku, który ma być szyfrowany/odszyfrowany.
        String fileOutputName = args[2];    //fileOutputName to nazwa pliku, w którym należy zapisać wynik procesu szyfrowania/odszyfrowywania.

        switch (args[0]){

            case ("-e"):        // -e oznacza, że należy zaszyfrować dane.
                zaszyfruj(fileName, fileOutputName);
                break;

            case("-d"):
                odszyfruj(fileName, fileOutputName);    // -d oznacza, że należy odszyfrować dane.
                break;
        }

    }

    public static void zaszyfruj(String fileName, String fileOutputName) throws Exception{

        //2. Utwórz strumień wejściowy dla pliku przekazanego jako drugi argument (fileName).
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(fileName));

        //3. Utwórz strumień wyjściowy dla pliku przekazanego jako trzeci argument (fileOutputName).
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(fileOutputName));

        //4. W trybie "-e" program powinien szyfrować plik fileName i zapisywać wynik do pliku fileOutputName.
        int znakInt;
        while ((znakInt = bufferedInputStream.read()) != -1){
            bufferedOutputStream.write(znakInt + 5);
        }

        //6. Strumienie pliku muszą zostać zamknięte.
        bufferedInputStream.close();
        bufferedOutputStream.close();

    }

    public static void odszyfruj(String fileName, String fileOutputName) throws Exception{

        //2. Utwórz strumień wejściowy dla pliku przekazanego jako drugi argument (fileName).
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(fileName));

        //3. Utwórz strumień wyjściowy dla pliku przekazanego jako trzeci argument (fileOutputName).
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(fileOutputName));

        //5. W trybie "-d" program powinien odszyfrowywać fileName i zapisywać wynik do pliku fileOutputName.
        int znakInt;
        while ((znakInt = bufferedInputStream.read()) != -1){
            bufferedOutputStream.write(znakInt - 5);
        }

        //6. Strumienie pliku muszą zostać zamknięte.
        bufferedInputStream.close();
        bufferedOutputStream.close();

    }

}
