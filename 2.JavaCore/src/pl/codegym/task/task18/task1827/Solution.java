package pl.codegym.task.task18.task1827;

/* 
Ceny
*/

/*
argumenty:
-c Tryutdard jacket with reflecti 11111.11 1111     // wszytskie znaki
-c Tryutdard jacket with reflec 111.11 11            // bez 2ch znaków wszędzie
-c "Tryutdard jacket with reflec" 111.11 11         // bez 2ch znaków wszędzie + cudzysłów

plik:
c:\!!programowanie\cwiczenia_pliki\pliki9\plik9.txt
*/


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();



        if (args.length == 0) return;
        else if (args[0].equals("-c") && args.length == 4) {

                String c = args[0];                // 8 znaków
                String productName = args[1];       // 30 znaków
                String price = args[2];             // 8 znaków
                String quantity = args[3];          // 4 znaki

                String stringToWrite = "";

                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName, true));
                reader = new BufferedReader(new FileReader(fileName));

                String line = "";
                String data = "";

                while ((line = reader.readLine()) != null) {
                    data = line;
                }

                int newID = Integer.parseInt(data.substring(0, 8)) + 1;
                String ID = Integer.toString(newID);

                stringToWrite += newID;
                for (int i = 0; i < 8 - ID.length(); i++) {
                    stringToWrite += " ";
                }

                stringToWrite += args[1];
                for (int i = 0; i < 30 - args[1].length(); i++) {
                    stringToWrite += " ";
                }

                stringToWrite += args[2];
                for (int i = 0; i < 8 - args[2].length(); i++) {
                    stringToWrite += " ";
                }

                stringToWrite += args[3];
                for (int i = 0; i < 4 - args[3].length(); i++) {
                    stringToWrite += " ";
                }

                bufferedWriter.write("\n" + stringToWrite);

                reader.close();
                bufferedWriter.close();
            }

    }
}




