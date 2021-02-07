package com.codegym.task.task31.task3109;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/* 
Reading config files

*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Properties properties = solution.getProperties("4.JavaCollections/src/com/codegym/task/task31/task3109/properties.xml");
        properties.list(System.out);

        properties = solution.getProperties("4.JavaCollections/src/com/codegym/task/task31/task3109/properties.txt");
        properties.list(System.out);

        properties = solution.getProperties("4.JavaCollections/src/com/codegym/task/task31/task3109/notExists");
        properties.list(System.out);
    }

    public Properties getProperties(String fileName) {

        boolean isXML = fileName.endsWith("xml");
        Properties properties = null;

        try(FileInputStream fileInputStream = new FileInputStream(fileName)) {

            properties = new Properties();

            if (isXML) {
                properties.loadFromXML(fileInputStream);
            } else {
                properties.load(fileInputStream);
            }


        } catch (Exception ignored){
            properties = new Properties();
            return properties;
        }



        return properties;
    }
}
