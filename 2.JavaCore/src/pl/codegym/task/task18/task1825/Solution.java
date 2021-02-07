package pl.codegym.task.task18.task1825;

import java.io.*;
import java.util.*;

/* 
Tworzenie pliku
*/

/*
pliki:
c:\!!programowanie\cwiczenia_pliki\pliki7\file1_2.txt.part2
c:\!!programowanie\cwiczenia_pliki\pliki7\file1_2.txt.part1
c:\!!programowanie\cwiczenia_pliki\pliki7\file1_2.txt.part4
c:\!!programowanie\cwiczenia_pliki\pliki7\file1_2.txt.part3
end
*/


public class Solution {
    public static void main(String[] args) throws Exception{

        String finalnaNazwaPliku = null;            // finalna nazwa pliku bez .partN
        List<String> nazwyWszystkichWczytanychPlikow = new ArrayList<String>();         // nazwy wszystkich poszczególnych częsci/plików


        //Odczytuj nazwy plików z konsoli.
        //Każdy plik ma swoją nazwę: <someName>.partN.
        //Na przykład, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
        //Nazwy plików są podawane w kolejności losowej. Słowo "end" jest używane do zatrzymywania odczytu nazw plików.
        try{
            String nazwaPojedynczegoPliku = null;      // nazwa pojedynczego pliku zczytana z konsoli
            BufferedReader bufferedReaderFromConsole = new BufferedReader(new InputStreamReader(System.in));
            while(!(nazwaPojedynczegoPliku = bufferedReaderFromConsole.readLine()).equals("end")){

                //dodaję nazwy plików do ArrayLIst -> nazwyWszystkichWczytanychPlikow
                nazwyWszystkichWczytanychPlikow.add(nazwaPojedynczegoPliku);

            }

            // zamykam strumien z konsoli
            bufferedReaderFromConsole.close();

        } catch (Exception e){}

        // sortuję pliki w ArrayLIst -> nazwyWszystkichWczytanychPlikow
        Collections.sort(nazwyWszystkichWczytanychPlikow);

        //W folderze, w którym znajdują się wszystkie pliki, utwórz plik bez rozszerzenia "part", tzn. bez ".<partN>".
        //Na przykład, Lion.avi.
        //
        //Użyj bufora, aby skopiować wszystkie bajty z plików częściowych do utworzonego pliku.
        //Skopiuj pierwszy w odpowiedniej kolejności, najpierw pierwszą część, potem drugą, ..., w końcu - część ostatnią.


        // robię split po .(kropce)
        String przykladowyLinkDoPliku = nazwyWszystkichWczytanychPlikow.get(0);
        String stringSplittedPoKropce[] = przykladowyLinkDoPliku.split("\\.");

        //łączę spowrotem bez końcówki .partN
        StringBuilder linkDoPlikuLaczenie = new StringBuilder();
        for (int i = 0; i < stringSplittedPoKropce.length - 1; i++){
            if(i < stringSplittedPoKropce.length - 2){
                linkDoPlikuLaczenie.append(stringSplittedPoKropce[i] + ".");
            } else{
                linkDoPlikuLaczenie.append(stringSplittedPoKropce[i]);
            }
        }
        finalnaNazwaPliku = linkDoPlikuLaczenie.toString();

        //Utwórz strumień do zapisu do pliku bez sufiksu "part" (".<partN>") w folderze z wszystkimi plikami "part".
        // Do odczytu i zapisu należy używać bufora.
        PrintStream printStreamNoAppend = new PrintStream(new BufferedOutputStream(new FileOutputStream(finalnaNazwaPliku, false)));
        PrintStream printStreamWithAppend = new PrintStream(new BufferedOutputStream(new FileOutputStream(finalnaNazwaPliku, true)));


        //3. Skopiuj wszystkie bajty z plików *.partN do nowego pliku.
        for (int i = 0; i < nazwyWszystkichWczytanychPlikow.size(); i++){

            // gdy i = 0 nadpisuje plik - printStreamNoAppend
            // gdy i> 0 dodaje do pliku(append) - printStreamWithAppend
            if(i == 0){

                // wczytuję dane i zapisuję do pliku
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(nazwyWszystkichWczytanychPlikow.get(i)));
                    int znak;
                    while((znak = bufferedInputStream.read()) != -1){
                        printStreamNoAppend.print((char)znak);
                    }

                    //zamykam strumień
                    bufferedInputStream.close();

            } else {
                // wczytuję dane i zapisuję/dodaję do pliku
                BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(nazwyWszystkichWczytanychPlikow.get(i)));
                int znak;
                while((znak = bufferedInputStream.read()) != -1){
                    printStreamWithAppend.print((char)znak);
                }

                //zamykam strumień
                bufferedInputStream.close();
            }

        }

        //Zamykam strumienie.
        printStreamNoAppend.close();
        printStreamWithAppend.close();

//6. Nie używaj zmiennych statycznych.
    }
}
