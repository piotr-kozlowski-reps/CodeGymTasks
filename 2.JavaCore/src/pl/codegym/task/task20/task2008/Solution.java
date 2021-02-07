package pl.codegym.task.task20.task2008;

import java.io.*;

/* 
W jaki sposób serializujesz Singletona?
*/

//W jaki sposób serializujesz Singletona?
//Dwa zdeserializowane obiekty (singleton1 i singleton2) mają różne odwołania do pamięci, a powinny być one takie same.
//W klasie Singleton dodaj metodę tak, aby po deserializacji odwołania do obiektów były takie same (wyszukaj w Google jak to zrobić).
//Metoda main nie jest testowana.




public class Solution implements Serializable {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Singleton instance = Singleton.getInstance();

        ByteArrayOutputStream byteArrayOutputStream = serializeSingletonInstance(instance);

        Singleton singleton = deserializeSingletonInstance(byteArrayOutputStream);
        Singleton singleton1 = deserializeSingletonInstance(byteArrayOutputStream);

        System.out.println("Sprawdź ourInstance: " + singleton.getInstance());
        System.out.println("Sprawdź ourInstance: " + singleton1.getInstance());
        System.out.println("=========================================================");
        System.out.println("Sprawdź singleton: " + singleton);
        System.out.println("Sprawdź singleton1: " + singleton1);
    }

    public static ByteArrayOutputStream serializeSingletonInstance(Singleton instance) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        ObjectOutputStream oos = new ObjectOutputStream(byteArrayOutputStream);
        oos.writeObject(instance);
        oos.close();

        return byteArrayOutputStream;
    }

    public static Singleton deserializeSingletonInstance(ByteArrayOutputStream byteArrayOutputStream) throws IOException, ClassNotFoundException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());

        ObjectInputStream ois = new ObjectInputStream(byteArrayInputStream);
        Singleton singleton = (Singleton) ois.readObject();
        ois.close();

        return singleton;
    }

    public static class Singleton implements Serializable {

        private static Singleton ourInstance;

        public static Singleton getInstance() {
            if (ourInstance == null) {
                ourInstance = new Singleton();
            }
            return ourInstance;
        }

        private Singleton() {
        }

        private Object readResolve(){
            return getInstance();
        }
    }
}
