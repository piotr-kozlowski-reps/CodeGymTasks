package pl.codegym.task.task19.task1902;

/* 
Adapter
*/


import java.io.FileOutputStream;
import java.io.IOException;

//Użyj klasy AdapterFileOutputStream, aby dostosować FileOutputStream do nowego interfejsu AmigoStringWriter.
public class AdapterFileOutputStream implements AmigoStringWriter {

    private FileOutputStream fileOutputStream;              //3. Klasa AdapterFileOutputStream musi posiadać prywatne pole FileOutputStream o nazwie fileOutputStream.

    //4. Klasa AdapterFileOutputStream musi posiadać konstruktor z parametrem FileOutputStream.
    public AdapterFileOutputStream(FileOutputStream fileOutputStream){
        this.fileOutputStream = fileOutputStream;
    }

    //5. Metoda flush() klasy AdapterFileOutputStream musi delegować wywołanie do fileOutputStream.
    @Override
    public void flush() throws IOException {
        fileOutputStream.flush();
    }

    //6. Metoda writeString(String s) klasy AdapterFileOutputStream musi delegować wywołanie do odpowiedniej metody write() pola fileOutputStream.
    @Override
    public void writeString(String s) throws IOException {
        fileOutputStream.write(s.getBytes());
    }

    @Override
    public void close() throws IOException{
        fileOutputStream.close();
    }

    public static void main(String[] args) {

    }

}

