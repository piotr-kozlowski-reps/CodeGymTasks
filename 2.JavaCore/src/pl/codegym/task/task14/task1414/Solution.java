package pl.codegym.task.task14.task1414;

/* 
MovieFactory
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            String wczytanaLinia = reader.readLine();
            Movie movie;

            if (wczytanaLinia.equals("cartoon") || wczytanaLinia.equals("thriller") || wczytanaLinia.equals("soapOpera") ){
                movie = MovieFactory.getMovie(wczytanaLinia);
                System.out.println(movie.getClass().getSimpleName());
            } else{
                movie = MovieFactory.getMovie(wczytanaLinia);
                reader.close();
                break;
            }

        }

        // Wczytuje parę kluczy (ciągów) z konsoli. Punkt 7

        /*
            8. Tworzy zmienną movie w klasie Movie i dla każdego wprowadzonego ciągu (klucza):
            8.1. Pobiera obiekt za pomocą MovieFactory.getMovie i przypisuje go do zmiennej movie.
            8.2. Wyświetla wynik wywoływania metody movie.getClass().getSimpleName().
        */

    }

    static class MovieFactory {

        static Movie getMovie(String key) {
            Movie movie = null;

            // Tworzy obiekt SoapOpera dla klucza "soapOpera"
            if ("soapOpera".equals(key)) {
                movie = new SoapOpera();
            } else if ("cartoon".equals(key)){
                movie = new Cartoon();
            } else if ("thriller".equals(key)){
                movie = new Thriller();
            } else {
                movie = null;
            }

            //tutaj wpisz swój kod. Punkty 5 i 6

            return movie;
        }
    }

    static abstract class Movie {
    }

    static class SoapOpera extends Movie {
    }

    static class Cartoon extends Movie{

    }

    static class Thriller extends Movie{

    }
}
