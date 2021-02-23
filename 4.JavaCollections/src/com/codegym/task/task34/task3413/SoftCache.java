package com.codegym.task.task34.task3413;

import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SoftCache {
    private Map<Long, SoftReference<AnyObject>> cacheMap = new ConcurrentHashMap<>();

    public AnyObject get(Long key) {
        SoftReference<AnyObject> softReference = cacheMap.get(key);
        AnyObject result = softReference.get();
        return result;
    }

    public AnyObject put(Long key, AnyObject value) {
        SoftReference<AnyObject> softReference = cacheMap.put(key, new SoftReference<>(value));
        return null;
    }

    public AnyObject remove(Long key) {
        SoftReference<AnyObject> softReference = cacheMap.remove(key);

        //write your code here

        return null;
    }
}



//The AnyObject put(Long key, AnyObject value) method must add a key-value pair to the map. The method must return null if
// cacheMap isn't already storing a value using key. Otherwise, it must return the value already stored using key. Don't forget
// to call the clear() method on the SoftReference<AnyObject> object.
//
//The AnyObject class's remove(Long key) method must remove from cacheMap the key-value pair that matches key. The method must
// return null if cacheMap isn't already storing a value using key. Otherwise, it must return the value already stored using key.
// Don't forget to call the clear() method on the SoftReference<AnyObject> object.
//
//Don't change the AnyObject class.
//The main method is not tested.


//3. Implement the get method as outlined in the task conditions.
//4. Implement the put method as outlined in the task conditions.
//5. Implement the remove method as outlined in the task conditions.