package pl.codegym.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/* 
John Johnson
*/

/*
plik w argumencie
c:\!!programowanie\cwiczenia_pliki\pliki19\pliki19.txt
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<>();

    public static void main(String[] args) {

        List<String> readLinesFromFile = new ArrayList<>();

        //3. Program musi odczytywać zawartość pliku (użyj konstruktora FileReader).
        try{
            BufferedReader bufferedReaderFromFile = new BufferedReader(new FileReader(args[0]));
            String liniaZPliku;
            while ((liniaZPliku = bufferedReaderFromFile.readLine()) != null){
                readLinesFromFile.add(liniaZPliku);
            }

            //4. Strumień wejściowy pliku (FileReader) musi zostać zamknięty.
            bufferedReaderFromFile.close();
        } catch (IOException e){}

        //Każdy wiersz określonego pliku ma następujący format:
        //name month day year
        //gdzie [name] to String, który może zawierać kilka słów oddzielonych spacjami.
        //[month] to int, [day] to int i [year] to int.


        for (String liniaZArrayList : readLinesFromFile){

            String name = "";
            int month;
            int day;
            int year;

            String[] splittedString = liniaZArrayList.split("\\s+");

            int howManyPartsOfName = splittedString.length - 3;

            //name
            for (int i = 0; i < howManyPartsOfName; i++){
                if (name.isEmpty()) name += splittedString[i];
                else name += " " + splittedString[i];
            }

            month = Integer.parseInt(splittedString[splittedString.length - 3]);
            day = Integer.parseInt(splittedString[splittedString.length - 2]);
            year = Integer.parseInt(splittedString[splittedString.length - 1]);

            Date data = new Date();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(data);

            calendar.set(Calendar.MONTH, month - 1);
            calendar.set(Calendar.DAY_OF_MONTH, day);
            calendar.set(Calendar.YEAR, year);

            data = calendar.getTime();

            //5. Program musi wypełniać listę PEOPLE danymi z pliku.
            //6. Program powinien prawidłowo obsługiwać nazwy z łącznikami, takie jak Mary-Jo.
            PEOPLE.add(new Person(name, data));

            System.out.println(PEOPLE);

        }
    }
}
