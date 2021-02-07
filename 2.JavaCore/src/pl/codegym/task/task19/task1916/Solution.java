package pl.codegym.task.task19.task1916;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Śledzenie zmian
*/

/*
pliki:
c:\!!programowanie\cwiczenia_pliki\pliki17\pliki17__file1.txt
c:\!!programowanie\cwiczenia_pliki\pliki17\pliki17__file2.txt
*/


public class Solution {

    public static List<LineItem> lines = new ArrayList<>();

    public static void main(String[] args) {

        //4. Program musi odczytywać nazwę pliku z konsoli (użyj BufferedReader). //Odczytaj 2 nazwy plików z konsoli: file1 i file2.
        String file1 = "";
        String file2 = "";

        try{
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            file1 = bufferedReader.readLine();
            file2 = bufferedReader.readLine();
            //5. W metodzie main(String[] args), BufferedReader używany do odczytu danych wejściowych z konsoli musi zostać zamknięty po zakończeniu korzystania z niego.
            bufferedReader.close();
        } catch (IOException e) {}


        //6. Program musi odczytywać zawartość pierwszego i drugiego pliku (użyj FileReader).
        List<String> linieFile1 = new ArrayList<>();
        List<String> linieFile2 = new ArrayList<>();

        try{
            //plik pierwszy
            BufferedReader bufferedReaderFromFile = new BufferedReader(new FileReader(file1));
            String liniaPliku;
            while ((liniaPliku = bufferedReaderFromFile.readLine()) != null){
                linieFile1.add(liniaPliku);
            }

            //plik drugi
            bufferedReaderFromFile = new BufferedReader(new FileReader(file2));
            while ((liniaPliku = bufferedReaderFromFile.readLine()) != null){
                linieFile2.add(liniaPliku);
            }

            bufferedReaderFromFile.close();
        } catch (IOException e) {}

        //Oba pliki zawierają tekst, ale file2 jest zaktualizowaną wersją file1. Niektóre linie są nadal takie same.
        //Musisz stworzyć połączoną wersję linii, zapisując je na liście lines.
        //Etykiety ADDED i REMOVED nie mogą być używane po kolei - muszą być zawsze oddzielone etykietą SAME.
        String liniaAktualnaFile1 = "";
        String liniaAktualnaFile2 = "";
        String liniaNastepnaFile1 = "";
        String liniaNastepnaFile2 = "";
        int file1odejmijOdI = 0;
        int file2odejmijOdI = 0;

        for (int i = 0; i < linieFile1.size(); i++){
            liniaAktualnaFile1 = linieFile1.get(i + file1odejmijOdI);
            if (i < linieFile2.size()) liniaAktualnaFile2 = linieFile2.get(i + file2odejmijOdI);

            //jeżeli są takie same
            if (liniaAktualnaFile1.equals(liniaAktualnaFile2)){
                lines.add(new LineItem(Type.SAME, liniaAktualnaFile1));
                file2odejmijOdI = 0;
                file1odejmijOdI = 0;
                continue;
            }

            //jeżeli się różnią
            if (i < linieFile1.size()) liniaNastepnaFile1 = linieFile1.get(i + 1);
            else liniaNastepnaFile1 = null;
            if (i < linieFile2.size()) liniaNastepnaFile2 = linieFile2.get(i + 1);
            else liniaNastepnaFile1 = null;

            if(liniaAktualnaFile2.equals(liniaNastepnaFile1)) {
                lines.add(new LineItem(Type.REMOVED, liniaAktualnaFile1));
               file2odejmijOdI = -1;
                continue;
            } else {
                lines.add(new LineItem(Type.ADDED, liniaAktualnaFile1));
                file2odejmijOdI = -1;
                continue;
            }


//Przykład 1:
//original   updated    merged
//file1:     file2:     Result: (lines)
//
//line1      line1      SAME line1                  line1   line1
//line2                 REMOVED line2               line2   line3
//line3      line3      SAME line3                  line3   line5
//line4                 REMOVED line4               line4   line0
//line5      line5      SAME line5                  line5   line1
//           line0      ADDED line0                 line1   line3
//line1      line1      SAME line1                  line2   line4
//line2                 REMOVED line2               line3   line5
//line3      line3      SAME line3                  line5
//           line4      ADDED line4                 line0
//line5      line5      SAME line5
//line0                 REMOVED line0



        }







//Przykład zawiera puste linie dla przejrzystości.
//Ani plik oryginalny, ani zaktualizowany nie mają pustych linii!
//

//
//Przykład 2:
//original   updated    merged
//file1:     file2:     Result: (lines)
//
//line1      line1      SAME line1
//           line0      ADDED line0
//
//W podanym przykładzie puste linie oznaczają, że linia nie znajduje się w podanym pliku.





//7. Strumienie wejściowe pliku (FileReader) muszą zostać zamknięte.
//8. Lista lines powinna stanowić połączoną wersję linii z plików. Każda linia powinna zaczynać się od etykiety ADDED, REMOVED lub SAME, w zależności od wykonanej operacji.
    }

    public static enum Type {
        ADDED,        // Dodana nowa linia
        REMOVED,      // Linia usunięta
        SAME          // Bez zmian
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
