package com.codegym.task.task38.task3812;

/* 
Processing annotations

*/

import java.lang.annotation.Annotation;

public class Solution {
    public static void main(String[] args) {
        printFullyQualifiedNames(Solution.class);
        printFullyQualifiedNames(SomeTest.class);

        printValues(Solution.class);
        printValues(SomeTest.class);
    }

    public static boolean printFullyQualifiedNames(Class c) {

        if (!c.isAnnotationPresent(PrepareMyTest.class)) {
            return false;
        } else {

            PrepareMyTest prepareMyTestFromAnnotation = (PrepareMyTest) c.getAnnotation(PrepareMyTest.class);
            String[] allStringsReadFromAnnotation = prepareMyTestFromAnnotation.fullyQualifiedNames();

            for (String everyString : allStringsReadFromAnnotation) {
                System.out.println(everyString);
            }

            return true;
        }

    }

    public static boolean printValues(Class c) {

        if (!c.isAnnotationPresent(PrepareMyTest.class)){ return false;}
        else {
            PrepareMyTest prepareMyTestGotFromAnnotations = (PrepareMyTest) c.getAnnotation(PrepareMyTest.class);
            Class[] allClasses = prepareMyTestGotFromAnnotations.value();

            for (Class everyClazz : allClasses) {
                System.out.println(everyClazz.getSimpleName());
            }

            return true;
        }


    }
}



