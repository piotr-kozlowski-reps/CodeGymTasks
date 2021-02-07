package pl.codegym.task.task15.task1507;

/* 
OOP: przeciążanie metod
*/

public class Solution {
    public static void main(String[] args) {
        printMatrix(2, 3, "8");
    }

    public static void printMatrix(int m, int n, String value) {
        System.out.println("Wypełnianie obiektami typu String");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, int n, Object value) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println();
        }
    }

    //1
    public static void printMatrix(int m, int n, byte value) {
        System.out.println("Wypełnianie obiektami typu Byte");
        printMatrix(m, n, (Object) value);
    }

    //2
    public static void printMatrix(byte m, int n, Integer value) {
        System.out.println("Wypełnianie obiektami typu Byte");
        System.out.println(value * m + "kuku");
    }

    //3
    public static void printMatrix(byte m, byte n, byte value){
        System.out.println(m * n * value);
    }

    //4
    public static void printMatrix(Integer m, Integer n, byte value){
        System.out.println(m * n * value);
    }

    //5
    public static void printMatrix(Integer m, Integer n, Integer value){
        System.out.println(m * n * value);
    }

    //6
    public static void printMatrix(Integer m, Integer n, short value){
        System.out.println("piata");
        printMatrix(m, n, value);
    }

    //7
    public static void printMatrix(short m, short n, short value){
        System.out.println("siudma");
        printMatrix(m, n, (Object) value);
    }

    //8
    public static void printMatrix(short m, short n, float value){
        System.out.println("siudma");
        printMatrix(m, n, (Object) value);
    }
}
