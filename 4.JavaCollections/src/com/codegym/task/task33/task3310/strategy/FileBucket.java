package com.codegym.task.task33.task3310.strategy;

import com.codegym.task.task33.task3310.Helper;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileBucket {

    //fields
    Path path;

    //constr
    public FileBucket() {

        String randomName = Helper.generateRandomString();
        
        try {
            path = Files.createTempFile(randomName, null);
            Files.deleteIfExists(path);
            Files.createFile(path);
            path.toFile().deleteOnExit();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

    //
    public long getFileSize() {
        try {
            return Files.size(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void putEntry(Entry entry) {

        try (ObjectOutputStream outputStream = new ObjectOutputStream(Files.newOutputStream(path))){
                outputStream.writeObject(entry);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Entry getEntry() {

        if (getFileSize() == 0) {
            return null;
        }

        Entry entry = null;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(Files.newInputStream(path))) {
            entry = (Entry) objectInputStream.readObject();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return entry;
    }

    public void remove() {
        try {
            Files.delete(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }






    //todo: wywal
    public static void main(String[] args) {
        FileBucket fileBucket = new FileBucket();
        System.out.println();

    }

}



//3. The getFileSize method must return the size of the file pointed to by path.
//4. The putEntry method must serialize the passed Entry object to the file pointed to by path.
// To get an OutputStream, use the Files.newOutputStream method.
//5. The getEntry method must deserialize an Entry object from the file pointed to by path.
// To get an InputStream, use the Files.newInputStream method.
//6. The remove method should delete the file pointed to by path using the Files.delete() method.
