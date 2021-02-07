package com.codegym.task.task29.task2911;

import java.util.Random;
import java.util.Scanner;

/* 
And more refactoring

*/

//And more refactoring
//An integer from 0 to 999, inclusive, is randomly chosen. The user enters a number from the keyboard.
//The program responds, telling the user whether the entered number is more or less than the secret number.
// If the user guesses the number in 10 attempts, then the program displays:
//"You guessed it!"
//"The secret number is <number>".
//Otherwise, it displays "You lose!".
//Fix one bug so that the code performs the specified actions.
//
//
//Requirements:
//1. If the correct number is not entered in 10 attempts, the program should display "You lose!".
//2. If an incorrect number is entered, the boolean playerWon flag should not be true.
//3. Don't change the method signatures.
//4. You need to make one change in the right place in the program.500

public class Solution {
    public static boolean playerWon = false;

    public static void main(String[] args) {
        new Solution().runGame();
    }

    private void runGame() {
        Random random = new Random();
        int secret = random.nextInt(1000);
        int tryNumber = -1;
        Scanner scanner = new Scanner(System.in);
        for (int i = 1; i <= 10; i++) {
            System.out.printf("Attempt %d - Guess a number: ", i);
            tryNumber = scanner.nextInt();
            if (tryNumber < secret)
                if (i < 10)
                    System.out.println("The secret number is bigger");
            if (tryNumber > secret)
                if (i < 10)
                    System.out.println("The secret number is smaller");
            if (tryNumber == secret){
                i = stopGame();
                playerWon = true;
            }


        }
        if (playerWon)
            printCongratulations(tryNumber);
        else
            printLoss();
    }

    private void printCongratulations(int number) {
        System.out.println();
        System.out.println("You guessed it!");
        System.out.println("The secret number is " + number);
    }

    private void printLoss() {
        System.out.println();
        System.out.println("You lose!");
    }

    private int stopGame() {
        return 10;
    }
}