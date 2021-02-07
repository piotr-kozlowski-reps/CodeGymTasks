package pl.codegym.task.task20.task2004;

import java.io.*;

/* 
Odczytywanie i zapisywanie pól statycznych do pliku
*/

//Zaimplementuj logikę pliku IO w klasie ClassWithStatic.
//Metoda load musi inicjalizować obiekt, łącznie z polami statycznymi z danymi z pliku.
//Metoda main nie jest testowana.
//
//
//Requirements:
//1. Powinno być możliwe zapisywanie/ładowanie obiektów Solution.ClassWithStatic za pomocą metod save/load.
//2. Klasa Solution.Class nie powinna obsługiwać interfejsu Serializable.
//3. Klasa Solution.ClassWithStatic nie powinna obsługiwać interfejsu Serializable.
//4. Klasa Solution.ClassWithStatic musi być publiczna.
//5. Klasa Solution.ClassWithStatic nie powinna obsługiwać interfejsu Externalizable.

public class Solution {

    public static void main(String[] args) {
        // Plik your_file_name.tmp znajdziesz w swoim folderze plików tymczasowych, ewentualnie dostosuj outputStream/inputStream do rzeczywistej lokalizacji pliku
        try {
            File yourFile = File.createTempFile("plik29", null, new File("c:/!!programowanie/cwiczenia_pliki/pliki29/"));
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            ClassWithStatic classWithStatic = new ClassWithStatic();
            classWithStatic.i = 3;
            classWithStatic.j = 4;
            classWithStatic.save(outputStream);
            outputStream.flush();

            ClassWithStatic loadedObject = new ClassWithStatic();
            loadedObject.staticString = "something";
            loadedObject.i = 6;
            loadedObject.j = 7;

            loadedObject.load(inputStream);
            // Tutaj sprawdź, czy obiekt classWithStatic jest równy obiektowi loadedObject
            System.out.println(classWithStatic.equals(loadedObject));

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, coś jest nie tak z moim plikiem");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, coś jest nie tak z metodą save/load");
        }
    }

    public static class ClassWithStatic {

        public static String staticString = "To jest statyczny ciąg testowy";
        public int i;
        public int j;

        public void save(OutputStream outputStream) throws Exception {

            PrintWriter printWriterToFile = new PrintWriter(outputStream);
            printWriterToFile.println(ClassWithStatic.staticString);
            printWriterToFile.println(i);
            printWriterToFile.println(j);
            printWriterToFile.flush();

        }

        public void load(InputStream inputStream) throws Exception {
            DataInputStream dataInputStreamFromFile = new DataInputStream(new BufferedInputStream(inputStream));
            ClassWithStatic.staticString = dataInputStreamFromFile.readLine();
            this.i = Integer.parseInt(dataInputStreamFromFile.readLine());
            this.j = Integer.parseInt(dataInputStreamFromFile.readLine());
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            ClassWithStatic that = (ClassWithStatic) o;

            if (i != that.i) return false;
            return j == that.j;
        }

        @Override
        public int hashCode() {
            int result = i;
            result = 31 * result + j;
            return result;
        }
    }
}