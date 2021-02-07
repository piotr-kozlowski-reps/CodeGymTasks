package com.codegym.task.task31.task3101;

/* 
Iterating through a file tree

*/


//2. For each file in the path directory and in all of its subdirectories, do the following:
//For each file whose size in bytes is NOT greater than 50, do the following:
//2.1. Sort them by file name in ascending order. Don't include the path when sorting.
//2.2. Rename resultFileAbsolutePath to "allFilesContent.txt" (use the FileUtils.renameFile method and FileUtils.isExist if necessary).
//2.3. Sequentially write the contents of each file from step 2.1 to allFilesContent.txt. After the body of each file, write "\n".
//All files have the TXT extension.
//Use "/" as the path separator.
//
//
//Requirements:
//1. The file passed as the second argument to main must be renamed to allFilesContent.txt.
//2. You need to create a stream to write to the renamed file.
//3. The contents of every file that is 50 bytes or smaller must be sorted by file name and written to the allFilesContent.txt file.
//4. The output stream to the file must be closed.
//5. Don't use static variables.

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution {

    private List<File> filesMeetingCriteriaList = new ArrayList<>();


    public static void main(String[] args) {

        File path = new File(args[0]);
        File resultFileAbsolutePath = new File(args[1]);


        //renameFile
        String destinationString = resultFileAbsolutePath.getParent() + "/allFilesContent.txt";
        File destinationFile = new File(destinationString);

        if (!FileUtils.isExist(destinationFile)) {
            FileUtils.renameFile(resultFileAbsolutePath, destinationFile);
        } else {
            FileUtils.deleteFile(destinationFile);
            FileUtils.renameFile(resultFileAbsolutePath, destinationFile);
        }


        Solution solution = new Solution();
        solution.makeFileList(path);
        solution.sortFilesList();



        try (FileOutputStream fileOutputStream = new FileOutputStream(destinationFile)) {

            for (File file : solution.filesMeetingCriteriaList) {

                //read
                FileInputStream fileInputStream = new FileInputStream(file);
                byte[] fileContentByteArray = new byte[(int) file.length()];
                fileInputStream.read(fileContentByteArray);

                //write
                fileOutputStream.write(fileContentByteArray);
                String separator = "\n";
                byte[] separatorInBytes = separator.getBytes();
                fileOutputStream.write(separatorInBytes);

                fileInputStream.close();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }



    }

    private void sortFilesList() {
        Collections.sort(this.filesMeetingCriteriaList, new Comparator<File>() {         // sort list
            @Override
            public int compare(File o1, File o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
    }

    private void makeFileList(File path) {

        for (File file : path.listFiles()) {

            if (file.isDirectory()) makeFileList(file);
            else if (file.isFile()) {

                long sizeOfFile = file.length();
                if (sizeOfFile <= 50) filesMeetingCriteriaList.add(file);

            }

        }

    }
}
