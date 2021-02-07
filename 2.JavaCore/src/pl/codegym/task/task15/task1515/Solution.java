package pl.codegym.task.task15.task1515;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Modyfikatory statyczne: część 2
*/

public class Solution {
    public static int A;
    public static int B;

    static {
        BufferedReader liczby = new BufferedReader(new InputStreamReader(System.in));
        try{
            A = Integer.parseInt(liczby.readLine());
            B = Integer.parseInt(liczby.readLine());
            liczby.close();
        } catch (IOException e){
            System.out.println(e);
            System.out.println("To nie liczby calkowite, losiu!");
//            liczby.close();
        }
    }

    public static final int MIN = min(A, B);

    public static void main(String[] args) throws IOException{
        System.out.println(MIN);
    }

    public static int min(int a, int b) {
        return a < b ? a : b;
    }
}
