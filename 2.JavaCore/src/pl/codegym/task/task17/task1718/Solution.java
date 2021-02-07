package pl.codegym.task.task17.task1718;

/* 
Prasowanie
*/

public class Solution {
    public static void main(String[] args) {
        Person diana = new Person("Diana");
        Person steve = new Person("Steve");
        diana.start();
        steve.start();
    }

    public static class Person extends Thread {

        public Person(String name) {
            super(name);
        }

        @Override
        public void run() {
            synchronized (Iron.class){
                Iron iron = takeIron();
                Clothes clothes = takeClothes();
                iron(iron, clothes);
                returnIron();
            }
        }

        protected Iron takeIron() {
            System.out.println("Zabranie żelazka");
            return new Iron();
        }

        protected Iron returnIron() {
            System.out.println("Oddanie żelazka");
            return new Iron();
        }

        protected Clothes takeClothes() {
            return new Clothes("T-shirt");
        }

        protected void iron(Iron iron, Clothes clothes) {
            System.out.println(getName() + " prasuje " + clothes.name);
        }
    }

    public static class Iron {
    }

    public static class Clothes {
        String name;

        public Clothes(String name) {
            this.name = name;
        }
    }
}
