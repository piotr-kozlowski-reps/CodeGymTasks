package pl.codegym.task.task19.task1911;

/* 
Reader wrapper
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {

    //2. Klasa Solution musi mieć publiczne statyczne pole testString o nazwie TestString, które jest natychmiastowo inicjalizowane.
    public static TestString testString = new TestString();

    public static void main(String[] args) {

        //5. Metoda main(String[] args) klasy Solution musi tworzyć obiekt PrintStream (użyj konstruktora PrintStream z parametrem ByteArrayOutputStream).
        PrintStream streamKonsola = System.out;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream streamByteArrayOutputStream = new PrintStream(byteArrayOutputStream);

        //6. Metoda main(String[] args) klasy Solution powinna zastępować strumień wyjściowy konsoli (System.out)
        System.setOut(streamByteArrayOutputStream);

        //7. Metoda main(String[] args) klasy Solution musi wywoływać metodę printSomething() testString.
        testString.printSomething();

        //8. Metoda main(String[] args) klasy Solution musi modyfikować linię wydrukowaną za pomocą metody printSomething(), zgodnie z warunkami zadania i wyprowadzać ją do konsoli.
        String result = byteArrayOutputStream.toString().toUpperCase();

        //a następnie przywracać strumień wyjściowy konsoli (System.out).
        System.setOut(streamKonsola);

        // rezultat do konsoli
        System.out.println(result);
    }

    public static class TestString {
        //3. Klasa TestString musi posiadać publiczną metodę printSomething() typu void.
        //4. Metoda printSomething() klasy TestString musi wyświetlać "To jest tekst na potrzeby testów".
        public void printSomething() {
            System.out.println("To jest tekst na potrzeby testów");
        }
    }
}
