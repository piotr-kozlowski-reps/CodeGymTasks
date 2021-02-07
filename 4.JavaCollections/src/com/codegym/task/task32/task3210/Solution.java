package com.codegym.task.task32.task3210;

import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Using RandomAccessFile

*/

public class Solution {
    public static void main(String... args) throws Exception{


        if (args.length < 2){
            System.out.println("bad args");
            return;
        }

        String fileName = args[0];
        int number = Integer.parseInt(args[1]);
        String textToCompare = args[2];

        RandomAccessFile randomAccessFile = new RandomAccessFile(fileName, "rw");

        randomAccessFile.seek(number);
        byte[] readTextAsBytes = new byte[textToCompare.length()];
        randomAccessFile.read(readTextAsBytes, 0, textToCompare.length());

        boolean isEqual = false;

        if (new String(readTextAsBytes).equals(textToCompare)) isEqual = true;

        randomAccessFile.seek(randomAccessFile.length());

        byte[] byteArrayTrue = new String("true").getBytes();
        byte[] byteArrayFalse = new String("false").getBytes();

        if (isEqual) randomAccessFile.write(byteArrayTrue);
        else randomAccessFile.write(byteArrayFalse);

        randomAccessFile.close();
    }
}
