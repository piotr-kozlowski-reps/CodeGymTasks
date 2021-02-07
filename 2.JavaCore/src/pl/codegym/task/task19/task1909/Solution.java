package pl.codegym.task.task19.task1909;

/* 
Zmiana znaków interpunkcyjnych
*/

/*
pliki:
c:\!!programowanie\cwiczenia_pliki\pliki14\plik14source.txt
c:\!!programowanie\cwiczenia_pliki\pliki14\plik14destination.txt
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
        try{
            BufferedReader bufferedReaderFromSourceFile = new BufferedReader(new FileReader(fileSource));
            BufferedWriter bufferedWriterToDestinationFile = new BufferedWriter(new FileWriter(fileDestination));

            int znakZPliku = 0;
            while ((znakZPliku = bufferedReaderFromSourceFile.read()) != -1){

                //Odczytaj zawartość pierwszego pliku i zmień wszystkie kropki (".") na wykrzykniki ("!").
                char znakJakoChar = (char) znakZPliku;
                if (znakJakoChar == '.') znakJakoChar = '!';

                //Następnie wyprowadź wynik do drugiego pliku. (użyj konstruktora BufferedWriter, który przyjmuje argument FileWriter).
                bufferedWriterToDestinationFile.write((int)znakJakoChar);

            }

            //4. Strumień wejściowy pliku (BufferedReader) musi zostać zamknięty.
            //6. Strumień wyjściowy pliku (BufferedWriter) musi zostać zamknięty.
            bufferedReaderFromSourceFile.close();
            bufferedWriterToDestinationFile.close();
        } catch (IOException e){}

    }
}
