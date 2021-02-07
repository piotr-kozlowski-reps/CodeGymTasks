package com.codegym.task.task20.task2020;

import java.io.PrintStream;
import java.io.Serializable;
import java.util.logging.Logger;

/* 
Serializing people

*/

public class Solution {

    //1. The Person class should support the Serializable interface.
    public static class Person implements Serializable {
        String firstName;
        String lastName;
        transient String fullName;                  //2. The fullName field must be marked with the transient modifier.
        transient final String greeting;            //3. The greetingString field must be marked with the transient modifier.
        String country;
        Sex sex;
        transient PrintStream outputStream;         //4. The outputStream field must be marked with the transient modifier.
        transient Logger logger;                    //5. The logger field must be marked with the transient modifier.

        Person(String firstName, String lastName, String country, Sex sex) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.fullName = String.format("%s, %s", lastName, firstName);
            this.greeting = "Hello, ";
            this.country = country;
            this.sex = sex;
            this.outputStream = System.out;
            this.logger = Logger.getLogger(String.valueOf(Person.class));
        }
    }

    enum Sex {
        MALE,
        FEMALE
    }

    public static void main(String[] args) {

    }
}
