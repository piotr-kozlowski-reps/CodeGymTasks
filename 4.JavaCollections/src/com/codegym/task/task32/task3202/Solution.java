package com.codegym.task.task32.task3202;

import java.io.*;
import java.security.spec.ECField;

/* 
Reading from a stream

*/

public class Solution {
    public static void main(String[] args) throws IOException {
        StringWriter writer = getAllDataFromInputStream(new FileInputStream("testFile.log"));
        System.out.println(writer.toString());
    }

    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException {

        try {
            String lineFromFile = null;
            StringBuilder stringBuilder = new StringBuilder();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));

            while ((lineFromFile = bufferedReader.readLine()) != null) {
                stringBuilder.append(lineFromFile);
            }

            StringWriter stringWriter = new StringWriter();

            if (stringBuilder.length() > 0) stringWriter.write(stringBuilder.toString());
            else {
                stringBuilder.append("");
                stringWriter.write(stringBuilder.toString());
            }

            return stringWriter;

        } catch (Exception e) {
            StringWriter stringWriter = new StringWriter();
            return stringWriter;
        }

    }
}