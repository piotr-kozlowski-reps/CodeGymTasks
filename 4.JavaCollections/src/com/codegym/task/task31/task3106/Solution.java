package com.codegym.task.task31.task3106;

/* 
Unzipping a file

*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Solution {
    public static void main(String[] args) throws IOException {

        File result = new File(args[0]);
        if (!result.exists()) {
            result.createNewFile();
        }

        List<FileInputStream> fileInputStreams = new ArrayList<>();

        List<String> fileNames = new ArrayList<>();
        fileNames.addAll(Arrays.asList(args).subList(1, args.length));
        Collections.sort(fileNames);

        for (String name : fileNames) {
            fileInputStreams.add(new FileInputStream(name));
        }

        try (ZipInputStream zipInputStream = new ZipInputStream(new SequenceInputStream(Collections.enumeration(fileInputStreams)))) {

            while (true) {
                ZipEntry zipEntry = zipInputStream.getNextEntry();
                if (zipEntry == null) break;

                try (OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(result))){
                    final int bufferSize = 1024;
                    byte[] buffer = new byte[bufferSize];
                    for (int readBytes; (readBytes = zipInputStream.read(buffer, 0, bufferSize)) > -1;) {
                        outputStream.write(buffer, 0, readBytes);
                    }
                    outputStream.flush();
                }
            }
        }
    }
}
