package com.codegym.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/* 
What's in the folder?

*/

public class Solution {

    public static void main(String[] args) throws IOException {

        //1. The main method must read the folder path from the console.
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String folderPathString = bufferedReader.readLine();
        bufferedReader.close();

        //2. If the entered path isn't a directory, you need to display "[full path] is not a folder" and exit the program.
        Path folderPath = Paths.get(folderPathString);
        if (!Files.isDirectory(folderPath)) {
            System.out.println(String.format("%s is not a folder", folderPath.toString()));
            return;
        }

        //4. The following information must be displayed on the console: "Total folders: [the number of folders in the directory and subdirectories]".
        //5. The following information must be displayed on the console: "Total files: [the number of files in the directory and subdirectories]".
        //6. The following information must be displayed on the console: "Total size: [the total number of bytes stored in the directory]".
        SearchFileVisitor searchFileVisitor = new SearchFileVisitor();
        Files.walkFileTree(folderPath, searchFileVisitor);

        System.out.println(String.format("Total folders: %d", searchFileVisitor.getTotalFolders()));
        System.out.println(String.format("Total files: %d", searchFileVisitor.getTotalFiles()));
        System.out.println(String.format("Total size: %d", (int) searchFileVisitor.getTotalSize()));

    }

    public static class SearchFileVisitor extends SimpleFileVisitor<Path> {

        //fields
        int totalFolders = -1;
        int totalFiles;
        long totalSize;

        //set/get
        public int getTotalFolders() {
            return totalFolders;
        }
        public int getTotalFiles() {
            return totalFiles;
        }
        public long getTotalSize() {
            return totalSize;
        }

        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            totalFolders++;
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

            byte[] content = Files.readAllBytes(file);

            totalFiles++;
            totalSize += content.length;

            return FileVisitResult.CONTINUE;
        }
    }

}



