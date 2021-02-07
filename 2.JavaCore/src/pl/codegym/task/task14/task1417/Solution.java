package pl.codegym.task.task14.task1417;

import java.util.ArrayList;
import java.util.List;

/* 
Waluty
*/

public class Solution {
    public static void main(String[] args) {
        Person paul = new Person("Paul");
        for (Money money : paul.getAllMoney()) {
            System.out.println(paul.name + " ma schowane " + money.getAmount() + " " + money.getCurrencyName());
        }
    }

    static class Person {
        public String name;

        Person(String name) {
            this.name = name;
            this.allMoney = new ArrayList<Money>();
            //tutaj wpisz swój kod
            allMoney.add(new Euro(13.56));
            allMoney.add(new Ruble(45.54));
            allMoney.add(new USD(546.34));
        }

        private List<Money> allMoney;

        public List<Money> getAllMoney() {
            return allMoney;
        }
    }
}
