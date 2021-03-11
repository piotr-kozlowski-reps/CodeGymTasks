package com.codegym.task.task36.task3606;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/* 
Mastering ClassLoader and Reflection

*/

public class Solution {
    private List<Class> hiddenClasses = new ArrayList<>();
    private String packageName;

    public Solution(String packageName) {
        this.packageName = packageName;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Solution solution = new Solution(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "com/codegym/task/task36/task3606/data/second");
        solution.scanFileSystem();
        System.out.println(solution.getHiddenClassObjectByKey("secondhiddenclassimpl"));
        System.out.println(solution.getHiddenClassObjectByKey("firsthiddenclassimpl"));
        System.out.println(solution.getHiddenClassObjectByKey("packa"));
    }

    public void scanFileSystem() throws ClassNotFoundException {

        File[] files = new File(packageName).listFiles();
        ClassLoaderFromPath classLoaderFromPath = new ClassLoaderFromPath();

        for (File file : files) {
            Class<?> clazz = classLoaderFromPath.load(file.toPath());
            if (clazz != null) hiddenClasses.add(clazz);
        }

    }

    public HiddenClass getHiddenClassObjectByKey(String key) {

        for (Class clazz : hiddenClasses) {

            String className = clazz.getSimpleName();
            String keyToLowerCase = key.toLowerCase();
            if (className.toLowerCase().startsWith(keyToLowerCase)) {

                try {
                    Constructor[] constructors = clazz.getDeclaredConstructors();
                    for (Constructor constructor : constructors) {
                        if (constructor.getParameterTypes().length == 0) {
                            constructor.setAccessible(true);
                            return (HiddenClass) constructor.newInstance(null);
                        }
                    }

                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }

            }
        }

        return null;
    }

    public static class ClassLoaderFromPath extends ClassLoader{

        public Class<?> load (Path path) {


            try {

                if (path.getFileName().toString().lastIndexOf(".class") == -1) {
                    return null;
                }

                byte[] bytesFromLoadedClass = Files.readAllBytes(path);
                return defineClass(null, bytesFromLoadedClass, 0, bytesFromLoadedClass.length);

            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;

        }

    }


}


//rozwiazanie od nich:
/*
//package com.codegym.task.task36.task3606;
//
//import java.io.File;
//import java.lang.reflect.Constructor;
//import java.lang.reflect.InvocationTargetException;
//import java.util.ArrayList;
//import java.util.List;
//
///*
//Mastering ClassLoader and Reflection
//
//*/
//
//public class Solution {
//    private List<Class> hiddenClasses = new ArrayList<>();
//    private String packageName;
//    public Solution(String packageName) {
//        this.packageName = packageName;
//    }
//
//    public static void main(String[] args) throws ClassNotFoundException {
//        Solution solution = new Solution(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "com/codegym/task/task36/task3606/data/second");
//        solution.scanFileSystem();
//        System.out.println(solution.getHiddenClassObjectByKey("secondhiddenclassimpl"));
//        System.out.println(solution.getHiddenClassObjectByKey("firsthiddenclassimpl"));
//        System.out.println(solution.getHiddenClassObjectByKey("packa"));
//    }
//
//    public void scanFileSystem() throws ClassNotFoundException {
//        File dir = new File(packageName);
//        ClassLoader classLoader = Solution.class.getClassLoader();
//        for (String fileName : dir.list()) {
//            if(fileName.endsWith(".class")){
//                String className = packageName.replaceAll("[/\\\\]", ".").substring(packageName.indexOf("com")) + "." + fileName.substring(0, fileName.length() - 6);
//                Class<?> aClass = classLoader.loadClass(className);
//                hiddenClasses.add(aClass);
//            }
//        }
//    }
//
//    public HiddenClass getHiddenClassObjectByKey(String key) {
//        String lowerKey = key.toLowerCase();
//        try {
//            Class resultClass = null;
//            for (Class aClass : hiddenClasses) {
//                if (aClass.getSimpleName().toLowerCase().startsWith(lowerKey)) {
//                    resultClass = aClass;
//                    Constructor<?> declaredConstructor = resultClass.getDeclaredConstructor();
//                    declaredConstructor.setAccessible(true);
//                    return (HiddenClass) declaredConstructor.newInstance();
//                }
//            }
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//}
//
//
//*/