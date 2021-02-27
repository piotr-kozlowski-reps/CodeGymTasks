package com.codegym.task.task34.task3413;

import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SoftCache {
    private Map<Long, SoftReference<AnyObject>> cacheMap = new ConcurrentHashMap<>();

    public AnyObject get(Long key) {
        SoftReference<AnyObject> softReference = cacheMap.get(key);

        if (!cacheMap.containsKey(key)) {
            return null;
        } else {
            AnyObject result = softReference.get();
            return result;
        }

    }

    public AnyObject put(Long key, AnyObject value) {

        if (cacheMap.containsKey(key)) {
            SoftReference<AnyObject> resultSoftReference = cacheMap.get(key);
            AnyObject result = resultSoftReference.get();
            resultSoftReference.clear();
            SoftReference<AnyObject> softReference = cacheMap.put(key, new SoftReference<>(value));
            return result;
        } else {
            SoftReference<AnyObject> softReference = cacheMap.put(key, new SoftReference<>(value));
            return null;
        }
    }

    public AnyObject remove(Long key) {

        if (cacheMap.containsKey(key)) {
            SoftReference<AnyObject> resultSoftObject = cacheMap.get(key);
            AnyObject result = resultSoftObject.get();
            resultSoftObject.clear();
            return result;
        } else {
            return null;
        }

    }
}