package pl.codegym.task.task18.task1824;

/* 
Pliki i wyjątki
*/

/*
pliki:
c:\!!programowanie\cwiczenia_pliki\file1_6.txt
c:\!!programowanie\cwiczenia_pliki\file2_2.txt
c:\!!programowanie\cwiczenia_pliki\file2_3.txt
exit
*/


import java.io.*;

public class Solution {
    public static void main(String[] args) {

        String nazwaPliku = null;      // nazwa pliku zczytana z konsoli

        // Program powinien odczytywać nazwy plików z konsoli.
        try{

            BufferedReader bufferedReaderFromConsole = new BufferedReader(new InputStreamReader(System.in));
            while((nazwaPliku = bufferedReaderFromConsole.readLine()) != null){

                //2. Dla każdego pliku należy utworzyć strumień wejściowy.
                BufferedInputStream bufferedInputStreamDlaPliku = new BufferedInputStream(new FileInputStream(nazwaPliku));

                // zamykam strumien dla pliku
                bufferedInputStreamDlaPliku.close();

            }

            // zamykam strumien z konsoli
            bufferedReaderFromConsole.close();

        } catch (FileNotFoundException fileNotFoundException){      //3. Jeśli plik nie istnieje, program musi przechwytywać FileNotFoundException.
            System.out.println(nazwaPliku);
            //zakonczenie programu - Nie używaj "System.exit();"
            return;
        } catch (IOException ioException){
            ioException.printStackTrace();
        }

    }
}
