package com.codegym.task.task35.task3509;

import java.util.*;


/* 
Collections & Generics

*/

public class Solution {

    public static void main(String[] args) {
    }

    public static <T> ArrayList<T> newArrayList(T... elements) {

        ArrayList<T> resultArrayList = new ArrayList<>();

        for (T element : elements) {
            resultArrayList.add(element);
        }

        return resultArrayList;
    }

    public static <T> HashSet<T> newHashSet(T... elements) {

        int elementsCount = elements.length;
        HashSet<T> resultHashSet = new HashSet<>(elementsCount);

        for (T element : elements) {
            resultHashSet.add(element);
        }

        return resultHashSet;
    }

    public static <K, V> HashMap<K, V> newHashMap(List<? extends K> keys, List<? extends V> values) {

        int keysCount = keys.size();
        int valuesCount = values.size();

        if (keysCount == valuesCount) {

            HashMap<K, V> resultHashMap = new HashMap<>();
            for (int i = 0; i < keysCount; i++) {
                resultHashMap.put(keys.get(i), values.get(i));
            }

            return resultHashMap;

        } else {
            throw new IllegalArgumentException();
        }

    }
}
