package pl.codegym.task.task20.task2001;

import java.io.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Odczytywanie i zapisywanie do pliku: Human
*/

/*
plik:
c:/!!programowanie/cwiczenia_pliki/pliki26/pliki26.txt
*/


public class Solution {

    public static void main(String[] args) {
        // Zaktualizuj ciąg przekazany do metody createTempFile na podstawie ścieżki do pliku na dysku twardym
        try {
            File yourFile = File.createTempFile("pliki26", ".txt", new File("c:/!!programowanie/cwiczenia_pliki/pliki26/"));
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            Human smith = new Human("Smith", new Asset("dom", 999_999.99), new Asset("samochód", 2999.99));
            smith.save(outputStream);
            outputStream.flush();

            Human somePerson = new Human();
            somePerson.load(inputStream);
            inputStream.close();

            // Sprawdź czy smith jest równy somePerson
            System.out.println(smith.equals(somePerson));

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

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Human human = (Human) o;

            if (name != null ? !name.equals(human.name) : human.name != null) return false;
            return assets != null ? assets.equals(human.assets) : human.assets == null;
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (assets != null ? assets.hashCode() : 0);
            return result;
        }

        public void save(OutputStream outputStream) throws Exception {

            String nowaLinia = "\n";
            byte[] nowaLiniaByte = nowaLinia.getBytes();


            //name  - Pole name klasy Human nie może być puste.
            byte[] nameByte = this.name.getBytes();
            outputStream.write(nameByte);
            outputStream.write(nowaLiniaByte);
            outputStream.flush();

            //assets
            //czy sa assety
            String areAssetsPresent = assets != null ? "yes" : "no";
            outputStream.write(areAssetsPresent.getBytes());
            outputStream.write(nowaLiniaByte);
            outputStream.flush();

            //ile assetow
            String ileAssetowString = String.valueOf(assets.size());
            byte[] ileAssetowByte = ileAssetowString.getBytes();
            outputStream.write(ileAssetowByte);
            outputStream.write(nowaLiniaByte);
            outputStream.flush();


            //assety po kolei w liniach:
            //name
            //price
            if (assets != null){

                for (int i = 0; i < assets.size(); i++){
                    Asset aktualnyAsset = assets.get(i);
                    byte[] assetNameBytes = aktualnyAsset.getName().getBytes();
                    String assetPriceAsString = String.valueOf(aktualnyAsset.getPrice());
                    byte[] assetPriceBytes = assetPriceAsString.getBytes();

                    outputStream.write(assetNameBytes);
                    outputStream.write(nowaLiniaByte);
                    outputStream.flush();

                    outputStream.write(assetPriceBytes);
                    outputStream.write(nowaLiniaByte);
                    outputStream.flush();
                }
            }
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader bufferedReaderFromTemporaryFile = new BufferedReader(new InputStreamReader(inputStream));

            //name
            this.name = bufferedReaderFromTemporaryFile.readLine();

            //assets
            String areAssetsPresent = bufferedReaderFromTemporaryFile.readLine();

            if (areAssetsPresent.equals("yes")){
                int ileAssetow = Integer.parseInt(bufferedReaderFromTemporaryFile.readLine());

                for (int i = 0; i < ileAssetow; i++){

                    String assetName = bufferedReaderFromTemporaryFile.readLine();
                    Double assetPrice = Double.parseDouble(bufferedReaderFromTemporaryFile.readLine());

                    this.assets.add(new Asset(assetName, assetPrice));
                }

            }
            //zamykam strumien
            bufferedReaderFromTemporaryFile.close();

        }
    }
}

