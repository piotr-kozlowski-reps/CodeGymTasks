package pl.codegym.task.task15.task1531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;

/* 
Silnia
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(reader.readLine());
        reader.close();

        System.out.println(factorial(input));
    }

    public static String factorial(int n) {
        BigInteger wynik = new BigInteger("1");

        if (n < 0){
            wynik = BigInteger.ZERO;
        } else if (n == 0){
            wynik = BigInteger.ONE;
        } else if (n > 0 && n <= 150){
            for (int i = 1; i <= n; i++ ){
                BigInteger mnoznik = new BigInteger(String.valueOf(i));
                wynik = wynik.multiply(mnoznik);
//                System.out.println(wynik.toString());
            }
        }

        return wynik.toString();
    }
}
