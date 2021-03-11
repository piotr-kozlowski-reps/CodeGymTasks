package com.codegym.task.task36.task3610;

import java.io.Serializable;
import java.util.*;

public class MyMultiMap<K, V> extends HashMap<K, V> implements Cloneable, Serializable {
    static final long serialVersionUID = 123456789L;
    private HashMap<K, List<V>> map;
    private int repeatCount;

    public MyMultiMap(int repeatCount) {
        this.repeatCount = repeatCount;
        map = new HashMap<>();
    }

    @Override
    public int size() {
        int countOfAllValues = 0;
        for (Map.Entry<K, List<V>> entry : map.entrySet()) {
            countOfAllValues += entry.getValue().size();
        }
        return countOfAllValues;
    }

    @Override
    public V put(K key, V value) {

        V lastValueToReturn = null;
        //If key is already in the map
        if (map.containsKey(key)) {
            List<V> listOfValues = map.get(key);

            //The method must return the value of the last item added using key (but not the value we're currently
            //adding). If key doesn't have any values yet, then return null.
            if (listOfValues.size() != 0) {
                lastValueToReturn = listOfValues.get(listOfValues.size() - 1);
            }

            //if number of values for key is less than repeatCount, then add value to the end of the list in the map object.
            if (listOfValues.size() < repeatCount) {
                listOfValues.add(value);
                map.put(key, listOfValues);

                //If the number of values stored using key equals repeatCount, then remove the element with index zero from
                //the map object's list and add value to the end of the list.
            } else {
                List<V> resultList = new ArrayList<>();
                for (int i = 1; i < repeatCount; i++) {
                    resultList.add(listOfValues.get(i));
                }
                resultList.add(value);
                map.put(key, resultList);
            }

        } else {
            List<V> resultList = new ArrayList<>();
            resultList.add(value);
            map.put(key, resultList);
        }
        return lastValueToReturn;
    }

    @Override
    public V remove(Object key) {

        V valueToBeReturned = null;
        K keyInMap = (K) key;

        if (map.containsKey(keyInMap)) {

            List<V> listOfValues = map.get(keyInMap);

            if (listOfValues.size() == 0) {
                map.remove(keyInMap);
            } else {
                List<V> resultList = new ArrayList<>();
                valueToBeReturned = listOfValues.get(0);
                for (int i = 1; i < listOfValues.size(); i++) {
                    resultList.add(listOfValues.get(i));
                }
                if (resultList.size() > 0) map.put(keyInMap, resultList);
                else map.remove(keyInMap);

            }


            return valueToBeReturned;
        } else {
            return valueToBeReturned;
        }

    }

    @Override
    public Set<K> keySet() {
        Set<K> resultSet = new HashSet<>();

        for (K key : map.keySet()) {
            resultSet.add(key);
        }

        return resultSet;
    }

    @Override
    public Collection<V> values() {
        List<V> resultValuesList = new ArrayList<>();

        for (Map.Entry<K, List<V>> entry : map.entrySet()) {

            for (V value : entry.getValue()) {
                resultValuesList.add(value);
            }

        }

        return resultValuesList;
    }

    @Override
    public boolean containsKey(Object key) {
        K keyToBeChecked = (K) key;
        for (K keyFromMap : map.keySet()) {
            if (keyToBeChecked == keyFromMap) return true;
        }

        return false;
    }

    @Override
    public boolean containsValue(Object value) {

        boolean isContainingValue = false;
        V valueToSeach = (V) value;

        for (Map.Entry<K, List<V>> entry : map.entrySet()) {

            for (V everyValue : entry.getValue()) {
                if (valueToSeach.equals(everyValue)) isContainingValue = true;
            }

        }
        return isContainingValue;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (Map.Entry<K, List<V>> entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            for (V v : entry.getValue()) {
                sb.append(v);
                sb.append(", ");
            }
        }
        String substring = sb.substring(0, sb.length() - 2);
        return substring + "}";
    }
}