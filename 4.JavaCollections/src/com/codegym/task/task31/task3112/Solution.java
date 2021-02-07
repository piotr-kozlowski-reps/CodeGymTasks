package com.codegym.task.task31.task3112;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/* 
File downloader

*/

public class Solution {

    public static void main(String[] args) throws IOException {
        Path passwords = downloadFile("https://codegym.cc/testdata/secretPasswords.txt", Paths.get("c:\\!!programowanie\\cwiczenia_pliki\\pliki35\\"));

        for (String line : Files.readAllLines(passwords)) {
            System.out.println(line);
        }
    }

    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {

        URL url = new URL(urlString);
        Path tempFile = Files.createTempFile("temps_", ".tmp");
//        BufferedInputStream bufferedInputStream = new BufferedInputStream(url.openStream());

//        Files.copy(bufferedInputStream, tempFile, StandardCopyOption.REPLACE_EXISTING);
        Files.copy(url.openStream(), tempFile, StandardCopyOption.REPLACE_EXISTING);

        String downloadedFileName = new File(url.getFile().toString()).getName();
        Path targetPath = Paths.get(downloadDirectory.toString(),downloadedFileName);

        Files.move(tempFile, targetPath, StandardCopyOption.REPLACE_EXISTING);

//        bufferedInputStream.close();
        return targetPath;
    }
}