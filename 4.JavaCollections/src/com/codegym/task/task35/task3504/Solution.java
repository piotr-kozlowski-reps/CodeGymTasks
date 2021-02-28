package com.codegym.task.task35.task3504;

import java.util.HashMap;
import java.util.LinkedHashMap;

/* 
Simple generics

*/

public class Solution<T extends HashMap> {
    private HashMap map;

    public Solution(T map) {
        this.map = map;
    }

    public T getMap() {
        return (T) map;
    }

    public static void main(String[] args) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("string", 4);
        Solution solution = new Solution(hashMap);
        HashMap mapFromSolution = solution.getMap();
        System.out.println(mapFromSolution.getClass());


        LinkedHashMap<Solution, Solution> hashMap2 = new LinkedHashMap<>();
        hashMap2.put(solution, solution);
        Solution solution2 = new Solution(hashMap2);
        LinkedHashMap mapFromSolution2 = (LinkedHashMap)solution2.getMap();   // Need to cast  :(
        System.out.println(mapFromSolution2.getClass());
    }
}

//Simple generics
//Parameterize the Solution class so that it can work with all classes that inherit HashMap.
//The getMap method must return an object of the map field's type.
//
//
//Requirements:
//1. The Solution class must have a type parameter that inherits HashMap.
//2. The Solution class must have a map field.
//3. The Solution class must have a getMap method.
//4. The main method must display data on the screen.