package com.codegym.task.task40.task4009;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* 
Buon Compleanno!

*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getWeekdayOfBirthday("11.12.2015", "2016"));
    }

    public static String getWeekdayOfBirthday(String birthday, String year) {

        DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");

        Date date = null;
        try {
            date = formatter.parse(birthday);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        Year yearAsYear = Year.parse(year);
        int monthAsInt = cal.get(Calendar.MONTH) + 1;
        int dayAsInt = cal.get(Calendar.DAY_OF_MONTH);

        String dateToParse = dayAsInt + "." + monthAsInt + "." + yearAsYear;
        DateTimeFormatter formatterDateType = DateTimeFormatter.ofPattern("d.M.uuuu");

        String localDate = LocalDate
                .parse(dateToParse, formatterDateType)
                .getDayOfWeek()
                .getDisplayName(TextStyle.FULL, Locale.ITALIAN);


        return localDate;
    }
}