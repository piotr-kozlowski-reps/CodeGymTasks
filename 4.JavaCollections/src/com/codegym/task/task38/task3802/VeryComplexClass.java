package com.codegym.task.task38.task3802;

/* 
Checked exceptions

*/

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;

public class VeryComplexClass {
    public void veryComplexMethod() throws Exception {
        File file = new File("");
        FileReader fileReader = new FileReader(file);
        System.out.println(fileReader);
    }

    public static void main(String[] args) {

    }
}
