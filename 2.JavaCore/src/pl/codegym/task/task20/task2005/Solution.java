package pl.codegym.task.task20.task2005;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/* 
Dziwne błędy
*/


//Podczas odczytu/zapisu obiektów Human pojawiają się dziwne błędy.
//Dowiedz się, co jest nie tak i popraw to.
//
//
//Requirements:
//1. Logika odczytu/zapisu w metodach save/load musi działać poprawnie, gdy lista assets jest pusta.
//2. Logika odczytu/zapisu w metodach save/load musi działać poprawnie, gdy pole name i lista assets nie są puste.



//6. Metoda equals musi zwracać wartość true dla dwóch jednakowych obiektów Human i false dla różnych obiektów.
//7. Metoda hashCode musi zawsze zwracać tę samą wartość dla tego samego obiektu Human.

public class Solution {

    public static void main(String[] args) {
        // Zaktualizuj ciąg przekazany do metody createTempFile na podstawie ścieżki do pliku na dysku twardym
        try {
            File yourFile = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            Human smith = new Human ("Smith", new Asset ("dom"), new Asset ("samochód"));
            smith.save(outputStream);
            outputStream.flush();

            Human somePerson = new Human();
            somePerson.load(inputStream);
            // Sprawdź czy smith jest równy somePerson
            System.out.println(smith.equals(somePerson));
            inputStream.close();

        } catch (IOException e) {
            // e.printStackTrace();
            System.out.println("Oops, coś jest nie tak z moim plikiem");
        } catch (Exception e) {
            // e.printStackTrace();
            System.out.println("Oops, coś jest nie tak z metodą save/load");
        }
    }

    public static class Human {

        public String name;
        public List<Asset> assets = new ArrayList<>();

        @Override
        public boolean equals(Object o) {
            if (this == o) return false;
            if (o == null || getClass() != o.getClass()) return false;

            Human human = (Human) o;

            if (!Objects.equals(name, human.name)) return false;
            return Objects.equals(assets, human.assets);
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (assets != null ? assets.hashCode() : 0);
//            return (int) (Math.random() * 100);
            return result;
        }

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        public void save(OutputStream outputStream) throws Exception {
            // Implementuj tę metodę
            PrintWriter printWriter = new PrintWriter(outputStream);
            printWriter.println(this.name);
            if (this.assets.size() > 0) {
                for (Asset current : this.assets)
                    printWriter.println(current.getName());
            }
            printWriter.close();
        }

        public void load(InputStream inputStream) throws Exception {
            // Implementuj tę metodę
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            this.name = reader.readLine();
            String assetName;
            while ((assetName = reader.readLine()) != null)
                this.assets.add(new Asset(assetName));
            reader.close();
        }
    }
}
