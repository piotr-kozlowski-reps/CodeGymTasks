package pl.codegym.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Parser żądań
*/

public class Solution {
    public static void main(String[] args) throws IOException{

        //wczytanie linku z konsoli
        String linkWczytany = null;
        try {
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            while ((linkWczytany = bf.readLine()) != null){
                bf.close();
            }
        } catch (IOException e){ }



        // przyciecie Stringu za znakiem zapytania
        int indexZNakuZapytania = 0;
        for (int i = 0; i < linkWczytany.length(); i++) {
            char znak = linkWczytany.charAt(i);
            if (znak == '?') {
                indexZNakuZapytania = i;
            }
        }

        linkWczytany = linkWczytany.substring(indexZNakuZapytania + 1, linkWczytany.length());


        // rozbicie parametrow do ArrayList
        List<String> listaStringow = new ArrayList<String>();
        StringTokenizer tokenizerAnd = new StringTokenizer(linkWczytany, "&");
        while (tokenizerAnd.hasMoreElements()){
            listaStringow.add(String.valueOf(tokenizerAnd.nextElement()));
        }


        //HashMap parametrow
        Map<String, String> listaParametrow = new LinkedHashMap<String, String>();

        for (String element : listaStringow){

            boolean czyJestRownasie = false;

            for (int i = 0; i < element.length(); i++){
                char znak = element.charAt(i);
                if (znak == '='){
                    czyJestRownasie = true;
                }
            }

            if(czyJestRownasie){
                boolean czyPierwszy = false;

                StringTokenizer tokenizerRownasie = new StringTokenizer(element, "=");
                String pierszy = null;
                String drugi = null;

                while (tokenizerRownasie.hasMoreElements()){
                    if (!czyPierwszy){
                        pierszy = String.valueOf(tokenizerRownasie.nextElement());
                        czyPierwszy = true;
                    } else {
                        drugi = String.valueOf(tokenizerRownasie.nextElement());
                    }
                }

                listaParametrow.put(pierszy, drugi);

            } else if (!czyJestRownasie){
                listaParametrow.put(element, null);
            }

        }

        //wyswietlanie
        wyswietlParametry(listaParametrow);                                         // wyswietnie samych parametrow
        odpalAlert(listaParametrow);                                                // wyswietnie metod alert(?) jezeli jest parametr obj

    }




    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }

    // METODA: wyswietnie samych parametrow
    public static void wyswietlParametry(Map<String, String> mapa){
        for (Map.Entry<String, String> wpisMapy : mapa.entrySet()){
            System.out.print(wpisMapy.getKey() + " ");
        }
//        System.out.println("\n");
    }

    // METODA: wyswietnie metod alert() jezeli jest parametr obj
    public static void odpalAlert(Map<String, String> mapa){
        for (Map.Entry<String, String> wpisMapy : mapa.entrySet()){
            if (wpisMapy.getKey().equals("obj")){
                ktoraMetodaAlert(wpisMapy.getValue());
            }
        }
    }
    // METODA: sprawdza czy odpalic alert(Double) czy alert(String)
    public  static void ktoraMetodaAlert(String string){
        if (czyToDouble(string)){
            Double d = Double.parseDouble(string);
            System.out.print("\n");
            alert(d);
        } else {
            System.out.print("\n");
            alert(string);
        }
    }

    // METODA: czy ten String to moze byc Double
    public  static boolean czyToDouble(String string){
        boolean wynik = false;
        boolean pierwszaMinusLubLiczba = false;
        boolean czyNastepneToLiczbyLubKropki = true;
        int ileKropek = 0;

        // pierwszy znak
        char znak = string.charAt(0);
        if (znak == '-' || Character.isDigit(znak)){
            pierwszaMinusLubLiczba = true;
        }

        //następne znaki
        for(int i = 1; i < string.length(); i++){
            znak = string.charAt(i);
            if (!Character.isDigit(znak) && znak != '.'){
                if (czyNastepneToLiczbyLubKropki){
                    czyNastepneToLiczbyLubKropki = false;
                }
            } else if (znak == '.'){
                ileKropek++;
            }
        }

        if (pierwszaMinusLubLiczba && czyNastepneToLiczbyLubKropki && ileKropek <= 1 && string.length() >= 2){
            wynik = true;
        }

        return wynik;
    }

}
