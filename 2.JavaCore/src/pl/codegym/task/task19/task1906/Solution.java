package pl.codegym.task.task19.task1906;

/* 
Znaki parzyste
*/

/*
pliki:
c:\!!programowanie\cwiczenia_pliki\pliki11\plik11source.txt
c:\!!programowanie\cwiczenia_pliki\pliki11\plik11destination.txt
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


        //3. Program musi odczytywać zawartość pierwszego pliku (użyj konstruktora z parametrem String).
        StringBuilder wczytaneZnakiZPliku = new StringBuilder();
        try{
            FileReader fileReader = new FileReader(fileSource);

            // Wyprowadź do drugiego pliku wszystkie znaki z pierwszego pliku o liczbie porządkowej parzystej (liczby porządkowe rozpoczynają się od 1).
            while (fileReader.ready()){
                wczytaneZnakiZPliku.append((char)fileReader.read());
            }

            //4. Strumień wejściowy pliku (FileReader) musi zostać zamknięty.
            fileReader.close();
        } catch (IOException e) {}

        //5. Program musi zapisać do drugiego pliku wszystkie bajty z pierwszego pliku z parzystą liczbą porządkową (użyj FileWriter).
        try{
            //Przykładowy pierwszy plik:
            //text in file
            //Wynik w drugim pliku:
            //eti ie
            FileWriter fileWriter = new FileWriter(fileDestination);
            for (int i = 0; i < wczytaneZnakiZPliku.length(); i++){
                if ((i + 1) % 2 == 0){
                    fileWriter.write((int) wczytaneZnakiZPliku.charAt(i));
                }
            }

            //6. Strumień wyjściowy pliku (FileWriter) musi zostać zamknięt
            fileWriter.close();
        } catch (IOException e){}
    }
}
