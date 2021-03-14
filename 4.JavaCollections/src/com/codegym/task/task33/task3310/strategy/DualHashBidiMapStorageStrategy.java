package com.codegym.task.task33.task3310.strategy;

import com.google.common.collect.HashBiMap;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;

public class DualHashBidiMapStorageStrategy implements StorageStrategy{

    //fields
    DualHashBidiMap<Long, String> data = new DualHashBidiMap<>();


    //
    @Override
    public boolean containsKey(Long key) {
        return data.containsKey(key);
    }

    @Override
    public boolean containsValue(String value) {
        return data.containsValue(value);
    }

    @Override
    public void put(Long key, String value) {
        data.put(key, value);
    }

    @Override
    public Long getKey(String value) {
        return data.getKey(value);
    }

    @Override
    public String getValue(Long key) {
        return data.get(key);
    }

}



//13.2.1. support the StorageStrategy interface.
//13.2.2. have only one DualHashBidiMap data field.
//13.3. Test the new strategy in the main() method. Run the program and compare the performance of the six strategies.
//
//
//Requirements:
//1. The DualHashBidiMapStorageStrategy class must support the StorageStrategy interface.
//2. Only one DualHashBidiMap data field should be created in the DualHashBidiMapStorageStrategy class.
//3. The containsKey method should check whether the key is contained in data.
//4. The containsValue method should check whether the value is contained in data.
//5. The put method must add a pair (key, value) to data.
//6. The getValue method should return a value obtained from data.
//7. The getKey method should use the getKey method should return the key obtained from data.