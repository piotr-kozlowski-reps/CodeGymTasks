package pl.codegym.task.task19.task1914;

/* 
Rozwiązywanie problemów
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    //2. Klasa Solution musi mieć publiczne statyczne pole testString o nazwie TestString, które jest natychmiastowo inicjalizowane.
    public static TestString testString = new TestString();

    public static void main(String[] args) {

        PrintStream printStreamConsole = System.out;

        //5. Metoda main(String[] args) klasy Solution musi tworzyć obiekt PrintStream (użyj konstruktora PrintStream z parametrem ByteArrayOutputStream).
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStreamToByteArraOutputStream = new PrintStream(byteArrayOutputStream);

        //6. Metoda main(String[] args) klasy Solution powinna zastępować, a następnie przywracać strumień wyjściowy konsoli (System.out).
        System.setOut(printStreamToByteArraOutputStream);

        //7. Metoda main(String[] args) klasy Solution musi wywoływać metodę printSomething() testString.
        testString.printSomething();

        //8. Metoda main(String[] args) klasy Solution musi modyfikować linię wydrukowaną za pomocą metody printSomething(),
        // zgodnie z warunkami zadania i wyprowadzać ją do konsoli.
        //Liczby ujemne, ułamki i działania jednoargumentowe (takie jak silnie i pierwiastki kwadratowe) nie są dozwolone.
        List<String> rozbityText = new ArrayList<String>();
        String textToReorganize = byteArrayOutputStream.toString();
        int pierwszaCyfra;
        String jakieDzialanie;
        int drugaCyfra;
        int wynik = 0;

        StringTokenizer tokens = new StringTokenizer(textToReorganize, " ");
        while (tokens.hasMoreTokens()){
            rozbityText.add(tokens.nextToken());
        }

        pierwszaCyfra = Integer.parseInt(rozbityText.get(0));
        jakieDzialanie = rozbityText.get(1);
        drugaCyfra = Integer.parseInt(rozbityText.get(2));

        if (jakieDzialanie.equals("+")) wynik = pierwszaCyfra + drugaCyfra;
        else if (jakieDzialanie.equals("-")) wynik = pierwszaCyfra - drugaCyfra;
        else if (jakieDzialanie.equals("*")) wynik = pierwszaCyfra * drugaCyfra;

        //powrót do konsoli
        System.setOut(printStreamConsole);

        //Przykładowy wynik: 3 + 6 = 9
        System.out.println(pierwszaCyfra + " " + jakieDzialanie + " " + drugaCyfra + " = " + wynik);

    }

    //1. Klasa Solution musi zawierać klasę TestString.
    //3. Klasa TestString musi posiadać publiczną metodę printSomething() typu void.
    //4. Metoda printSomething() klasy TestString musi wyświetlać ciąg "3 + 6 = ".
    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

