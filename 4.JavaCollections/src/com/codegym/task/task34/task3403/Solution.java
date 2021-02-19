package com.codegym.task.task34.task3403;

/* 
Factorization using recursion

*/

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.recurse(132);
    }

/*    public void recurse(int n) {

        if (n < 1) return;

        List<Integer> allPrimeFactors = new ArrayList<>();
        int factor = 2;
        while (factor <= n) {
            if (n % factor == 0) {
                allPrimeFactors.add(factor);
                n /= factor;
            } else {
                factor++;
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < allPrimeFactors.size(); i++) {
            if (i < allPrimeFactors.size() - 1) stringBuilder.append(allPrimeFactors.get(i)).append(" ");
            else stringBuilder.append(allPrimeFactors.get(i));
        }

        System.out.println(stringBuilder.toString());

    }*/

    public void recurse(int n) {

        if (n < 1) return;

        int factor = 2;
        while (factor <= n) {
            if (n % factor == 0) {
                System.out.print(factor + " ");
                recurse(n / factor);
                return;
            } else {
                factor++;
            }
        }

    }
}
