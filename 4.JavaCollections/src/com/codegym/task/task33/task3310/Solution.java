package com.codegym.task.task33.task3310;

import com.codegym.task.task33.task3310.strategy.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Solution {


    //
    public static void main(String[] args) {

        Solution solution = new Solution();
        StorageStrategy storageStrategyHashMap = new HashMapStorageStrategy();
        StorageStrategy storageStrategyOurHashMap = new OurHashMapStorageStrategy();
        StorageStrategy storageStrategyFile = new FileStorageStrategy();
        StorageStrategy storageStrategyBiMap = new OurHashBiMapStorageStrategy();
        StorageStrategy storageStrategyHashBiMapGuava = new HashBiMapStorageStrategy();
        StorageStrategy storageStrategyHashBiDiMapApache = new DualHashBidiMapStorageStrategy();

        solution.testStrategy(storageStrategyHashMap, 300);
        solution.testStrategy(storageStrategyOurHashMap, 300);
        solution.testStrategy(storageStrategyFile, 300);
        solution.testStrategy(storageStrategyBiMap, 300);
        solution.testStrategy(storageStrategyHashBiMapGuava, 300);
        solution.testStrategy(storageStrategyHashBiDiMapApache, 300);

        
    }

    public static Set<Long> getIds(Shortener shortener, Set<String> strings) {

        Set<Long> resultSet = new HashSet<>();

        for (String everyString : strings) {
            resultSet.add(shortener.getId(everyString));
        }

        return resultSet;

    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys) {

        Set<String> resultSet = new HashSet<>();

        for (Long everyKey : keys) {
            resultSet.add(shortener.getString(everyKey));
        }

        return resultSet;
    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber) {

        //6.2.3.1. Display the name of the class strategy. The name must not include the package name.
        Helper.printMessage(strategy.getClass().getSimpleName());

        //6.2.3.2. Generate a test set using Helper and the specified number of elements (elementsNumber).
        Set<String> testStringSet = new HashSet<>();
        for (int i = 0; i < elementsNumber; i++) {
            testStringSet.add(Helper.generateRandomString());
        }

        //6.2.3.3. Create a Shortener object using the passed strategy.
        Shortener shortener = new Shortener(strategy);

        //6.2.3.4. Measure and display the time required to run the getIds method for the given strategy and the given set of elements.
        // Display time in milliseconds. When measuring the method's execution time, you can ignore the processor switching to other
        // threads, as well as the time spent on the call itself, returning values, and calling methods to get the time (date). Measure
        // time using Date objects.
        Date startTime1 = new Date();
        Set<Long> testLongsSet = getIds(shortener, testStringSet);
        Date endTime1 = new Date();
        Helper.printMessage(String.valueOf(endTime1.getTime() - startTime1.getTime()));


        //6.2.3.5. Measure and display the time required to run the getStrings method for a given strategy and the set of identifiers
        // obtained in the previous clause.
        Date startTime2 = new Date();
        Set<String> stringsSetToCompare = getStrings(shortener, testLongsSet);
        Date endTime2 = new Date();
        Helper.printMessage(String.valueOf(endTime2.getTime() - startTime2.getTime()));


        //6.2.3.6. Check whether the contents of the set of generated strings and the set returned by getStrings method are the same.
        // If the sets are the same, then display "The test passed.". Otherwise, display "The test failed.".
        if (testStringSet.containsAll(stringsSetToCompare)) Helper.printMessage("The test passed.");
        else Helper.printMessage("The test failed.");

    }

}