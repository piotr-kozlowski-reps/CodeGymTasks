package com.codegym.task.task38.task3804;

public class ExceptionFactory {

    static Throwable returnRequiredException(Enum enumProvided) {

        if (enumProvided == null) return new IllegalArgumentException();

        String enumName = enumProvided.toString();
        String firstLetter = enumName.substring(0, 1).toUpperCase();
        String restOfLetters = enumName.substring(1,enumName.length());
        String result = "";
        restOfLetters = restOfLetters.toLowerCase();
        restOfLetters = restOfLetters.replaceAll("_", " ");
        result = firstLetter + restOfLetters;

        if (enumProvided.getClass().getSimpleName().equals("ApplicationExceptionMessage")) return new Exception(result);
        if (enumProvided.getClass().getSimpleName().equals("DatabaseExceptionMessage")) return new RuntimeException(result);
        if (enumProvided.getClass().getSimpleName().equals("UserExceptionMessage")) return new Error(result);

        return new IllegalArgumentException();

    }


}
