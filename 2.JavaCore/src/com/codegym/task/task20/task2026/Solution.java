package com.codegym.task.task20.task2026;

/* 
Rectangle algorithms

*/

public class Solution {
    public static void main(String[] args) {
        byte[][] a1 = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        byte[][] a2 = new byte[][]{
                {1, 0, 0, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 0, 0, 1}
        };

        int count1 = getRectangleCount(a1);
        System.out.println("count = " + count1 + ". Must be 2");
        int count2 = getRectangleCount(a2);
        System.out.println("count = " + count2 + ". Must be 4");
    }

    public static int getRectangleCount(byte[][] a) {
        int howManySquares = 0;

        for (int i = 0; i < a.length; i++){
            for (int j = 0; j < 4; j++){
                if (a[i][j] == 1) {
                    howManySquares++;
                    wyczyscDalejWPoziomie(a, i, j);
                    zejdzNizejISprawdzCzyNieMaJedynki(a, i, j);
                }
            }
        }
        return howManySquares;
    }

    public static void wyczyscDalejWPoziomie(byte[][] a, int i, int j){
        for (int z = j + 1; z < 4; z++ ){
            byte wpisJedenWPrawo = a[i][z];
            if (wpisJedenWPrawo == 1){
                a[i][z] = 0;
            } else {
                return;
            }
        }
    }

    public static void zejdzNizejISprawdzCzyNieMaJedynki(byte[][] a, int i, int j){
        for (int z = i + 1; z < 4; z++){
            byte wpisJedenNizej = a[z][j];
            if (wpisJedenNizej == 1){
                a[z][j] = 0;
                wyczyscDalejWPoziomie(a, z, j);
            }else {
                return;
            }
        }
    }

}
