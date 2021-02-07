package pl.codegym.task.task19.task1917;

/* 
Twój własny FileWriter
*/

import java.io.*;

public class FileConsoleWriter extends FileWriter{

    //1. Klasa FileConsoleWriter musi zawierać prywatne pole FileWriter o nazwie fileWriter,
    // które nie powinno być natychmiastowo inicjalizowane.
    private FileWriter fileWriter;





    //2. Klasa FileConsoleWriter musi posiadać pięć konstruktorów, które inicjalizują fileWriter do zapisu.


    public FileConsoleWriter(String fileName) throws IOException{
        super(String.valueOf(new FileWriter(fileName)));
    }

    public FileConsoleWriter(String fileName, boolean append) throws IOException {
        super(String.valueOf(new FileWriter(fileName, append)));
    }

    public FileConsoleWriter(File file) throws IOException {
        super(String.valueOf(new FileWriter(file)));
    }

    public FileConsoleWriter(File file, boolean append) throws IOException {
        super(String.valueOf(new FileWriter(file, append)));
    }



/*    public FileConsoleWriter(FileWriter fileWriter, String fileName) throws IOException{
        super(fileName);
        this.fileWriter = fileWriter;
    }

    public FileConsoleWriter(FileWriter fileWriter, String fileName, boolean append) throws IOException {
        super(fileName, append);
        this.fileWriter = fileWriter;
    }

    public FileConsoleWriter(FileWriter fileWriter, File file) throws IOException {
        super(file);
        this.fileWriter = fileWriter;
    }

    public FileConsoleWriter(FileWriter fileWriter, File file, boolean append) throws IOException {
        super(file, append);
        this.fileWriter = fileWriter;
    }*/






    //3. Klasa FileConsoleWriter musi posiadać metodę write(char[] cbuf, int off, int len) throws IOException,
    // która powinna zapisywać dane zarówno do fileWriter jak i do konsoli.
    @Override
    public void write(char[] cbuf, int off, int len) throws IOException {
        fileWriter.write(cbuf, off, len);
        System.out.println(cbuf.toString());
    }

    //4. Klasa FileConsoleWriter musi posiadać metodę write(int c) throws IOException,
    // która powinna zapisywać dane zarówno do fileWriter jak i do konsoli.
    @Override
    public void write(int c) throws IOException {
        fileWriter.write(c);
        System.out.println(c);
    }

    //5. Klasa FileConsoleWriter musi posiadać metodę write(String str) throws IOException,
    // która powinna zapisywać dane zarówno do fileWriter jak i do konsoli.
    @Override
    public void write(String str) throws IOException{
        fileWriter.write(str);
        System.out.println(str);
    }

    //6. Klasa FileConsoleWriter musi posiadać metodę write(String str, int off, int len) throws IOException,
    // która powinna zapisywać dane zarówno do fileWriter jak i do konsoli.




    //7. Klasa FileConsoleWriter musi posiadać metodę write(char[] cbuf) throws IOException,
    // która powinna zapisywać dane zarówno do fileWriter jak i do konsoli.

    //8. Klasa FileConsoleWriter musi posiadać metodę close() throws IOException,
    // która powinna wywoływać odpowiednią metodę w fileWriter.
    @Override
    public void close() throws IOException {
        fileWriter.close();
    }






    public static void main(String[] args) {
    }

}
