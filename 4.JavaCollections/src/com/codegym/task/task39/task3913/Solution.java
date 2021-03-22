package com.codegym.task.task39.task3913;

import java.nio.file.Paths;
import java.util.Date;

public class Solution {
    public static void main(String[] args) {
        LogParser logParser = new LogParser(Paths.get("C:\\!!programowanie\\CodeGymTasks2\\CodeGymTasks3\\CodeGymTasks\\4.JavaCollections\\src\\com\\codegym\\task\\task39\\task3913\\logs\\"));
        System.out.println(logParser.getNumberOfUniqueIPs(null, new Date()));
        System.out.println(logParser.execute("get ip for user = \"Pete Tyson\""));

    }



}