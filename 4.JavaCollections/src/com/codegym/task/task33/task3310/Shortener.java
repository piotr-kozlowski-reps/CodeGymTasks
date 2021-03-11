package com.codegym.task.task33.task3310;

import com.codegym.task.task33.task3310.strategy.StorageStrategy;

public class Shortener {

    //fields
    private Long lastId = 0L;
    private StorageStrategy storageStrategy;

    //constr
    public Shortener(StorageStrategy storageStrategy) {
        this.storageStrategy = storageStrategy;
    }



    public synchronized Long getId(String string) {

        if (storageStrategy.containsValue(string)) {
            return storageStrategy.getKey(string);
        } else {
            this.lastId += 1;
            storageStrategy.put(lastId, string);
            return lastId;
        }
    }

    public synchronized String getString(Long id) {
        return storageStrategy.getValue(id);
    }


}