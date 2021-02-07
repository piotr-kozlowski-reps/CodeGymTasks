package pl.codegym.task.task19.task1904;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/* 
Jeszcze jeden adapter
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner{                  //2. Klasa PersonScannerAdapter musi implementować interfejs PersonScanner.

        //3. Klasa PersonScannerAdapter musi posiadać prywatne pole Scanner o nazwie fileScanner.
        private Scanner fileScanner;

        //4. Klasa PersonScannerAdapter musi posiadać konstruktor z parametrem Scanner.
        public PersonScannerAdapter(Scanner scanner){
            this.fileScanner = scanner;
        }

        //5. Metoda close() klasy PersonScannerAdapter musi delegować wywołanie do fileScanner.
        @Override
        public void close() throws IOException {
            fileScanner.close();
        }

        @Override
        public Person read() throws IOException {
            String liniaZPliku = fileScanner.nextLine();            //Larry Thomas Gates 12 31 1957

            // podział po spacji
            String[] tokens = liniaZPliku.split("\\s+");
            String lastName = tokens[2];
            String firstName = tokens[0];
            String middleName = tokens[1];

            // data
            String dataStringFormatted = tokens[3] + " " + tokens[4] + " " + tokens[5];
            SimpleDateFormat dataFormatter = new SimpleDateFormat("MM dd yyyy");
            Date birthDate = null;
            try{
                birthDate = dataFormatter.parse(dataStringFormatted);
            } catch (ParseException e){}

            return new Person(lastName, firstName, middleName, birthDate);

        }
    }
}

//Plik zawiera informacje o wielu osobach. W każdej linii znajdują się dane dotyczące jednej osoby. Metoda read() musi odczytywać informacje dotyczące tylko jednej osoby.


//6. Metoda read() klasy PersonScannerAdapter powinna odczytywać linię z pliku, parsować ją i zwracać dane tylko jednej osoby jako obiekt Person.