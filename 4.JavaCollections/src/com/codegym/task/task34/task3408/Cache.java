package com.codegym.task.task34.task3408;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.WeakHashMap;

public class Cache<K, V> {

    private Map<K, V> cache = new WeakHashMap<>();


    public V getByKey(K key, Class<V> clazz) throws Exception {
        if (cache.containsKey(key)) {
            return cache.get(key);
        } else {

            Constructor constructor = clazz.getDeclaredConstructor(key.getClass());
            V value = (V) constructor.newInstance(key);
            cache.put(key, value);
            return value;
        }

    }

    public boolean put(V obj) throws Exception{

        Method method = null;
        try {
            method = obj.getClass().getDeclaredMethod("getKey", null);
            method.setAccessible(true);
            cache.put((K) method.invoke(obj, null), obj);
            return true;

        } catch (Exception ignored) {
            return false;
        }




//        Class temporaryClass = obj.getClass();
//        Method method = temporaryClass.getDeclaredMethod("getKey", null);
//        method.setAccessible(true);
//        K temporaryKey = (K) method.invoke(obj, null);
//        cache.put(temporaryKey, obj);
//
//        if (cache.containsKey(temporaryKey)) {
//            return true;
//        } else {
//            return false;
//        }

/*        V valueToBeChecked = cache.get(temporaryKey);
        if (valueToBeChecked == null) {
            return false;
        } else {
            return true;
        }*/

    }

    public int size() {
        return cache.size();
    }
}