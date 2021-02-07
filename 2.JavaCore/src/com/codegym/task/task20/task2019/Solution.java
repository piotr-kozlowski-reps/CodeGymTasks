package com.codegym.task.task20.task2019;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Correct the mistake. Serialization

*/


//Correct the mistake. Serialization
//After deserializing a Solution object, map m was discovered to have no data :(
//
//Fix 1 bug.
//
//
//Requirements:
//1. The Solution class should not have a void Solution method without parameters.
//2. The Solution class should have a no-argument constructor.
//3. The Solution class should have a size method without parameters.
//4. The Solution class's size method must return an int.


public class Solution implements Serializable {

    public static void main(String args[]) throws Exception {
        FileOutputStream fileOutput = new FileOutputStream("your.file.name");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutput);

        Solution solution = new Solution();
        outputStream.writeObject(solution);

        fileOutput.close();
        outputStream.close();

        // Loading
        FileInputStream fiStream = new FileInputStream("your.file.name");
        ObjectInputStream objectStream = new ObjectInputStream(fiStream);

        Solution loadedObject = (Solution) objectStream.readObject();

        fiStream.close();
        objectStream.close();

        // Attention!!
        System.out.println(loadedObject.size());
    }

    private Map<String, String> m = new HashMap<>();

    public Map<String, String> getMap() {
        return m;
    }

    public Solution() {
        m.put("Mickey", "Mouse");
        m.put("Mickey", "Mantle");
    }

    public int size() {
        return m.size();
    }
}
