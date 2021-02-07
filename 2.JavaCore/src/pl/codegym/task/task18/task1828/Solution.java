package pl.codegym.task.task18.task1828;

/* 
Ceny 2
*/

/*
argumenty:
-u 19847983 "Tryutdard jacket with reflec" 111.11 11            // update
-d 19847983                                                     // delete

plik:
c:\!!programowanie\cwiczenia_pliki\pliki10\plik10.txt
*/


import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws Exception{

        String fileName;

        //Odczytaj z konsoli nazwę pliku dla operacji CrUD
        BufferedReader bufferedReaderFromFile = new BufferedReader(new InputStreamReader(System.in));
        fileName = bufferedReaderFromFile.readLine();
        bufferedReaderFromFile.close();


        if (args.length == 0) return;           //2. W przypadku uruchamiania programu bez argumentów, lista produktów musi pozostać niezmieniona.
        else if (args[0].equals("-u") || args[0].equals("-d")){

            switch (args[0]){
                case "-u":
                    updateInFile(args, fileName);       //-u id productName price quantity

                case "-d":
                    deleteInFile(args, fileName);       //-d id
            }
        }
    }


    //3. W przypadku uruchamiania programu z argumentami "-u id productName price quantity", informacje dotyczące produktów znajdujące się w pliku powinny zostać zaktualizowane.
    public static void updateInFile(String[] argumenty, String fileName) throws Exception{
        String productID = argumenty[1];
        String productName = argumenty[2];
        String productPrice = argumenty[3];
        String productQuantity = argumenty[4];
        List<String> stringiZPliku = new ArrayList<String>();
        String stringToUpdate = "";

        // wczytuję linie z pliku do ArrayList
        BufferedReader bufferedReaderFromFile = new BufferedReader(new FileReader(fileName));
        String liniaZPliku;
        while ((liniaZPliku = bufferedReaderFromFile.readLine()) != null){
            stringiZPliku.add(liniaZPliku);
        }

        // generuję nową linię z argumentów
        stringToUpdate += productID;                                //gdzie id to 8 znaków
        for (int i = 0; i < 8 - productID.length(); i++) {
            stringToUpdate += " ";
        }

        stringToUpdate += productName;                              //productName to 30 znaków
        for (int i = 0; i < 30 - productName.length(); i++) {
            stringToUpdate += " ";
        }

        stringToUpdate += productPrice;                             //price to 8 znaków
        for (int i = 0; i < 8 - productPrice.length(); i++) {
            stringToUpdate += " ";
        }

        stringToUpdate += productQuantity;                          //quantity to 4 znaki
        for (int i = 0; i < 4 - productQuantity.length(); i++) {
            stringToUpdate += " ";
        }

        // update linii po ID w ArrayList
        // który index jest do podmiany
        int idToUpdate = Integer.parseInt(productID);
        int indexIdPasujacego = 0;
        for (int i = 0; i < stringiZPliku.size(); i++){
            int idToBeUpdated= Integer.parseInt(stringiZPliku.get(i).substring(0, 8).trim());
            if (idToBeUpdated == idToUpdate){
                indexIdPasujacego = i;
            }
        }

        // podmieniam linię w ArrayList
        stringiZPliku.set(indexIdPasujacego, stringToUpdate);

        //zapisuję plik
        BufferedWriter bufferedWriterToFile = new BufferedWriter(new FileWriter(fileName));
        for (int i = 0; i < stringiZPliku.size(); i++){
            if (i < stringiZPliku.size() - 1) {
                String liniaZArrayList = stringiZPliku.get(i);
                bufferedWriterToFile.write(liniaZArrayList + "\n");
            }
            else {
                String liniaZArrayList = stringiZPliku.get(i);
                bufferedWriterToFile.write(liniaZArrayList);
            }
        }


        //zamykam strumienie
        bufferedReaderFromFile.close();
        bufferedWriterToFile.close();



    }

    //-d fizycznie usuwa produkt o określonym id (wszystkie dane związane z przekazanym id)
    public static void deleteInFile(String[] argumenty, String fileName) throws Exception{

        String productID = argumenty[1];
        List<String> stringiZPliku = new ArrayList<String>();

        // wczytuję linie z pliku do ArrayList
        BufferedReader bufferedReaderFromFile = new BufferedReader(new FileReader(fileName));
        String liniaZPliku;
        while ((liniaZPliku = bufferedReaderFromFile.readLine()) != null){
            stringiZPliku.add(liniaZPliku);
        }

        // delete Linii po ID w ArrayList
        // który index jest do wyrzucenia
        int idToUpdate = Integer.parseInt(productID);
        int indexIdPasujacego = 0;
        for (int i = 0; i < stringiZPliku.size(); i++){
            int idToBeUpdated= Integer.parseInt(stringiZPliku.get(i).substring(0, 8).trim());
            if (idToBeUpdated == idToUpdate){
                indexIdPasujacego = i;
            }
        }

        // wyrzucam linię w ArrayList
        stringiZPliku.remove(indexIdPasujacego);


        //zapisuję plik
        BufferedWriter bufferedWriterToFile = new BufferedWriter(new FileWriter(fileName));
        for (int i = 0; i < stringiZPliku.size(); i++){
            if (i < stringiZPliku.size() - 1) {
                String liniaZArrayList = stringiZPliku.get(i);
                bufferedWriterToFile.write(liniaZArrayList + "\n");
            }
            else {
                String liniaZArrayList = stringiZPliku.get(i);
                bufferedWriterToFile.write(liniaZArrayList);
            }
        }


        //zamykam strumienie
        bufferedReaderFromFile.close();
        bufferedWriterToFile.close();


    }

}
