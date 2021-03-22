package com.codegym.task.task38.task3806;

/* 
Improvements in Java 7 (try-with-resources)

*/

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;


//Requirements:
//1. There must not be catch blocks in the printFile1 method.
//2. There must not be catch blocks in the printFile2 method.
//3. In the printFile1 method, the FileInputStream must be initialized as a resource in a try block.
//4. In the printFile2 method, the BufferedInputStream must be initialized as a resource in a try block.
//5. In the printFile2 method, the BufferedInputStream must be initialized as a resource in a try block.
//6. There must be only one try block in the printFile2 method.


public class Solution {
    public void printFile1() throws IOException {

        try ( FileInputStream fileInputStream = new FileInputStream("file.txt")){

            int data = fileInputStream.read();
            while (data != -1) {
                System.out.println(data);
                data = fileInputStream.read();
            }
        }
    }

    public void printFile2() throws IOException {


        try (FileInputStream fileInputStream = new FileInputStream("file.txt");
                BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream)){


            int data = bufferedInputStream.read();
            while (data != -1) {
                System.out.println(data);
                data = bufferedInputStream.read();
            }
        }
    }

    public static void main(String[] args) {

    }
}