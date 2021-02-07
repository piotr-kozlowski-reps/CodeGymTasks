package pl.codegym.task.task19.task1912;

/* 
Reader Wrapper 2
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {

    public static TestString testString = new TestString();

    public static void main(String[] args) {

        //5. Metoda main(String[] args) klasy Solution musi tworzyć obiekt PrintStream
        // (użyj konstruktora PrintStream z parametrem ByteArrayOutputStream).
        PrintStream streamConsola = System.out;

        //6. Metoda main(String[] args) klasy Solution powinna zastępować, a następnie przywracać strumień wyjściowy konsoli (System.out).
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream streamByteArrayOutputStream = new PrintStream(byteArrayOutputStream);
        System.setOut(streamByteArrayOutputStream);

        //7. Metoda main(String[] args) klasy Solution musi wywoływać metodę printSomething() testString.
        testString.printSomething();

        //8. Metoda main(String[] args) klasy Solution musi modyfikować linię wydrukowaną za pomocą metody printSomething(),
        // zgodnie z warunkami zadania i wyprowadzać ją do konsoli.
        //Twój reader wrapper powinien zastępować wszystkie podciągi "te" znakami "??".
        String tekstDoModyfikacji = byteArrayOutputStream.toString();
        String rezultat = tekstDoModyfikacji.replaceAll("te", "??");

        //Przywróć zmienną System.out z powrotem do oryginalnego strumienia.
        //Wyświetl zmodyfikowany ciąg.
        System.setOut(streamConsola);
        System.out.println(rezultat);

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("To jest tekst na potrzeby testów");
        }
    }
}
