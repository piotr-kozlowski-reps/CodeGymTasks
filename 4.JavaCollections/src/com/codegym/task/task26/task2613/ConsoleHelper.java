package com.codegym.task.task26.task2613;

import com.codegym.task.task26.task2613.exception.InterruptedOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConsoleHelper {

    //fields
    private static BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));
    private static ResourceBundle res = ResourceBundle.getBundle(CashMachine.class.getPackage().getName() + ".resources.common_en");


    public static void writeMessage(String message) {
        System.out.println(message);
    }


    public static String readString() throws InterruptedOperationException {
        try {
            String text = bis.readLine();
            if ("exit".equals(text.toLowerCase())) {
                throw new InterruptedOperationException();
            }

            return text;
        } catch (IOException ignored) {
        }
        return null;
    }

    public static String requestCurrencyCode() throws InterruptedOperationException{

        while (true) {
            writeMessage(res.getString("choose.currency.code"));
            String enteredCurrencyCode = readString();

            Pattern pattern = Pattern.compile("^[a-zA-Z]{3}$");
            Matcher matcher = pattern.matcher(enteredCurrencyCode);

            if (matcher.matches()) {
                enteredCurrencyCode = enteredCurrencyCode.toUpperCase();
                return enteredCurrencyCode;
            } else {
                writeMessage(res.getString("invalid.data"));
                continue;
            }

        }


    }

    public static String[] getTwoValidNumbers(String currencyCode) throws InterruptedOperationException{

        String[] denominationAndNumberOfBanknotes = new String[2];

        while (true) {

            writeMessage(String.format(res.getString("choose.denomination.and.count.format"), currencyCode));
            String denominationAndNumberOfBanknotesAsString = readString();

            Pattern patternOnlyPositiveInteger = Pattern.compile("^[0-9]+\\s[0-9]+$");
            Matcher matcher = patternOnlyPositiveInteger.matcher(denominationAndNumberOfBanknotesAsString);


            if (!matcher.matches()) {
                writeMessage(res.getString("invalid.data"));
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
            writeMessage(res.getString("choose.operation"));
            writeMessage("1 - " + res.getString("operation.INFO"));
            writeMessage("2 - " + res.getString("operation.DEPOSIT"));
            writeMessage("3 - " + res.getString("operation.WITHDRAW"));
            writeMessage("4 - " + res.getString("operation.EXIT"));

            String textEntered = readString();

            if (textEntered.toUpperCase().equals("EXIT")){
                writeMessage(res.getString("the.end"));
                throw new InterruptedOperationException();
            }

            Pattern pattern = Pattern.compile("^[1234]$");
            Matcher matcher = pattern.matcher(textEntered);

            if (!matcher.matches()) {
                writeMessage(res.getString("invalid.data"));
                continue;
            } else {
                return Operation.getAllowableOperationByOrdinal(Integer.parseInt(textEntered));
            }

        }

    }

    public static void printExitMessage() {
        ConsoleHelper.writeMessage(res.getString("the.end"));
    }

}
