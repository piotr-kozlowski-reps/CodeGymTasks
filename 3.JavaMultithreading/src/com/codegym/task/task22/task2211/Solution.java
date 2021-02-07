package com.codegym.task.task22.task2211;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/* 
Changing the encoding

*/

/*
files:
c:\!!programowanie\cwiczenia_pliki\pliki33\pliki33_source.txt
c:\!!programowanie\cwiczenia_pliki\pliki33\pliki33_destination.txt

*/

public class Solution {
    public static void main(String[] args) throws IOException {

        String sourceFile = "";
        String destinationFileString = "";

        try{
            sourceFile = args[0];
            destinationFileString = args[1];
        } catch (Exception ignored){}


        OutputStream outputStream = null;
        try{

            // read
            Path sourceFilePath = Paths.get(sourceFile);
            byte[] allSourceFileBytes = Files.readAllBytes(sourceFilePath);

            // write
            String bytesToStringInUTF_8 = new String(allSourceFileBytes, StandardCharsets.UTF_8);
            byte[] bytesInUTF8 = bytesToStringInUTF_8.getBytes();

            File destinationFile = new File(destinationFileString);
            if (!destinationFile.exists()){
                destinationFile.createNewFile();
            }

            outputStream = new FileOutputStream(destinationFile);
            outputStream.write(bytesInUTF8);
            outputStream.flush();


        } catch (Exception ignored){

        } finally {
            outputStream.close();
        }

    }
}
