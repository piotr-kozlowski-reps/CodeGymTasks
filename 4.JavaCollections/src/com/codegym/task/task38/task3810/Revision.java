package com.codegym.task.task38.task3810;

import java.util.List;

public @interface Revision {

    int revision();
    Date date();
    String comment() default "";
    Author[] authors() default {};

}