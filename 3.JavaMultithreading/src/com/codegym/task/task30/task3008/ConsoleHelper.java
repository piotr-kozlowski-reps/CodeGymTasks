package com.codegym.task.task30.task3008;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {

    //fields
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    //
    public static void writeMessage(String message){
        System.out.println(message);
    }

    public static String readString(){

        String message = null;

        while (true){

            try{
                message = bufferedReader.readLine();
                break;
            } catch (IOException e){
                System.out.println("An error occurred while trying to enter text. Try again.");
            }
        }
        
        return message;
    }

    public static int readInt(){

        int number = 0;

        while (true){
            try{
                number = Integer.parseInt(readString());
                break;
            } catch (NumberFormatException e){
                System.out.println("An error while trying to enter a number. Try again.");
            }

        }

        return number;
    }

}