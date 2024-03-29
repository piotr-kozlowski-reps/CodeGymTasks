package com.codegym.task.task35.task3501;

public class StaticGeneric<T> {
    public static <T> T someStaticMethod(T genericObject) {
        System.out.println(genericObject);
        return genericObject;
    }
}

//Calling a static method
//Modify the GenericStatic class's static method to make it generic.
//An example method call is provided in the main method.
//
//
//Requirements:
//1. The GenericStatic class's someStaticMethod method must be changed as outlined in the task conditions.
//2. The someStaticMethod method must be static.
//3. The someStaticMethod method must be public.
//4. The someStaticMethod method must display data on the screen.