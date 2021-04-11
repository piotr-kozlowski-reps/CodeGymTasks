package com.codegym.task.task40.task4007;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Working with Java 8's DateTime API

*/

public class Solution {
    public static void main(String[] args) {
        printDate("21.4.2014 15:56:45");
        System.out.println();
        printDate("21.4.2014");
        System.out.println();
        printDate("17:33:40");
    }

    public static void printDate(String date) {

        Calendar cal = Calendar.getInstance();
        Date parsedDate = null;

        Pattern pattern1 = Pattern.compile("^\\d{1,2}\\.\\d{1,2}\\.\\d{4} \\d{1,2}:\\d{1,2}:\\d{1,2}$"); //21.4.2014 15:56:45
        Pattern pattern2 = Pattern.compile("^\\d{1,2}\\.\\d{1,2}\\.\\d{4}$"); //21.4.2014
        Pattern pattern3 = Pattern.compile("^\\d{1,2}:\\d{1,2}:\\d{1,2}$"); //17:33:40

        Matcher matcher1 = pattern1.matcher(date);
        Matcher matcher2 = pattern2.matcher(date);
        Matcher matcher3 = pattern3.matcher(date);

        if (matcher1.matches()) {

            parsedDate = parseDatePattern1(date);
            cal.setTime(parsedDate);

            System.out.println("Day: " + cal.get(Calendar.DAY_OF_MONTH)); //Day: 21
            int dayOfTheWeek = cal.get(Calendar.DAY_OF_WEEK);
            System.out.println("Day of the week: " + (dayOfTheWeek > 1 ? dayOfTheWeek - 1 : 7)); //Day of the week: 1
            System.out.println("Day of the month: " + cal.get(Calendar.DAY_OF_MONTH)); //Day of the month: 21
            System.out.println("Day of the year: " + cal.get(Calendar.DAY_OF_YEAR)); //Day of the year: 111
            System.out.println("Week of the month: " + cal.get(Calendar.WEEK_OF_MONTH)); //Week of the month: 4
            System.out.println("Week of the year: " + cal.get(Calendar.WEEK_OF_YEAR)); //Week of the year: 17
            System.out.println("Month: " + (cal.get(Calendar.MONTH) + 1)); //Month: 4
            System.out.println("Year: " + cal.get(Calendar.YEAR)); //Year: 2014
            System.out.println("AM or PM: " + cal.getDisplayName(Calendar.AM_PM, Calendar.SHORT, Locale.ENGLISH)); //AM or PM: PM
            System.out.println("Hour: " + cal.get(Calendar.HOUR)); //Hour: 3
            System.out.println("Hour of the day: " + cal.get(Calendar.HOUR_OF_DAY)); //Hour of the day: 15
            System.out.println("Minutes: " + cal.get(Calendar.MINUTE)); //Minutes: 56
            System.out.println("Seconds: " + cal.get(Calendar.SECOND)); //Seconds: 45

        } else if (matcher2.matches()) {

            parsedDate = parseDatePattern2(date);
            cal.setTime(parsedDate);

            System.out.println("Day: " + cal.get(Calendar.DAY_OF_MONTH)); //Day: 21
            int dayOfTheWeek = cal.get(Calendar.DAY_OF_WEEK);
            System.out.println("Day of the week: " + (dayOfTheWeek > 1 ? dayOfTheWeek - 1 : 7)); //Day of the week: 1
            System.out.println("Day of the month: " + cal.get(Calendar.DAY_OF_MONTH)); //Day of the month: 21
            System.out.println("Day of the year: " + cal.get(Calendar.DAY_OF_YEAR)); //Day of the year: 111
            System.out.println("Week of the month: " + cal.get(Calendar.WEEK_OF_MONTH)); //Week of the month: 4
            System.out.println("Week of the year: " + cal.get(Calendar.WEEK_OF_YEAR)); //Week of the year: 17
            System.out.println("Month: " + (cal.get(Calendar.MONTH) + 1)); //Month: 4
            System.out.println("Year: " + cal.get(Calendar.YEAR)); //Year: 2014

        } else if (matcher3.matches()) {

            parsedDate = parseDatePattern3(date);
            cal.setTime(parsedDate);

            System.out.println("AM or PM: " + cal.getDisplayName(Calendar.AM_PM, Calendar.SHORT, Locale.ENGLISH)); //AM or PM: PM
            System.out.println("Hour: " + cal.get(Calendar.HOUR)); //Hour: 3
            System.out.println("Hour of the day: " + cal.get(Calendar.HOUR_OF_DAY)); //Hour of the day: 15
            System.out.println("Minutes: " + cal.get(Calendar.MINUTE)); //Minutes: 56
            System.out.println("Seconds: " + cal.get(Calendar.SECOND)); //Seconds: 45

        }

    }


    private static Date parseDatePattern1(String date) {

        Date parsedDate = null;
        try {
            DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
            parsedDate = formatter.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return parsedDate;
    }
    private static Date parseDatePattern2(String date) {

        Date parsedDate = null;
        try {
            DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy"); //21.4.2014
            parsedDate = formatter.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return parsedDate;
    }
    private static Date parseDatePattern3(String date) {

        Date parsedDate = null;
        try {
            DateFormat formatter = new SimpleDateFormat("HH:mm:ss"); //17:33:40
            parsedDate = formatter.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return parsedDate;
    }

}