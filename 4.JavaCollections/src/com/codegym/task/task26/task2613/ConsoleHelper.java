package com.codegym.task.task26.task2613;

import com.codegym.task.task26.task2613.exception.InterruptedOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConsoleHelper {

    //fields
    private static BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));


    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() {

        String message = null;
        try {
            message = bis.readLine();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return message;
    }

    public static String requestCurrencyCode() {

        while (true) {
            writeMessage("Enter a currency code, please.");
            String enteredCurrencyCode = readString();

            Pattern pattern = Pattern.compile("^[a-zA-Z]{3}$");
            Matcher matcher = pattern.matcher(enteredCurrencyCode);

            if (matcher.matches()) {
                enteredCurrencyCode = enteredCurrencyCode.toUpperCase();
                return enteredCurrencyCode;
            } else {
                writeMessage("You've entered wrong code, try again.");
                continue;
            }

        }


    }

    public static String[] getTwoValidNumbers(String currencyCode) {

        String[] denominationAndNumberOfBanknotes = new String[2];

        while (true) {

            writeMessage("Enter denomination and number of banknotes (with space between):");
            String denominationAndNumberOfBanknotesAsString = readString();  //denomination = nominal banknotow

            Pattern patternOnlyPositiveInteger = Pattern.compile("^[0-9]+\\s[0-9]+$");
            Matcher matcher = patternOnlyPositiveInteger.matcher(denominationAndNumberOfBanknotesAsString);


            if (!matcher.matches()) {
                writeMessage("You entered wrong numbers. Enter positive numbers separated with space.");
                continue;
            } else {
                String[] splitedString = denominationAndNumberOfBanknotesAsString.split("\\s");
                denominationAndNumberOfBanknotes[0] = splitedString[0];
                denominationAndNumberOfBanknotes[1] = splitedString[1];
                return denominationAndNumberOfBanknotes;
            }

        }

    }

    public static Operation requestOperation() throws InterruptedOperationException{

        while (true) {
            writeMessage("Enter: \n1 -> INFO command\n2 -> DEPOSIT command\n3 -> WITHDRAW command\n4 -> EXIT command");
            String textEntered = readString();

            if (textEntered.toUpperCase().equals("EXIT")) throw new InterruptedOperationException();

            Pattern pattern = Pattern.compile("^[1234]$");
            Matcher matcher = pattern.matcher(textEntered);

            if (!matcher.matches()) {
                writeMessage("wrong number, do it again");
                continue;
            } else {
                return Operation.getAllowableOperationByOrdinal(Integer.parseInt(textEntered));
            } 

        }

    }

}
