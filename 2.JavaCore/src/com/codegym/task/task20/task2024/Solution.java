package com.codegym.task.task20.task2024;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

/* 
Introducing graphs

*/

//ntroducing graphs
//Read the additional materials on serialization of graphs.
//The Solution class has a directed planar graph containing cycles and loops.
//
//For example, https://photos.app.goo.gl/fgJjYtA2atEP6AKM7
//
//Serialize Solution.
//The direction of all of the edges must remain the same.
//
//



public class Solution implements Serializable {
    int node;
    List<Solution> edges = new LinkedList<>();

/*    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject();
        oos.writeObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException{
        in.defaultReadObject();
        in.readObject();
    }*/

    public static void main(String[] args) throws Exception{

        FileOutputStream fileOutputStream = new FileOutputStream("ser.ser");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        FileInputStream fileInputStream = new FileInputStream("ser.ser");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        Solution solution = new Solution();

        objectOutputStream.writeObject(solution);
        fileOutputStream.close();
        objectOutputStream.close();

        Solution newSolution = (Solution) objectInputStream.readObject();

        fileInputStream.close();
        objectInputStream.close();


    }
}
