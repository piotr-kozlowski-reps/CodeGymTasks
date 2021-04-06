package com.codegym.task.task26.task2613;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CurrencyManipulatorFactory {

    //fields
    private static Map<String, CurrencyManipulator> map  = new HashMap<>();

    //constr
    private CurrencyManipulatorFactory(){}


    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode) {

        currencyCode = currencyCode.toUpperCase();
        for (Map.Entry<String, CurrencyManipulator> entry : map.entrySet()) {
            if (entry.getKey().equals(currencyCode)) return entry.getValue();
        }

        CurrencyManipulator currencyManipulator = new CurrencyManipulator(currencyCode);
        map.put(currencyManipulator.getCurrencyCode(), currencyManipulator);

        return map.get(currencyCode);
    }

    public static Collection<CurrencyManipulator> getAllCurrencyManipulators() {

        Collection<CurrencyManipulator> resultCollection = new ArrayList<>();

        for (Map.Entry<String, CurrencyManipulator> entry : map.entrySet()) {
            resultCollection.add(entry.getValue());
        }

        return resultCollection;

    }
}
