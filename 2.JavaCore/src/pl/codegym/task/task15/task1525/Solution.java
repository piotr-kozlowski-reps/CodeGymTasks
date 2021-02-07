package pl.codegym.task.task15.task1525;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Plik w bloku statycznym
*/

public class Solution {

    public static List<String> lines = new ArrayList<>();

    static {

        try {

            File file = new File(Statics.FILE_NAME);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            //wczytywanie do ArrayList
            String line;
            while ((line = br.readLine()) != null){
                lines.add(line);
            }
            br.close();
            fr.close();

        } catch (Exception e){

        }

    }




    public static void main(String[] args) {
        System.out.println(lines);
    }
}
