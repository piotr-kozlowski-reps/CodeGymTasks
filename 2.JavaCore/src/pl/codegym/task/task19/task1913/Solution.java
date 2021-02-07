package pl.codegym.task.task19.task1913;

/* 
Wyświetlaj tylko cyfry
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();         //2. Klasa Solution musi mieć publiczne statyczne pole testString o nazwie TestString, które jest natychmiastowo inicjalizowane.

    public static void main(String[] args) {

        PrintStream printStreamConsole = System.out;

        //5. Metoda main(String[] args) klasy Solution musi tworzyć obiekt PrintStream (użyj konstruktora PrintStream z parametrem ByteArrayOutputStream).
        ByteArrayOutputStream outputStreamChangedToByteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStreamByteArrayOutputStream = new PrintStream(outputStreamChangedToByteArrayOutputStream);

        //6. Metoda main(String[] args) klasy Solution powinna zastępować,
        System.setOut(printStreamByteArrayOutputStream);

        //7. Metoda main(String[] args) klasy Solution musi wywoływać metodę printSomething() testString.
        testString.printSomething();

        //8. Metoda main(String[] args) klasy Solution musi modyfikować linię wydrukowaną za pomocą metody printSomething(),
        // zgodnie z warunkami zadania i wyprowadzać ją do konsoli.
        String stringDoZmiany = outputStreamChangedToByteArrayOutputStream.toString();
        String rezultat = stringDoZmiany.replaceAll("[^0-9]", "");

        // a następnie przywracać strumień wyjściowy konsoli (System.out).
        System.setOut(printStreamConsole);

        System.out.println(rezultat);

    }

    //1. Klasa Solution musi zawierać klasę TestString.
    //3. Klasa TestString musi posiadać publiczną metodę printSomething() typu void.
    public static class TestString {
        public void printSomething() {
            System.out.println("This 1 text 23 is 4 f5-6or7 tes8ting");     //4. Metoda printSomething() klasy TestString musi wyświetlać "This 1 text 23 is 4 f5-6or7 tes8ting".
        }
    }
}
