package com.codegym.task.task29.task2907;

import java.math.BigDecimal;

/* 
This weird BigDecimal

*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getValue(1.1d, 1.2d));
    }

    public static BigDecimal getValue(double v1, double v2) {

/*        BigDecimal v1BigDecimal = new BigDecimal(0);
        v1BigDecimal = BigDecimal.valueOf(v1);
        BigDecimal v2BigDecimal = new BigDecimal(0);
        v2BigDecimal = BigDecimal.valueOf(v2);*/

        return new BigDecimal(v1 + "").add(new BigDecimal(v2 + ""));
    }

}