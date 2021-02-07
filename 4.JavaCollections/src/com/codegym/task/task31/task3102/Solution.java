package com.codegym.task.task31.task3102;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* 
Find all the files

*/

public class Solution {
    public static List<String> getFileTree(String root) throws IOException {

        Queue<String> fileTree = new LinkedList<>();
        List<String> result = null;

        try (Stream<Path> walk = Files.walk(Paths.get(root))) {

            result = walk.filter(Files::isRegularFile)
                    .map(x -> x.toString()).collect(Collectors.toList());
        } catch (IOException ignored){}


        return result;

    }

    public static void main(String[] args) throws Exception{

        String root = "c:\\!!programowanie\\cwiczenia_pliki\\pliki34\\";
        List<String> temporaryList = getFileTree(root);
        temporaryList.forEach(System.out::println);


    }
}
