package com.codegym.task.task20.task2022;

import java.io.*;

/* 
Overriding serialization in a thread

*/

public class Solution implements Serializable, AutoCloseable, Runnable {
    transient private FileOutputStream stream;
    private Thread thread;
    private String fileName;

    public Solution(String fileName) throws FileNotFoundException {
        this.stream = new FileOutputStream(fileName);
        this.fileName = fileName;
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
//        out.close();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        //4. In the readObject(ObjectInputStream in) method, the stream field must be initialized with
        // a new FileOutputStream object using the arguments (fileName, true).
        in.defaultReadObject();
        stream = new FileOutputStream(fileName, true);
//        in.close();
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    @Override
    public void run() {
        try{
            synchronized (this){
                FileOutputStream fileOutputStream = new FileOutputStream(fileName);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(this);

                fileOutputStream.close();
                objectOutputStream.close();
            }

        } catch (IOException e){}



    }

    public void start(){
        thread = new Thread();
        thread.start();
    }



    public static void main(String[] args) throws Exception{
/*


        //1) create an instance of the Solution class
        Solution solutionSourceObj = new Solution(fileName);

        //Overriding serialization in a thread
        solutionSourceObj.start();

        //2) write data to it (writeObject) -> in run()
        //3) serialize the Solution class (writeObject(ObjectOutputStream out)) -> in run()

        //4) deserialize, get a new object
        Solution solutionSerializedObj = null;
        try{
            FileInputStream fileInputStream = new FileInputStream(fileName);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            solutionSerializedObj = (Solution) objectInputStream.readObject();

            fileInputStream.close();
            objectInputStream.close();
        } catch (IOException e){}


        System.out.println(solutionSourceObj);
        System.out.println(solutionSerializedObj);
*/

    }
}


//Serializing/deserializing the Solution class doesn't work.
//Fix the bugs without changing method or class signatures.
//The main method is not tested.
//
//Write the verification code yourself in the main method:




//5) write data to the new object (writeObject)
//6) verify that the file contains the data from Items 2 and 5
//
//