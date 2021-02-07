package pl.codegym.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* 
Różne metody dla różnych typów
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        // wczytywanie z klawiatury
        BufferedReader zczytywacz = new BufferedReader(new InputStreamReader(System.in));
        List<String> listaStringow = new ArrayList<String>();
        String liniaTextu;

        while (true){
            liniaTextu = zczytywacz.readLine();
            if (liniaTextu.equals("exit")){
                zczytywacz.close();
                break;
            } else {
                listaStringow.add(liniaTextu);
            }
        }

            for (String linia : listaStringow){
                rozdzialMetod(linia);
            }



    }

    public static void rozdzialMetod(String string) {

        // czyToLiczbaCzyString?
        if (czyToLiczba(string) == true) {

            //Double
            boolean czyJestKropka = false;
            for (int i = 0; i < string.length(); i++) {

                char znak = string.charAt(i);

                if (znak == '.') {
                    czyJestKropka = true;
                }
            }

            if (czyJestKropka) {
                double d = Double.parseDouble(string);
                print(d);
            } else {
                int integer = Integer.parseInt(string);
                if (integer > 0 && integer < 128) {
                    short s = (short) integer;
                    print(s);
                } else {
                    print(integer);
                }

            }

        } else {
            print(string);
        }
    }




    public static boolean czyToLiczba(String s){

        boolean czyToLiczbaBoolean;
        boolean pierwszaLiteraBoolean = false;
        boolean nastepneLiteryBoolean = true;
        int ileKropek = 0;


        // czyPierwszaLiteraToMinusLubLiczba
        char pierwszaLitera = s.charAt(0);
        if (pierwszaLitera == '-' || Character.isDigit(pierwszaLitera)){
            pierwszaLiteraBoolean = true;
        }


        // czyNastepneLiteryToKropkaLubLiczba
        for (int i = 1; i < s.length(); i++){

            char nastepnaLitera = s.charAt(i);

            if (nastepnaLitera == '.'){
                ileKropek++;
            }

            if (!Character.isDigit(nastepnaLitera)){
                if (nastepnaLitera != '.'){
                    nastepneLiteryBoolean = false;
                }
            }

        }


        if(pierwszaLiteraBoolean == true && nastepneLiteryBoolean == true && ileKropek < 2){
            czyToLiczbaBoolean = true;
        } else {
            czyToLiczbaBoolean = false;
        }


        return czyToLiczbaBoolean;
    }

/*

    public static void rozdzialMetod(String string){

        // Double - pkt3
        boolean doubleCzyKropka = false;
        boolean doubleCzyLiczba = true;
        for (int i = 0; i < string.length(); i++) {
            char litera = string.charAt(i);

            if (litera == '.') {
                doubleCzyKropka = true;
            } else if (!Character.isDigit(litera)) {
                doubleCzyLiczba = false;
            }
        }

            if (doubleCzyKropka == true && doubleCzyLiczba == true){
                double d = Double.parseDouble(string);
                print(d);
            }



        // Short - pkt4
        boolean shortCzyLiczba = true;
        for (int i = 0; i < string.length(); i++){
            char litera = string.charAt(i);

            if (!Character.isDigit(litera)){
                shortCzyLiczba = false;
            }
        }

            if (shortCzyLiczba == true){

                int liczba = Integer.parseInt(string);

                // wywolanie print(short)
                if (liczba > 0 && liczba < 128) {
                    short s = (short) liczba;
                    print(s);
                }

                //wywolanie print(Integer)
                if (liczba <= 0 || liczba >= 128) {
                    print(liczba);
                }

            } else {
                print(string);
            }



        // Integer - pkt 5


    }

*/

    public static void print(Double value) {
        System.out.println("To jest Double. Value: " + value);
    }

    public static void print(String value) {
        System.out.println("To jest String. Value: " + value);
    }

    public static void print(short value) {
        System.out.println("To jest liczba całkowita typu short. Value: " + value);
    }

    public static void print(Integer value) {
        System.out.println("To jest liczba całkowita typu Integer. Value: " + value);
    }
}
