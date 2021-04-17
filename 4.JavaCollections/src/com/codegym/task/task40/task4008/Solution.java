package com.codegym.task.task40.task4008;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.Calendar;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.time.temporal.ChronoField.*;

/* 
Working with Java 8's DateTime API

*/

public class Solution {
    public static void main(String[] args) {
        printDate("9.10.2017 5:56:45");
        System.out.println();
        printDate("21.4.2014");
        System.out.println();
        printDate("17:33:40");
    }

    public static void printDate(String date) {

        LocalDate localDate = null;
        LocalTime localTime = null;

        Pattern pattern1 = Pattern.compile("^\\d{1,2}\\.\\d{1,2}\\.\\d{4} \\d{1,2}:\\d{1,2}:\\d{1,2}$"); //21.4.2014 15:56:45
        Pattern pattern2 = Pattern.compile("^\\d{1,2}\\.\\d{1,2}\\.\\d{4}$"); //21.4.2014
        Pattern pattern3 = Pattern.compile("^\\d{1,2}:\\d{1,2}:\\d{1,2}$"); //17:33:40

        Matcher matcher1 = pattern1.matcher(date);
        Matcher matcher2 = pattern2.matcher(date);
        Matcher matcher3 = pattern3.matcher(date);

        if (matcher1.matches()) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.uuuu H:mm:ss"); //21.4.2014 15:56:45
            localDate = LocalDate.parse(date, formatter);
            localTime = LocalTime.parse(date, formatter);
            
            System.out.println("Day: " + localDate.get(DAY_OF_MONTH)); //Day: 9
            System.out.println("Day of the week: " + localDate.getDayOfWeek().getValue()); //Day of the week: ?
            System.out.println("Day of the month: " + localDate.getDayOfMonth()); //Day of the month: 9
            System.out.println("Day of the year: " + localDate.getDayOfYear()); //Day of the year: 282
            System.out.println("Week of the month: " + localDate.format(DateTimeFormatter.ofPattern("W"))); //Week of the month: 3
            System.out.println("Week of the year: " + (localDate.get(ALIGNED_WEEK_OF_YEAR)));//Week of the year: 42
            System.out.println("Month: " + localDate.get(MONTH_OF_YEAR)); //Month: 10
            System.out.println("Year: " + localDate.getYear()); //Year: 2017
            System.out.println("AM or PM: " + localTime.format(DateTimeFormatter.ofPattern("a"))); //AM or PM: PM
            System.out.println("Hour: " + localTime.get(HOUR_OF_AMPM)); //Hour: 5
            System.out.println("Hour of the day: " + localTime.get(HOUR_OF_DAY)); //Hour of the day: 5
            System.out.println("Minutes: " + localTime.get(MINUTE_OF_HOUR));//Minutes: 56
            System.out.println("Seconds: " + localTime.get(SECOND_OF_MINUTE));;//Seconds: 45
        } else if (matcher2.matches()) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.uuuu"); //21.4.2014
            localDate = LocalDate.parse(date, formatter);

            System.out.println("Day: " + localDate.get(DAY_OF_MONTH)); //Day: 21
            System.out.println("Day of the week: " + localDate.getDayOfWeek().getValue()); //Day of the week: 1
            System.out.println("Day of the month: " + localDate.getDayOfMonth()); //Day of the month: 21
            System.out.println("Day of the year: " + localDate.getDayOfYear()); //Day of the year: 111
            System.out.println("Week of the month: " + localDate.format(DateTimeFormatter.ofPattern("W"))); //Week of the month: b
            System.out.println("Week of the year: " + (localDate.get(ALIGNED_WEEK_OF_YEAR))); //Week of the year: 17
            System.out.println("Month: " + localDate.get(MONTH_OF_YEAR)); //Month: 4
            System.out.println("Year: " + localDate.getYear()); //Year: 2014

        } else if (matcher3.matches()) {

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:mm:ss"); //17:33:40
            localTime = LocalTime.parse(date, formatter);

            System.out.println("AM or PM: " + localTime.format(DateTimeFormatter.ofPattern("a"))); //AM or PM: PM
            System.out.println("Hour: " + localTime.get(HOUR_OF_AMPM)); //Hour: 5
            System.out.println("Hour of the day: " + localTime.get(HOUR_OF_DAY)); //Hour of the day: 5
            System.out.println("Minutes: " + localTime.get(MINUTE_OF_HOUR));//Minutes: 56
            System.out.println("Seconds: " + localTime.get(SECOND_OF_MINUTE));;//Seconds: 45

        }

    }
}
