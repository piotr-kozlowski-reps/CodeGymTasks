package com.codegym.task.task32.task3205;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CustomInvocationHandler implements InvocationHandler {

    //fields
    private SomeInterfaceWithMethods someInterfaceWithMethods;

    //constr
    public CustomInvocationHandler(SomeInterfaceWithMethods someInterfaceWithMethods) {
        this.someInterfaceWithMethods = someInterfaceWithMethods;
    }


    //
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method.getName() + " in");
        Object result = method.invoke(someInterfaceWithMethods, args);
        System.out.println(method.getName() + " out");
        return result;
    }


}