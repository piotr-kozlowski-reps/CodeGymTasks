package pl.codegym.task.task19.task1927;

/* 
Reklama kontekstowa
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static TestString testString = new TestString();

    public static void main(String[] args) {

        PrintStream printStreamInConsole = System.out;

        //5. Metoda main(String[] args) klasy Solution musi tworzyć obiekt PrintStream (użyj konstruktora PrintStream z parametrem ByteArrayOutputStream).
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStreamToByteArrayOutputStream = new PrintStream(byteArrayOutputStream);

        System.setOut(printStreamToByteArrayOutputStream);

        //7. Metoda main(String[] args) klasy Solution musi wywoływać metodę printSomething() testString.
        testString.printSomething();

        //8. Metoda main(String[] args) klasy Solution musi modyfikować i wyświetlać linie wyjściowe metodą printSomething()
        // (poprzez dodanie reklam kontekstowych), zgodnie z warunkami zadania.
        String pierwotnyText = byteArrayOutputStream.toString();
        String rezultat = "";
        String[] podzialPoNowejLinii = pierwotnyText.split("\n");
        for (int i = 0; i < podzialPoNowejLinii.length; i++){
            if (i == 0){
                rezultat += podzialPoNowejLinii[i] + "\n";
                continue;
            }
            if(i % 2 == 0) {
                rezultat += podzialPoNowejLinii[i] + "\n";
            } else {
                rezultat += podzialPoNowejLinii[i] + "\n"
                + "CodeGym - kursy Java online" +  "\n";
            }
        }


        // wyswietlam Wynik w konsoli
        System.setOut(printStreamInConsole);

        System.out.print(rezultat);

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("pierwszy");
            System.out.println("drugi");
            System.out.println("trzeci");
            System.out.println("czwarty");
            System.out.println("piąty");
        }
    }
}