/*
public class Solution {
    public static void main(String[] args) throws Exception {

        File nazwaPliku = null;             // nazwę pliku dla operacji CrUD.

        //Odczytaj z konsoli nazwę pliku dla operacji CrUD.
        BufferedReader bufferedReaderFromConsole = new BufferedReader(new InputStreamReader(System.in));
        nazwaPliku = new File(bufferedReaderFromConsole.readLine());

        //Strumienie pliku muszą zostać zamknięte.
        bufferedReaderFromConsole.close();


        if (args.length == 0) return;                               // W przypadku uruchamiania programu bez argumentów, lista produktów musi pozostać niezmieniona.
        else if (args[0].equals("-c") && args.length == 4){         // W przypadku uruchamiania programu z argumentami "-c productName price quantity", na końcu pliku należy dodać nową linię z odpowiednim produktem.

            String liniaPlikuWczytana;
            String liniaPlikuOstatnia = "";
            // InputBufor i czytanie ostatniej linii
            BufferedReader bufferedReaderFromFile = new BufferedReader(new FileReader(nazwaPliku));
            while ((liniaPlikuWczytana = bufferedReaderFromFile.readLine()) != null){
                liniaPlikuOstatnia = liniaPlikuWczytana;
            }

            //id to 8 znaków.
            //productName to 30 znaków.
            //price to 8 znaków.
            //quantity to 4 znaki.

            //nowy numer ID
            int nowyID = Integer.parseInt(liniaPlikuOstatnia.substring(0, 8)) + 1;

            // bufor do zapisu pliku
            BufferedWriter bufferedWriterToFile = new BufferedWriter(new FileWriter(nazwaPliku, true));
            String nowaLinia = "";

            //nowe linia do dopisania do pliku
            nowaLinia += Integer.toString(nowyID);
            nowaLinia += addSpaces(8 - nowaLinia.length());

            nowaLinia += args[1];
            nowaLinia += addSpaces(38 - nowaLinia.length());

            nowaLinia += args[2];
            nowaLinia += addSpaces(46 - nowaLinia.length());

            nowaLinia += args[3];
            nowaLinia += addSpaces(50 - nowaLinia.length());

            // zapisuję do pliku
            bufferedWriterToFile.write("\n" + nowaLinia);





            //Strumienie pliku muszą zostać zamknięte.
            bufferedReaderFromFile.close();
            bufferedWriterToFile.close();

        }









        //moje ambitne rozwiązanie :(

/*
        File nazwaPliku = null;             // nazwę pliku dla operacji CrUD.
        List<String> idProduktow = new ArrayList<String>();           // lista z ID produktów - //gdzie id to 8 znaków.
        List<String> nazwyProduktow = new ArrayList<String>();           // lista z nazwą produktów - //productName to 30 znaków.
        List<String> cenyProduktow = new ArrayList<String>();           // lista z cenami produktów - //price to 8 znaków.
        List<String> iloscProduktow = new ArrayList<String>();           // lista z ilością produktów - //quantity to 4 znaki.




        //Odczytaj z konsoli nazwę pliku dla operacji CrUD.
        BufferedReader bufferedReaderFromConsole = new BufferedReader(new InputStreamReader(System.in));
        nazwaPliku = new File(bufferedReaderFromConsole.readLine());

        //Strumienie pliku muszą zostać zamknięte.
        bufferedReaderFromConsole.close();

        //2. Klasa Solution nie powinna używać zmiennych statycznych.
        //3. W przypadku uruchamiania programu bez argumentów, lista produktów musi pozostać niezmieniona.
        if (args.length == 0){
            return;

        //4. W przypadku uruchamiania programu z argumentami "-c productName price quantity", na końcu pliku należy dodać nową linię z odpowiednim produktem.
        } else if (args[0].equals("-c")){

            // zczytuję dane z pliku do List
            BufferedReader bufferedInputStream = new BufferedReader(new FileReader(nazwaPliku));
            String liniaPliku;
            while ((liniaPliku = bufferedInputStream.readLine()) != null){

                //id to 8 znaków.
                String idProduktuZArgumentu = liniaPliku.substring(0, 8);
                idProduktow.add(idProduktuZArgumentu);

                //productName to 30 znaków.
                String nazwaProduktuString = liniaPliku.substring(8, 38);
                nazwyProduktow.add(nazwaProduktuString);

                //price to 8 znaków.
                cenyProduktow.add(liniaPliku.substring(38, 46));

                //quantity to 4 znaki.
               iloscProduktow.add(liniaPliku.substring(46, 50));

            }


            //Program jest uruchamiany z następującymi argumentami:
            //Każde pole danych jest uzupełniane spacjami na całej długości.
            //-c productName price quantity

            //5. Produkt musi mieć kolejny numer id następujący po maksymalnej wartości id odnalezionej w pliku.
            Integer idProduktuMaxInteger = 0;                                                            // id
            for (String idProduktuString : idProduktow){
                String tymczasowyString;
                tymczasowyString = idProduktuString.trim();
                Integer tymczasowyInteger = Integer.parseInt(tymczasowyString);
                if (tymczasowyInteger > idProduktuMaxInteger){
                    idProduktuMaxInteger = tymczasowyInteger;
                }
            }
            // + 1 do największego ID jaki był w pliku
            idProduktuMaxInteger++;
            // zamiana na String, dodanie spacji i dodanie Stringu do listy
            StringBuilder idProduktuStringBuilder = new StringBuilder(Integer.toString(idProduktuMaxInteger));
            //dodaje spacje jezeli jest krotsza nazwa
            String idProduktuNowy = dodajSpacje(idProduktuStringBuilder, 8);


            String nazwaProduktuArgument;                                                                // name
            StringBuilder laczenieNazwyProduktu = new StringBuilder();
            for (int i = 1; i <= args.length - 3; i++){
                if (i < (args.length - 3)){
                    laczenieNazwyProduktu.append(args[i] + " ");
                } else {
                    laczenieNazwyProduktu.append(args[args.length - 3]);
                }
            }
            //dodaje spacje jezeli jest krotsza nazwa
            nazwaProduktuArgument = dodajSpacje(laczenieNazwyProduktu, 30);

            StringBuilder cenaProduktuStringBuilder = new StringBuilder(args[args.length - 2]);        // cena
            //dodaje spacje jezeli jest krotsza nazwa
            String cenaProduktuArgument = dodajSpacje(cenaProduktuStringBuilder, 8);

            StringBuilder iloscProduktuStringBuilder = new StringBuilder(args[args.length - 1]);       // ilosc
            //dodaje spacje jezeli jest krotsza nazwa
            String iloscProduktuArgument = dodajSpacje(iloscProduktuStringBuilder, 4);

            // dodaję argumenty do list
            idProduktow.add(idProduktuNowy);
            nazwyProduktow.add(nazwaProduktuArgument);
            cenyProduktow.add(cenaProduktuArgument);
            iloscProduktow.add(iloscProduktuArgument);


            //-c dodaje produkt o określonych parametrach na końcu pliku i generuje id poprzez zwiększenie maksymalnej wartości id odnalezionej w pliku.
            //Dane w pliku są przechowywane w następującej kolejności (bez spacji):
            //id productName price quantity
            //Przed dodaniem nowej linii, ponownie zapisz całą jej zawartość do pliku.
            //6. Format linii nowego produktu musi dokładnie odpowiadać formatowi określonemu w zadaniu.
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(nazwaPliku, true));
            bufferedWriter.write("\n" + idProduktow.get(idProduktow.size() - 1) + nazwyProduktow.get(idProduktow.size() - 1) + cenyProduktow.get(idProduktow.size() - 1) + iloscProduktow.get(idProduktow.size() - 1));

//            for (int i = 0; i < idProduktow.size(); i++ ){
//                printStream.println(idProduktow.get(i) + nazwyProduktow.get(i) + cenyProduktow.get(i) + iloscProduktow.get(i));
//            }


            //7. Strumienie pliku muszą zostać zamknięte.
            bufferedInputStream.close();
            bufferedWriter.close();


        }*/
/*
    }

    public static String dodajSpacje(String stringPrzekazany, int ileMaBycZnakow){

        for (int i = stringPrzekazany.length(); i < ileMaBycZnakow; i++){
            stringPrzekazany += " ";
        }

        return stringPrzekazany;
    }

    public static String addSpaces(int ileZnakow){
        String spacje = "";
        for (int i = 0; i < ileZnakow; i++){
            spacje += " ";
        }
        return spacje;
    }


}

*/
