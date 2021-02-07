package pl.codegym.task.task14.task1404;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Koty
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            String wczytanaLinia = reader.readLine();
            if(!wczytanaLinia.isEmpty()){
                Cat cat = CatFactory.getCatByKey(wczytanaLinia);
                System.out.println(cat.toString());
            } else {
                reader.close();
                break;
            }
        }
    }

    static class CatFactory {
        static Cat getCatByKey(String key) {
            Cat cat = null;
            if ("dziki".equals(key)) {
                cat = new MeanCat("Pazur");
            } else if ("mańka".equals(key)) {
                cat = new NiceCat("Mania");
            } else if ("kafel".equals(key)) {
                cat = new NiceCat("Kafelek");
            } else {
                cat = new Cat(key);
            }
            return cat;
        }
    }

    static class Cat {
        private String name;

        protected Cat(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        public String toString() {
            return "Jestem " + getName() + ", podwórkowy kocur";
        }
    }

    static class MeanCat extends Cat {
        MeanCat(String name) {
            super(name);
        }

        public String toString() {
            return "Jestem " + getName() + ", zaraz wydrapię Ci oczy";
        }
    }

    static class NiceCat extends Cat {
        NiceCat(String name) {
            super(name);
        }

        public String toString() {
            return "Jestem miłą kotką o imieniu " + getName();
        }
    }
}
