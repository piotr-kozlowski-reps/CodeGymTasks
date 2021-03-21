package com.codegym.task.task39.task3913;

import java.nio.file.Paths;
import java.util.Date;

public class Solution {
    public static void main(String[] args) {
        LogParser logParser = new LogParser(Paths.get("C:\\!!programowanie\\CodeGymTasks2\\CodeGymTasks3\\CodeGymTasks\\4.JavaCollections\\src\\com\\codegym\\task\\task39\\task3913\\logs\\"));
        System.out.println(logParser.getNumberOfUniqueIPs(null, new Date()));
        System.out.println(logParser.getAllAttemptedTasksAndNumberOfAttempts(null, null));
        System.out.println(logParser.execute("get ip"));
        System.out.println(logParser.execute("get ip for user = \"Pete Tyson\""));
        System.out.println(logParser.execute("get ip for date = \"03.01.2014 03:45:23\""));
        System.out.println(logParser.execute("get ip for event = \"COMPLETE_TASK\""));
        System.out.println(logParser.execute("get ip for status = \"OK\""));
        System.out.println("----------------");
        System.out.println(logParser.execute("get user for ip = \"192.168.100.2\""));
        System.out.println(logParser.execute("get user for date = \"03.01.2014 03:45:23\""));
        System.out.println(logParser.execute("get user for event = \"COMPLETE_TASK\""));
        System.out.println(logParser.execute("get user for status = \"OK\""));
        System.out.println("----------------");


    }
}