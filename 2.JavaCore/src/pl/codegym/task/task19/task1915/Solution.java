package pl.codegym.task.task19.task1915;

/* 
Powielanie tekstu
*/

/*
plik:
c:\!!programowanie\cwiczenia_pliki\pliki16\plik16.txt
*/


import java.io.*;

public class Solution {

    //2. Klasa Solution musi mieć publiczne statyczne pole testString o nazwie TestString, które jest natychmiastowo inicjalizowane.
    public static TestString testString = new TestString();

    public static void main(String[] args) {

        String nazwaPliku = "";

        //5. Program musi odczytywać nazwę pliku z konsoli (użyj BufferedReader).
        try{
            BufferedReader bufferedReaderFromConsole = new BufferedReader(new InputStreamReader(System.in));
            nazwaPliku = bufferedReaderFromConsole.readLine();

            //6. W metodzie main(String[] args), BufferedReader używany do odczytu danych wejściowych z konsoli musi zostać zamknięty po zakończeniu korzystania z niego.
            bufferedReaderFromConsole.close();
        } catch (IOException e){}

        //7. Metoda main(String[] args) klasy Solution musi tworzyć obiekt PrintStream (użyj konstruktora PrintStream z parametrem ByteArrayOutputStream).
        PrintStream printStreamConsole = System.out;

        //8. Metoda main(String[] args) klasy Solution powinna zastępować, a następnie przywracać strumień wyjściowy konsoli (System.out).
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStreamToByteArrayOutputStream = new PrintStream(byteArrayOutputStream);

        System.setOut(printStreamToByteArrayOutputStream);

        //Wywołaj istniejącą metodę printSomething() testString.
        testString.printSomething();

        //Twój reader wrapper musi wypisywać cały tekst zarówno do konsoli, jak i do pliku, którego nazwę odczytałeś/aś.
        String textDoWpisania = byteArrayOutputStream.toString();

        //write to file
        //10. Metoda main(String[] args) klasy Solution musi zapisywać wynik metody printSomething() zarówno do konsoli jak i do pliku (użyj FileOutputStream).
        try{
            FileOutputStream fileOutputStream = new FileOutputStream(new File(nazwaPliku));
            byte[] bajtyDoZapisania = textDoWpisania.getBytes();
            fileOutputStream.write(bajtyDoZapisania);
            fileOutputStream.close();
        } catch (IOException e){}

        //write in console
        System.setOut(printStreamConsole);
        System.out.println(textDoWpisania);

    }

    //1. Klasa Solution musi zawierać klasę TestString.
    public static class TestString {
        //3. Klasa TestString musi posiadać publiczną metodę printSomething() typu void.
        //4. Metoda printSomething() klasy TestString musi wyświetlać "To jest tekst na potrzeby testów".
        public void printSomething() {
            System.out.println("To jest tekst na potrzeby testów");
        }
    }
}

