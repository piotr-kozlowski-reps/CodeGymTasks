package pl.codegym.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* 
Transakcyjność
*/

public class Solution {
    public static List<String> allLines = new ArrayList<>();
    public static List<String> linesForRemoval = new ArrayList<>();
    static String nazwaPliku1 = null;
    static String nazwaPliku2 = null;

    public static void main(String[] args) {
        Solution solution = new Solution();


        try{
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            nazwaPliku1 = bf.readLine();
            nazwaPliku2 = bf.readLine();
            bf.close();
        } catch (IOException e){
            e.printStackTrace();
        }

        // wpisanie linii do list
        wpisywanieZPlikuDoListy(allLines, nazwaPliku1);
        wpisywanieZPlikuDoListy(linesForRemoval, nazwaPliku2);

        //metoda joinData odpalona
        try{
            solution.joinData();
        } catch (CorruptedDataException e){
            e.printStackTrace();
        }


    }


    public void joinData() throws CorruptedDataException {

        // sprawdzenie czy pokrywają się wszystkie linie
        int ileLiniSiePokrywa = 0;
        for (int i = 0; i < allLines.size(); i++){
            for (int j = 0; j < linesForRemoval.size(); j++){
                if (allLines.get(i).equals(linesForRemoval.get(j))){
                    ileLiniSiePokrywa++;
                }
            }
        }

        //Jeśli lista allLines zawiera wszystkie linie z linesForRemoval, wówczas usuń z listy allLines wszystkie linie znajdujące się w linesForRemoval
        //jeżeli nie:
        //wyczyść dane w allLines
        //wyrzuć CorruptedDataException
        if (ileLiniSiePokrywa == linesForRemoval.size()){
            Iterator<String> allLinesList = allLines.iterator();
            while (allLinesList.hasNext()){
                String aktualnaLinia = allLinesList.next();
                for (int i = 0; i < linesForRemoval.size(); i++){
                    if (aktualnaLinia.equals(linesForRemoval.get(i))){
                        allLinesList.remove();
                        break;
                    }
                }
            }
        } else {
            allLines.clear();
            throw new CorruptedDataException();
        }

    }

    public static void wpisywanieZPlikuDoListy(List<String> lista, String nazwaPliku){

        try{
            BufferedReader fileReader = new BufferedReader(new FileReader(nazwaPliku));
            String linia;
            while ((linia = fileReader.readLine()) != null){
                lista.add(linia);
            }
            fileReader.close();
        } catch (IOException e){
            e.printStackTrace();
        }

    }

}
