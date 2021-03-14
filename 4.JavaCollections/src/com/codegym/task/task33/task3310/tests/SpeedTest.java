package com.codegym.task.task33.task3310.tests;

import com.codegym.task.task33.task3310.Helper;
import com.codegym.task.task33.task3310.Shortener;
import com.codegym.task.task33.task3310.strategy.HashBiMapStorageStrategy;
import com.codegym.task.task33.task3310.strategy.HashMapStorageStrategy;
import com.codegym.task.task33.task3310.strategy.StorageStrategy;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class SpeedTest {

    public long getTimeToGetIds(Shortener shortener, Set<String> strings, Set<Long> ids) {

        long startTime = System.currentTimeMillis();

        for (String everyStringFromSet : strings) {
            Long everyId = shortener.getId(everyStringFromSet);
            ids.add(everyId);
        }

        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    public long getTimeToGetStrings(Shortener shortener, Set<Long> ids, Set<String> strings) {

        Date startTimestamp = new Date();

        for (Long everyLongFromSet : ids) {
            strings.add(shortener.getString(everyLongFromSet));
        }

        Date endtTimestamp = new Date();
        return endtTimestamp.getTime() - startTimestamp.getTime();

    }

    @Test
    public void testHashMapStorage() {

        StorageStrategy storageStrategyHashMap = new HashMapStorageStrategy();
        StorageStrategy storageStrategyHashBiMap = new HashBiMapStorageStrategy();

        Shortener shortener1 = new Shortener(storageStrategyHashMap);
        Shortener shortener2 = new Shortener(storageStrategyHashBiMap);

        Set<String> origStrings = new HashSet<>();
        for (int i = 0; i < 10000; i++) {
            origStrings.add(Helper.generateRandomString());
        }

        Set<Long> ids1 = new HashSet<>();
        Set<String> strings1 = new HashSet<>();

        long stringToIdTime1 = getTimeToGetIds(shortener1, origStrings, ids1);
        long idToStringTime1 = getTimeToGetStrings(shortener1, ids1, strings1);

        Set<Long> ids2 = new HashSet<>();
        Set<String> strings2 = new HashSet<>();

        long stringToIdTime2 = getTimeToGetIds(shortener2, origStrings, ids2);
        long idToStringTime2 = getTimeToGetStrings(shortener2, ids2, strings2);

        Assert.assertTrue(stringToIdTime1 > stringToIdTime2);

        Assert.assertEquals(idToStringTime1, idToStringTime2, 30);


    }


}

