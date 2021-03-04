package com.codegym.task.task36.task3602;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.*;

/* 
Find the class by its description

*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getExpectedClass());
    }

    public static Class getExpectedClass() {

        boolean isIndexOutOfBoundsExceptionThrown = false;
        for (Class everyClazz : Collections.class.getDeclaredClasses()) {

            if (Modifier.isPrivate(everyClazz.getModifiers())
                    && Modifier.isStatic(everyClazz.getModifiers())
                    && List.class.isAssignableFrom(everyClazz)) {

                try {
                    Constructor constructor = everyClazz.getDeclaredConstructor();
                    constructor.setAccessible(true);
                    List listToBeChecked = (List) constructor.newInstance();
                    listToBeChecked.get(0);
                } catch (NoSuchMethodException e) {
                } catch (InstantiationException e) {
                } catch (IllegalAccessException e) {
                } catch (InvocationTargetException e) {
                } catch (IndexOutOfBoundsException e) {
                    isIndexOutOfBoundsExceptionThrown = true;
                }

                if (isIndexOutOfBoundsExceptionThrown) return everyClazz;

            }

        }

        return null;
    }

}