package pl.codegym.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Modyfikatory statyczne: część 1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<>();

    static {
        labels.put(1.5d, "Ala");
        labels.put(2.1, "df");
        labels.put((double)2, "dfgvfd");
        labels.put(1.1, "");
        labels.put(3.4, "dsfvdf");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
