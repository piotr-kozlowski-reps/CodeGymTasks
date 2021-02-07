package pl.codegym.task.task18.task1813;

import java.io.*;
import java.nio.channels.FileChannel;

/* 
AmigoOutputStream
*/

public class AmigoOutputStream extends FileOutputStream{
    public FileOutputStream original;
    public static String fileName = "C:/tmp/result.txt";

    public AmigoOutputStream (FileOutputStream fileOutputStream) throws FileNotFoundException{
        super(fileName);
        this.original = fileOutputStream;
    }

    @Override
    public void write(int b) throws IOException {
        original.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        original.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        original.write(b, off, len);
    }

    @Override
    public void close() throws IOException {
        original.flush();
        //2.2 Dodaj następujący tekst "CodeGym © All rights reserved." Użyj metody getBytes().
        String dodatekTekstowy = "CodeGym © All rights reserved.";
        byte[] zamienionyNaBytes = dodatekTekstowy.getBytes();
        original.write(zamienionyNaBytes);
        original.close();
    }

    @Override
    public FileChannel getChannel() {
        return original.getChannel();
    }

    @Override
    public void flush() throws IOException {
        original.flush();
    }




    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }

}
