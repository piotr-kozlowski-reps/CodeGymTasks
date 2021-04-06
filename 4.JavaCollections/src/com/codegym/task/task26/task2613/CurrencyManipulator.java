package com.codegym.task.task26.task2613;

import java.util.HashMap;
import java.util.Map;

public class CurrencyManipulator {

    //fields
    private String currencyCode;
    private Map<Integer, Integer> denominations;

    //get/set
    public String getCurrencyCode() {
        return currencyCode;
    }

    //constr
    public CurrencyManipulator(String currencyCode) {
        this.currencyCode = currencyCode;
        denominations = new HashMap<>();
    }


    //
    public void addAmount(int denomination, int count) {

        for (Map.Entry<Integer, Integer> entry : denominations.entrySet()) {
            if (entry.getKey().equals(denomination)){

                Integer newValue = entry.getValue() + count;
                denominations.put(entry.getKey(), newValue);
                return;
            }
        }

        denominations.put(denomination, count);
    }

    public int getTotalAmount() {
        int result = 0;

        for (Map.Entry<Integer, Integer> entry : denominations.entrySet()) {
            int amountOfExacetDEnomination = entry.getKey() * entry.getValue();
            result += amountOfExacetDEnomination;
        }

        return result;
    }

    public boolean hasMoney() {

        int howManyNoBanknotes = denominations.size();

        for (Map.Entry<Integer, Integer> entry : denominations.entrySet()) {
            if (entry.getValue() == 0) howManyNoBanknotes--;
        }

        return howManyNoBanknotes == 0 ? false : true;
    }



}

