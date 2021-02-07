package com.codegym.task.task31.task3107;

/* 
Null object pattern

*/

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Solution {
    private FileData fileData;

    public Solution(String pathToFile) {

        Path filePath = Paths.get(pathToFile);

        try {
            boolean isHidden = Files.isHidden(filePath);
            boolean isExecutable = Files.isExecutable(filePath);
            boolean isDirectory = Files.isDirectory(filePath);
            boolean isWritable = Files.isWritable(filePath);
            this.fileData = new ConcreteFileData(isHidden, isExecutable, isDirectory, isWritable);

        } catch (Exception e) {
            this.fileData = new NullFileData(e);
        }

    }

    public FileData getFileData() {
        return fileData;
    }
}
