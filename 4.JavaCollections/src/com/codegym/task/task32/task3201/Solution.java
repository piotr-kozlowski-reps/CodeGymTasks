package com.codegym.task.task32.task3201;

/* 
Writing to an existing file

*/

import java.io.RandomAccessFile;

public class Solution {
    public static void main(String... args) throws Exception {

        if (args.length < 2){
            System.out.println("bad args");
            return;
        }

        String fileName = args[0];
        int number = Integer.parseInt(args[1]);
        String textToBeWritten = args[2];


        RandomAccessFile randomAccessFile = new RandomAccessFile(fileName, "rw");

        long fileLenght = randomAccessFile.length();
        long textLenght = textToBeWritten.length();

        if ((fileLenght - number) < textLenght) randomAccessFile.seek(fileLenght);
        else randomAccessFile.seek(number);

        randomAccessFile.seek(number);

        byte[] byteArrayFromString = textToBeWritten.getBytes();
        randomAccessFile.write(byteArrayFromString);

        randomAccessFile.close();
    }
}
