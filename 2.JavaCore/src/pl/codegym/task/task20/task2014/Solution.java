package pl.codegym.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializowane rozwiązanie
*/


public class Solution implements Serializable{

    public static void main(String[] args) {
//        System.out.println(new Solution(4));

        File mojPLik = null;
        try{
            //1) utwórz plik, otwórz strumień wejściowy i strumień wyjścowy;
            mojPLik = File.createTempFile("moja_nazwa_pliku", null, new File("c:\\!!programowanie\\cwiczenia_pliki\\pliki30\\"));
            InputStream inputStream = new FileInputStream(mojPLik);
            OutputStream outputStream = new FileOutputStream(mojPLik);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

            Solution savedObject = new Solution(4);
            objectOutputStream.writeObject(savedObject);
            System.out.println(savedObject);

            Solution loadedObject = (Solution) objectInputStream.readObject();
            System.out.println(savedObject);

            inputStream.close();
            objectInputStream.close();
            outputStream.close();
            objectOutputStream.close();



        } catch (Exception e) {e.printStackTrace();}

    }

    transient private final String pattern = "dd MMMM yyyy, EEEE";
    transient private Date currentDate;
    transient private int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Dziś jest %s, aktualna temperatura wynosi %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
