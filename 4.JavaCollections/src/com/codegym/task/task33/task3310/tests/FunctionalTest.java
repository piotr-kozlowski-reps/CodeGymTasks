package com.codegym.task.task33.task3310.tests;

import com.codegym.task.task33.task3310.Shortener;
import com.codegym.task.task33.task3310.strategy.*;
import org.junit.Assert;
import org.junit.Test;

public class FunctionalTest {

    @Test
    public void testStorage(Shortener shortener) {

        String string1 = "string1Test1234";
        String string2 = "string2Test123sdcaacawed4";
        String string3 = "string1Test1234";

        Long key1 = shortener.getId(string1);
        Long key2 = shortener.getId(string2);
        Long key3 = shortener.getId(string3);

        Assert.assertTrue(key1 != key2);
        Assert.assertTrue(key3 != key2);
        Assert.assertEquals(key1, key3);

        String string1getFromShortener = shortener.getString(key1);
        String string2getFromShortener = shortener.getString(key2);
        String string3getFromShortener = shortener.getString(key3);

        Assert.assertEquals(string1, string1getFromShortener);
        Assert.assertEquals(string2, string2getFromShortener);
        Assert.assertEquals(string3, string3getFromShortener);

    }

    @Test
    public void testHashMapStorageStrategy() {
        StorageStrategy storageStrategyHashMap = new HashMapStorageStrategy();
        Shortener shortener = new Shortener(storageStrategyHashMap);
        testStorage(shortener);
    }

    @Test
    public void testOurHashMapStorageStrategy() {
        StorageStrategy storageStrategyOurHashMap = new OurHashMapStorageStrategy();
        Shortener shortener = new Shortener(storageStrategyOurHashMap);
        testStorage(shortener);
    }

    @Test
    public void testFileStorageStrategy() {
        StorageStrategy storageStrategyFile = new FileStorageStrategy();
        Shortener shortener = new Shortener(storageStrategyFile);
        testStorage(shortener);
    }

    @Test
    public void testHashBiMapStorageStrategy() {
        StorageStrategy storageStrategyBiMap = new OurHashBiMapStorageStrategy();
        Shortener shortener = new Shortener(storageStrategyBiMap);
        testStorage(shortener);
    }

    @Test
    public void testDualHashBidiMapStorageStrategy() {
        StorageStrategy storageStrategyHashBiDiMapApache = new DualHashBidiMapStorageStrategy();
        Shortener shortener = new Shortener(storageStrategyHashBiDiMapApache);
        testStorage(shortener);
    }

    @Test
    public void testOurHashBiMapStorageStrategy() {
        StorageStrategy storageStrategyHashBiMapGuava = new HashBiMapStorageStrategy();
        Shortener shortener = new Shortener(storageStrategyHashBiMapGuava);
        testStorage(shortener);
    }

}