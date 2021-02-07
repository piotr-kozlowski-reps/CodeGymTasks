package pl.codegym.task.task18.task1821;

/* 
Częstotliwość występowania symboli
*/

/*
plik w argumencie[0]:
c:\!!programowanie\cwiczenia_pliki\file4.txt
*/


import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        File nazwaPliku = null;
        List<Integer> wszystkieZnaki = new ArrayList<Integer>();
        List<Integer> znakiUnikalne = new ArrayList<Integer>();
        Map<Integer, Integer> mapaZnakow = new HashMap<Integer, Integer>();


        //Program jest uruchamiany z jednym argumentem: nazwą pliku, który zawiera tekst.
        nazwaPliku = new File(args[0]);

        try{
            //2. Utwórz strumień do odczytu z pliku przekazanego jako pierwszy argument metody main.
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(nazwaPliku));

            //3. Musisz obliczyć częstotliwość występowania każdego symbolu w pliku i wyświetlić wyniki.
            //wrzucam wszytskie znaki do ArrayList
            int znak;
            while (bufferedInputStream.available() > 0){
                znak = bufferedInputStream.read();
                wszystkieZnaki.add(znak);
            }

            //wrzucam znaki do HashMap by uzyskac unikalne znaki w kluczach
            for (Integer znakZArrayList : wszystkieZnaki){
                mapaZnakow.put(znakZArrayList, 0);
            }

            //zapisuje w HashMapie ile dany znak pojawil sie w pliku
            for (Integer znakZArrayList : wszystkieZnaki){
                for(Map.Entry<Integer, Integer> entry : mapaZnakow.entrySet()){
                    if (entry.getKey().equals(znakZArrayList)){
                        int ileByloNarazieWywolan = entry.getValue();
                        ileByloNarazieWywolan++;
                        entry.setValue(ileByloNarazieWywolan);
                    }
                }
            }

            // przepisuje wszytskie klucze do nowej ArrayListy
            for(Map.Entry<Integer, Integer> entry : mapaZnakow.entrySet()){
                znakiUnikalne.add(entry.getKey());
            }

            // sortuje liste Unikalnych Znakow
            Collections.sort(znakiUnikalne);

            // wyswietlam posortowana HashMapa
            for(Integer znakZnakowUnikalnych : znakiUnikalne){
                for(Map.Entry<Integer, Integer> entryHashMapy : mapaZnakow.entrySet()){
                    if (entryHashMapy.getKey().equals(znakZnakowUnikalnych)){
                        char znakChar;
                        int znakInt;
                        znakInt = entryHashMapy.getKey();
                        znakChar = (char) znakInt;
                        System.out.println(znakChar + " " + entryHashMapy.getValue());
                    }
                }
            }








            //5. Strumień wykorzystywany do odczytu pliku musi zostać zamknięty.
            bufferedInputStream.close();
        } catch (Exception e){}






//Oblicz, jak często występuje każdy symbol.
//Posortuj wyniki poprzez zwiększenie kodu ASCII (poczytaj na ten temat w internecie).
//
//Przykład:
//','=44, 's'=115, 't'=116.
//
//Wyświetl posortowane wyniki:
//[symbol1] częstotliwość1
//[symbol2] częstotliwość2
//Zamknij strumienie.
//
//Przykładowy wynik:
//, 19
//- 7
//f 361
//
//
//Requirements:


//4. Wyświetlane wyniki powinny być posortowane według rosnącego kodu ASCII.


    }
}
