package com.codegym.task.task31.task3105;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Adding a file to an archive

*/

public class Solution {
    public static void main(String[] args) throws IOException {
        List<Content> entries = getContents(args[1]);

        FileOutputStream zipFile = new FileOutputStream(args[1]);
        ZipOutputStream zip = new ZipOutputStream(zipFile);

        File file = new File(args[0]);
        zip.putNextEntry(new ZipEntry("new/" + file.getName()));
        Files.copy(file.toPath(), zip);

        for (Content content : entries) {
            if (!content.getFileName().equals("new/" + file.getName())) {
                content.saveToZip(zip);
            }
        }
        zip.close();
    }

    private static List<Content> getContents(String arg) throws IOException{
        List<Content> entries = new ArrayList<>();

        try (ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(arg))) {

            ZipEntry currentEntry;
            byte[] buffer = new byte[1024];

            while ((currentEntry = zipInputStream.getNextEntry()) != null) {

                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                int lenght = 0;
                while ((lenght = zipInputStream.read(buffer)) > 0) {
                    byteArrayOutputStream.write(buffer, 0, lenght);
                }

                entries.add(new Content(currentEntry.getName(), byteArrayOutputStream.toByteArray()));

            }
        }

        return entries;
    }

    static class Content {

        String fileName;
        byte[] body;

        public Content(String fileName, byte[] body) {
            this.fileName = fileName;
            this.body = body;
        }

        public String getFileName() {
            return fileName;
        }

        public void saveToZip(ZipOutputStream zip) throws IOException{
            ZipEntry zipEntry = new ZipEntry(fileName);
            zip.putNextEntry(zipEntry);
            zip.write(body);
            zip.closeEntry();

        }
    }


}