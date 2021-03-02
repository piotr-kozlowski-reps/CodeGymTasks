package com.codegym.task.task35.task3507;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/* 
What is ClassLoader?

*/

public class Solution {
    public static void main(String[] args) {
        Set<? extends Animal> allAnimals = getAllAnimals(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + Solution.class.getPackage().getName().replaceAll("[.]", "/") + "/data");
        System.out.println(allAnimals);
    }

    public static Set<? extends Animal> getAllAnimals(String pathToAnimals) {

        Set<Animal> resultSet = new HashSet<>();

        File[] allFilesFromDirectory = new File(pathToAnimals).listFiles();

        for (File file : allFilesFromDirectory) {

            if (file.isFile() && file.getName().endsWith(".class")) {

 //               String packageName = Solution.class.getPackageName() + ".data";

                Solution solution = new Solution();
                Package pack = solution.getClass().getPackage();
                String packageName = pack.getName() + ".data";
                Class clazz = new ClassFromPath().load(file.toPath(), packageName);

                boolean isDefaultPublicConstructor = false;
                Constructor[] allcontructors = clazz.getDeclaredConstructors();
                for (Constructor constructor : allcontructors) {
                    Class[] parameterTypes = constructor.getParameterTypes();
                    if (constructor.toString().startsWith("public")  && parameterTypes.length == 0) {
                        isDefaultPublicConstructor = true;
                    }
                }

                boolean isImplementsAnimal = false;
                Class[] allInterfaces = clazz.getInterfaces();
                for (Class interfaceFromClass : allInterfaces) {
                    if (interfaceFromClass.toString().endsWith("Animal")) {
                        isImplementsAnimal = true;
                    }
                }




                if (isDefaultPublicConstructor && isImplementsAnimal) {

                    try {

                        resultSet.add((Animal) clazz.newInstance());
                        // resultSet.add((Animal) clazz.getConstructor().newInstance());

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }



            }

        }




        return resultSet;
    }

    public static class ClassFromPath extends ClassLoader {

        public Class<?> load(Path path, String packageName) {

            try {
                String className = packageName + "." + path.getFileName().toString().replace(".class", "");
                byte[] bytes = Files.readAllBytes(path);
                return defineClass(className, bytes, 0, bytes.length);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

    }


    private static String getClassName(String everyClassPath) {

        Path path = Paths.get(everyClassPath);
        String fileFullName = path.getFileName().toString();
        String classnameWithoutExtension = fileFullName.replace(".class", "");

        return classnameWithoutExtension;
    }

    private static List<String> getAllClassesFromDirectory(String pathToAnimals) {

        File directoryPath = new File(pathToAnimals);
        File[] arrayOfFiles = directoryPath.listFiles();

        List<String> listOfFilesClassNames = new ArrayList<>();
        for (File file : arrayOfFiles) {
            listOfFilesClassNames.add(getClassName(file.getAbsolutePath()));
        }
        return listOfFilesClassNames;

    }
}
