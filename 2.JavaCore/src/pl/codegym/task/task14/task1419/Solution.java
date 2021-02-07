package pl.codegym.task.task14.task1419;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* 
Inwazja wyjątków
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();



    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   // Pierwszy wyjątek

        try {
            Class.forName("oracle.jdbc");
        } catch (Exception e){
            exceptions.add(e);
        }

        try {
            Object a[] = new String[3];
            a[0] = new Integer(12);
        } catch (Exception e){
            exceptions.add(e);
        }

        try {
            int a = -10;
            int[] tablica = new int[a];
        } catch (Exception e){
            exceptions.add(e);
        }

        try {
            Object x = new Integer(0);
            System.out.println((String) x);
        } catch (Exception e){
            exceptions.add(e);
        }

        try {
            Map<Integer, Integer> mapa = new HashMap<Integer, Integer>();
            mapa.get(34);
        } catch (Exception e){
            exceptions.add(e);
        }

        try {
            int[] numer = new int[1];
            numer[10] = 10;
        } catch (Exception e){
            exceptions.add(e);
        }

        try {
            int numer = Integer.parseInt("34fR5");
        } catch (Exception e){
            exceptions.add(e);
        }

        try {
            File file = new File("c:/test.txt");
            FileReader fr = new FileReader(file);
        } catch (Exception e){
            exceptions.add(e);
        }

        try {
            String a = "kupa";
            char litera = a.charAt(34);
        } catch (Exception e){
            exceptions.add(e);
        }

        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            List<Integer> integry = new ArrayList<Integer>();
            Integer a = integry.get(3);
        } catch (Exception e){
            exceptions.add(e);
        }

    }
}
