package pl.codegym.task.task18.task1814;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* 
UnsupportedFileName
*/

public class TxtInputStream extends FileInputStream {

    public TxtInputStream(String fileName) throws Exception{
        super(fileName);

        String extension = fileName.substring(fileName.length() - 4, fileName.length());
        if(!extension.equals(".txt")){
            super.close();
            throw new UnsupportedFileNameException();
        }


/*        String extension = fileName.substring(fileName.length() - 4, fileName.length());
        if (extension.equals(".txt")){
            super(fileName);
        } else {
            super.close();
            throw new UnsupportedFileNameException();
        }*/


    }

    public static void main(String[] args) throws FileNotFoundException {
    }
}

