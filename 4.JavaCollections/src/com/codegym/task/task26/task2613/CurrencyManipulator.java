package com.codegym.task.task26.task2613;

import com.codegym.task.task26.task2613.exception.InsufficientFundsException;

import java.util.*;
import java.util.concurrent.ConcurrentSkipListMap;

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
            if (entry.getKey().equals(denomination)) {

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


    public boolean isAmountAvailable(int expectedAmount) {
        // if (getTotalAmount() == 0 || expectedAmount == null) return false;
        if (getTotalAmount() == 0) return false;
        return expectedAmount <= getTotalAmount() ? true : false;
    }

    public Map<Integer, Integer> withdrawAmount(int expectedAmount) throws InsufficientFundsException {

        Map<Integer, Integer> resultMap = new ConcurrentSkipListMap<>(Collections.reverseOrder());
        if (expectedAmount <= 0) return resultMap;

        //collection of all available banknotes
        List<Integer> listOfAllAvailableBanknotes = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : denominations.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                listOfAllAvailableBanknotes.add(entry.getKey());
            }
        }

        Collections.sort(listOfAllAvailableBanknotes, Collections.reverseOrder());

        //collecting banknotes
        int amountCollected = 0;
        List<Integer> resultBanknotes = new ArrayList<>();
        for (int i = 0; i < listOfAllAvailableBanknotes.size(); i++) {

            if (amountCollected == expectedAmount) break;

            if ((amountCollected + listOfAllAvailableBanknotes.get(i)) <= expectedAmount) {
                resultBanknotes.add(listOfAllAvailableBanknotes.get(i));
                amountCollected += listOfAllAvailableBanknotes.get(i);
            }

            for (int j = i + 1; j < listOfAllAvailableBanknotes.size(); j++) {

                if (amountCollected == expectedAmount) break;

                if ((amountCollected + listOfAllAvailableBanknotes.get(j)) <= expectedAmount) {
                    resultBanknotes.add(listOfAllAvailableBanknotes.get(j));
                    amountCollected += listOfAllAvailableBanknotes.get(j);
                }
            }

            if (amountCollected != expectedAmount) resultBanknotes.clear();

        }

        //create map with desired banknotes and removing them from denominations
        for (Integer denomination : resultBanknotes) {

            for (Map.Entry<Integer, Integer> entry : denominations.entrySet()) {

                if (entry.getKey().equals(denomination)) {
                    if (resultMap.containsKey(denomination)) {
                        resultMap.put(denomination, resultMap.get(denomination) + 1);
                        Integer newValue = entry.getValue() - 1;
                        if (newValue <= 0) denominations.remove(entry.getKey());
                        else denominations.put(entry.getKey(), newValue);
                        break;
                    } else {
                        resultMap.put(denomination, 1);
                        Integer newValue = entry.getValue() - 1;
                        if (newValue <= 0) denominations.remove(entry.getKey());
                        else denominations.put(entry.getKey(), newValue);
                        break;
                    }
                }

            }
        }

        if (resultMap.size() == 0) throw new InsufficientFundsException();
        return resultMap;

    }


//    public static void main(String[] args) {
//
//        CurrencyManipulator currencyManipulator = new CurrencyManipulator("USD");
//        currencyManipulator.denominations.put(200, 3);
//        currencyManipulator.denominations.put(500, 2);
//        currencyManipulator.denominations.put(100, 1);
//        currencyManipulator.denominations.put(50, 12);
//
//        Map<Integer, Integer> result = currencyManipulator.withdrawAmount(600);
//
///*        CurrencyManipulator currencyManipulator = new CurrencyManipulator("USD");
//        currencyManipulator.denominations.put(200, 2);
//        currencyManipulator.denominations.put(100, 1);
//        currencyManipulator.denominations.put(50, 12);
//
//        Map<Integer, Integer> result = currencyManipulator.withdrawAmount(600);*/
//
///*        CurrencyManipulator currencyManipulator = new CurrencyManipulator("USD");
//        currencyManipulator.denominations.put(500, 2);
//        currencyManipulator.denominations.put(50, 1);
//
//        Map<Integer, Integer> result = currencyManipulator.withdrawAmount(600);*/
//
//
//
//
//    }



}