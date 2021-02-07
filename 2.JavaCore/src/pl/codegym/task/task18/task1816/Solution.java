package pl.codegym.task.task18.task1816;

/* 
ABC
*/

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws Exception{

        int ileZnakow = 0;
        char[] literyAlfabetu = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};

        File plikZArgumentu = new File(args[0]);
        FileInputStream fis = new FileInputStream(plikZArgumentu);

        while (fis.available() > 0){
            char aktualnyZnak = (char) fis.read();
            aktualnyZnak = Character.toUpperCase(aktualnyZnak);
            for (char znakZTablicy : literyAlfabetu){
                if (aktualnyZnak == znakZTablicy){
                    ileZnakow++;
                }
            }
        }
        System.out.println(ileZnakow);
        fis.close();

    }
}
