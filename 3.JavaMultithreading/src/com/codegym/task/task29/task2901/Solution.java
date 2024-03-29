package com.codegym.task.task29.task2901;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;

/* 
Refactoring for the naming and code convention

*/

public class Solution {
    public static final String DEFAULT_FILE_NAME = "C:/tmp/strange_file_name.tmp";

    private final String localFileName;
    private List<String> contentAslines;
    private boolean isFileLoaded;

    public Solution(String firstFileName) {
        localFileName = firstFileName == null ? DEFAULT_FILE_NAME : firstFileName;
    }

    public static void main(String[] args) throws FileNotFoundException {
        String fileName = Solution.class.getResource("Solution.java").getPath();

        Solution solution = new Solution(fileName);
        solution.downloadFileContent();
        if (solution.isFileLoaded()) {
            System.out.println(solution.hasExpectedLine("public class Solution {"));   // Expected true
            System.out.println(solution.hasExpectedLine(" public class Solution {"));  // Expected false
        }
    }

    public boolean isFileLoaded() {
        return isFileLoaded;
    }

    public void downloadFileContent() {
        try {
            contentAslines = Files.readAllLines((new File(localFileName)).toPath(), Charset.defaultCharset());
            isFileLoaded = true;
        } catch (IOException e) {
            System.out.println("Unsuccessful. What a surprise!");
        }
    }

    public boolean hasExpectedLine(String expectedLine) {
        return contentAslines.contains(expectedLine);
    }
}
