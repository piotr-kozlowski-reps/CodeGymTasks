package com.codegym.task.task20.task2017;

import java.io.*;

/* 
Deserialization

*/

public class Solution {
    public A getOriginalObject(ObjectInputStream objectStream) {

        try {
            Object obiekt = objectStream.readObject();

            if (obiekt instanceof A) {
                A zwroconyA = (A) obiekt;
                return zwroconyA;
            } else {
                return null;
            }


            //6. The getOriginalObject method must return null if an exception is thrown when trying to deserialize.
            //5. The getOriginalObject method must return null if an A object is not received during deserialization attempts.
        } catch (InvalidClassException e){
            e.printStackTrace();
            return null;
        } catch (StreamCorruptedException e){
            e.printStackTrace();
            return null;
        } catch (ClassNotFoundException e){
            e.printStackTrace();
            return null;
        } catch (OptionalDataException e){
            e.printStackTrace();
            return null;
        } catch (IOException e){
            e.printStackTrace();
            return null;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

    //2. The A class should support the Serializable interface.
    public class A implements Serializable {
    }

    public class B extends A {
        public B() {
            System.out.println("inside B");
        }
    }

    public static void main(String[] args) {

    }
}
