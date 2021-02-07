package pl.codegym.task.task15.task1517;

/* 
Modyfikatory statyczne i wyjątki
*/

public class Solution {
    public static int A = 0;

    static {


       try {
            throw new ExceptionInInitializerError();
        } catch (Exception e){
            e.getStackTrace();
        }



    }

    public static int B = 5;

    public static void main(String[] args) {
        System.out.println(B);
    }
}
