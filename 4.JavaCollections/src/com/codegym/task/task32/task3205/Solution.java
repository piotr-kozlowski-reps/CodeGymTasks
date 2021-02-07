package com.codegym.task.task32.task3205;

/* 
Creating a proxy object

*/

import java.lang.reflect.Proxy;

public class Solution {
    public static void main(String[] args) {
        SomeInterfaceWithMethods obj = getProxy();
        obj.stringMethodWithoutArgs();
        obj.voidMethodWithIntArg(1);

        /* Expected output:
        stringMethodWithoutArgs in
        inside stringMethodWithoutArgs
        stringMethodWithoutArgs out
        voidMethodWithIntArg in
        inside voidMethodWithIntArg
        inside voidMethodWithoutArgs
        voidMethodWithIntArg out
        */
    }

    public static SomeInterfaceWithMethods getProxy() {

        SomeInterfaceWithMethods originalSomeInterfaceWithMethods = new SomeInterfaceWithMethodsImpl();
        ClassLoader classLoader = originalSomeInterfaceWithMethods.getClass().getClassLoader();
        Class<?>[] interfaces = originalSomeInterfaceWithMethods.getClass().getInterfaces();
        SomeInterfaceWithMethods proxySomeInterfaceWithMethods = (SomeInterfaceWithMethods) Proxy.newProxyInstance(classLoader, interfaces, new CustomInvocationHandler(originalSomeInterfaceWithMethods));
        return proxySomeInterfaceWithMethods;
    }
}
