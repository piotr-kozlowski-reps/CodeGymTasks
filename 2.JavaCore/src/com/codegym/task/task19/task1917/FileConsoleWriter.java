package com.codegym.task.task19.task1917;

/* 
Your own FileWriter

*/

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;

public class FileConsoleWriter {

    private FileWriter fileWriter;

    public FileConsoleWriter( String name) throws Exception {
        this.fileWriter = new FileWriter(name);
    }
    public  FileConsoleWriter( String name, boolean append) throws Exception {
        this.fileWriter = new FileWriter(name, append);
    }
    public FileConsoleWriter( File file) throws Exception {
        this.fileWriter = new FileWriter(file);
    }
    public FileConsoleWriter( File file, boolean append) throws Exception {
        this.fileWriter = new FileWriter(file, append);
    }
    public FileConsoleWriter(FileDescriptor fd) {
        this.fileWriter = new FileWriter(fd);
    }


    // methods

    //3. The FileConsoleWriter class must have a write(char[] cbuf, int off, int len)
    // throws IOException method, which should write data to fileWriter as well as the console.
    public void write(char[] cbuf, int off, int len) throws IOException {
        fileWriter.write(cbuf, off, len);
        String resultToConsole = new String(cbuf);
        System.out.println(resultToConsole.substring(off, off + len));
    }



    //4. The FileConsoleWriter class must have a write(int c) throws IOException method,
    // which should write data to fileWriter as well as the console.
    public void write(int c) throws IOException{
        fileWriter.write(c);
        System.out.println(c);
    }

    //5. The FileConsoleWriter class must have a write(String str) throws IOException method,
    // which should write data to fileWriter as well as the console.
    public void write(String str) throws IOException{
        fileWriter.write(str);
        System.out.println(str);
    }

    //6. The FileConsoleWriter class must have a write(String str, int off, int len) throws IOException method,
    // which should write data to fileWriter as well as the console.
    public void write(String str, int off, int len) throws IOException{
        fileWriter.write(str, off, len);
        String resultToConsole = str;
        System.out.println(resultToConsole.substring(off, off + len));
    }

    //7. The FileConsoleWriter class must have a write(char[] cbuf) throws IOException method,
    // which should write data to fileWriter as well as the console.
    public void write(char[] cbuf) throws IOException{
        fileWriter.write(cbuf);
        String resultToConsole = new String(cbuf);
        System.out.println(resultToConsole);
    }

    //8. The FileConsoleWriter class must have a close() throws IOException method,
    // which should call the corresponding method on fileWriter.
    public void close() throws IOException{
        fileWriter.close();
    }

    public static void main(String[] args) {
    }

}


