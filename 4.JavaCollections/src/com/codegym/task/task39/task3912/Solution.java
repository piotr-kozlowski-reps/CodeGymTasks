package com.codegym.task.task39.task3912;

/* 
Maximum area

*/

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {

        int[][] matrix = new int[][] {
            {0, 1, 1, 0, 0, 0, 0},
            {0, 1, 0, 1, 1, 1, 1},
            {0, 1, 0, 1, 0, 1, 0},
            {0, 0, 0, 1, 1, 0, 1},
            {0, 0, 0, 1, 0, 1, 0}
        };

        System.out.println(maxSquare(matrix));


    }

    public static int maxSquare(int[][] matrix) {

        int maxSquareAreaOfOnes = 0;

        for (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix[0].length; x++) {
                if (matrix[y][x] == 1) {
                    int areaOfSpecificSquare = checkMaxSquare(matrix, y, x);
                    if (areaOfSpecificSquare > maxSquareAreaOfOnes) maxSquareAreaOfOnes = areaOfSpecificSquare;
                }
            }
        }

        return maxSquareAreaOfOnes;
    }

    private static int checkMaxSquare(int[][] matrix, int y, int x) {

        int result = 1;
        int xThis = 0;

        int index = 2;
        for (xThis = x + 1; xThis < matrix[0].length; xThis++) {
            if (matrix[y][xThis] != 1) break;
            else {
                
                int[][] subMatrix = createSubmatrix(matrix, y, x, index);
                if (subMatrix == null) return result;

                if (checkSubMatrixIfFilledWithOnes(subMatrix)) {
                    int squareArea = subMatrix.length * subMatrix.length;
                    if (squareArea > result) result = squareArea;
                }
                index++;
            }
        }

        

        return result;

    }

    private static int[][] createSubmatrix(int[][] matrix, int y, int x, int squareSide) {

        int[][] subMatrix = new int[squareSide][squareSide];
        List<Integer> allValues = new ArrayList<>();

        //reading values
        for (int yThis = y; yThis < y + squareSide; yThis++) {
            for (int xThis = x; xThis < x + squareSide; xThis++) {
                if (yThis > matrix.length - 1 || xThis > matrix[0].length - 1){
                    return null;
                } else {
                    allValues.add(matrix[yThis][xThis]);
                }

            }
        }

        //populate subMatrix with values
        int index = 0;
        for (int ySub = 0; ySub < subMatrix.length; ySub++) {
            for (int xSub = 0; xSub < subMatrix.length; xSub++) {
                subMatrix[ySub][xSub] = allValues.get(index);
                index++;
            }
        }

        return subMatrix;


    }



    private static boolean checkSubMatrixIfFilledWithOnes(int[][] subMatrix) {

        boolean isOnlyOnes = true;

        for (int y = 0; y < subMatrix.length; y++) {
            for (int x = 0; x < subMatrix.length; x++) {
                if (subMatrix[y][x] != 1) isOnlyOnes = false;
            }
        }

        return isOnlyOnes;
    }
/*    private static int refineIfIsSquareInY(int[][] matrix, int y, int x, int howManyConsecutiveOnesInX) {

        int squareArea = 0;
        for (int yThis = 0; yThis < howManyConsecutiveOnesInX; yThis++) {
            for (int xThis = 0; xThis < howManyConsecutiveOnesInX; xThis++) {
                if (matrix[yThis][xThis] == 1) squareArea++;
            }
        }

    }*/
}

//package com.codegym.task.task39.task3912;
//
///*
//Maximum area
//
//*/
//
//public class Solution {
//    public static void main(String[] args) {
//
//    }
//
//    public static int maxSquare(int[][] matrix) {
//        int rows = matrix.length;
//        int cols = rows > 0 ? matrix[0].length : 0;
//        int[][] temp = new int[rows + 1][cols + 1];
//        int maxLen = 0;
//        for (int i = 1; i <= rows; i++) {
//            for (int j = 1; j <= cols; j++) {
//                if (matrix[i-1][j-1] == 1){
//                    temp[i][j] = Math.min(Math.min(temp[i][j - 1], temp[i - 1][j]), temp[i - 1][j - 1]) + 1;
//                    maxLen = Math.max(maxLen, temp[i][j]);
//                }
//            }
//        }
//        return maxLen * maxLen;
//    }
//}
