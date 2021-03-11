package com.codegym.task.task33.task3310.strategy;

import java.util.HashMap;
import java.util.Map;

public class HashMapStorageStrategy implements StorageStrategy {

    //fields
    private HashMap<Long, String> data = new HashMap<>();




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

        for (Map.Entry<Long, String> entry : data.entrySet()) {

            if (entry.getValue().equals(value)) {
                return entry.getKey();
            }

        }

        return null;
    }

    @Override
    public String getValue(Long key) {
        return data.get(key);
    }
}


//5.2. Add a HashMap<Long, String> data field to the class. It will store our data.
//5.3. Implement all the methods the class needs. The methods' implementations must use the
// data field. Don't create additional fields.

//3. The HashMapStorageStrategy class must correctly implement the containsKey method.
//4. The HashMapStorageStrategy class must correctly implement the containsValue method.
//5. The HashMapStorageStrategy class must correctly implement the put method.
//6. The HashMapStorageStrategy class must correctly implement the getValue method.
//7. The HashMapStorageStrategy class must correctly implement the getKey method.