package pl.codegym.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;

/* 
Wprowadzenie do properties
*/

/*
pliki:
c:\!!programowanie\cwiczenia_pliki\pliki28\pliki28source.properties
c:\!!programowanie\cwiczenia_pliki\pliki28\pliki28destination.properties
*/


public class Solution {

    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws Exception{

        String fileName = "";
        String filenameForOutput = "c:\\!!programowanie\\cwiczenia_pliki\\pliki28\\pliki28destination.properties";
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        //1. Metoda fillInPropertiesMap musi odczytywać dane z konsoli.
        try{
            BufferedReader bufferedReaderFromConsole = new BufferedReader(new InputStreamReader(System.in));
            fileName = bufferedReaderFromConsole.readLine();
            bufferedReaderFromConsole.close();
        } catch (IOException e){e.printStackTrace();}

        //2. Metoda fillInPropertiesMap musi tworzyć FileInputStream, przekazując odczytany ciąg jako argument.

        fileInputStream = new FileInputStream(fileName);
//            fileOutputStream = new FileOutputStream(filenameForOutput);

        load(fileInputStream);


    }

    public void save(OutputStream outputStream) throws Exception {

        Properties propertiesToBeWrittenToFile = new Properties();

        for (Map.Entry<String, String> propertiesEntry : properties.entrySet()){
            propertiesToBeWrittenToFile.setProperty(propertiesEntry.getKey(), propertiesEntry.getValue());
        }

        //4. Metoda save musi przechowywać mapę properties w obiekcie OutputStream przekazywanym jako argument.
        try{
            propertiesToBeWrittenToFile.store(outputStream, null);
        } catch (Exception e) {e.printStackTrace();}

    }


    //5. Metoda load musi przywracać stan mapy properties z obiektu InputStream przekazywanego jako argument.
    public void load(InputStream inputStream) throws Exception {
        try{
            Properties propertiesFromFile = new Properties();
            propertiesFromFile.load(inputStream);

            for (Map.Entry<Object, Object> wpisWProperties : propertiesFromFile.entrySet()){
                properties.put((String) wpisWProperties.getKey(), (String) wpisWProperties.getValue());
            }


        }catch (Exception e){
            e.printStackTrace();
        }


    }


    public static void main(String[] args) {
//        Solution solution = new Solution();
//        solution.fillInPropertiesMap();

    }
}




