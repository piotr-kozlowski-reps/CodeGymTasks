package com.codegym.task.task40.task4012;

import java.time.*;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.ChronoLocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Locale;

/* 
Useful methods of the DateTime API

*/

public class Solution {
    public static void main(String[] args) {

//        LocalDate actualDate = LocalDate.now();
//        LocalDate formarDate = LocalDate.of(2016, 2, 14);
//        LocalDateTime localDateTime = LocalDateTime.of(2016, 12, 12, 16, 12);
//        LocalDateTime localDateTimeAfter = LocalDateTime.of(2030, 12, 12, 16, 12);
//
//        System.out.println("true: " + isLeap(formarDate));
//        System.out.println("true: " + isBefore(localDateTime));
//        System.out.println("false: " + isBefore(localDateTimeAfter));


    }

    public static boolean isLeap(LocalDate date) {
        return date.isLeapYear();
    }

    public static boolean isBefore(LocalDateTime dateTime) {
        return dateTime.isBefore(LocalDateTime.now());
    }

    public static LocalTime addTime(LocalTime time, int n, ChronoUnit chronoUnit) {
        return time.plus(n, chronoUnit);
    }

    public static Period getPeriodBetween(LocalDate firstDate, LocalDate secondDate) {

        if (firstDate.isBefore(secondDate)) {
            return Period.between(firstDate, secondDate);
        } else {
            return Period.between(secondDate, firstDate);
        }

    }
}