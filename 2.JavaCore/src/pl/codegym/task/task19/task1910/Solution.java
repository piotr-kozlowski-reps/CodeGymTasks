package pl.codegym.task.task19.task1910;

/* 
Interpunkcja
*/

/*
pliki:
c:\!!programowanie\cwiczenia_pliki\pliki15\plik15source.txt
c:\!!programowanie\cwiczenia_pliki\pliki15\plik15destination.txt
*/


import java.io.*;

public class Solution {
    public static void main(String[] args) {

        //Wczytaj 2 nazwy plików z konsoli.
        String fileSource = "";
        String fileDestination = "";
        try{
            BufferedReader bufferedReaderConsole = new BufferedReader(new InputStreamReader(System.in));
            fileSource = bufferedReaderConsole.readLine();
            fileDestination = bufferedReaderConsole.readLine();

            //2. BufferedReader używany do odczytu danych wejściowych z konsoli musi zostać zamknięty po jego zastosowaniu.
            bufferedReaderConsole.close();
        } catch (IOException e){}

        //3. Program musi odczytywać zawartość pliku (użyj konstruktora BufferedReader z parametrem FileReader).
        StringBuilder wczytanyTextZPliku = new StringBuilder();
        try{
            BufferedReader bufferedReaderFromSourceFile = new BufferedReader(new FileReader(fileSource));
            BufferedWriter bufferedWriterToDestinationFile = new BufferedWriter(new FileWriter(fileDestination));

            int znakZPliku;
            while ((znakZPliku = bufferedReaderFromSourceFile.read()) != -1){
                wczytanyTextZPliku.append((char)znakZPliku);
            }

            // usuwam wszystkie znaki interpunkcyjne, w tym znaki nowej linii
            String textPoModyfikacjach = wczytanyTextZPliku.toString().replaceAll("\\p{Punct}", "");
            textPoModyfikacjach = textPoModyfikacjach.replaceAll("\r\n", "");

            //Następnie wyprowadź wynik do drugiego pliku.
            bufferedWriterToDestinationFile.write(textPoModyfikacjach);

            //4. Strumień wejściowy pliku (BufferedReader) musi zostać zamknięty.
            //6. Strumień wyjściowy pliku (BufferedWriter) musi zostać zamknięty.
            bufferedReaderFromSourceFile.close();
            bufferedWriterToDestinationFile.close();

        } catch (IOException e){}

    }
}
