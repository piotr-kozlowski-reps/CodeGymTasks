package com.codegym.task.task26.task2613.command;

import com.codegym.task.task26.task2613.ConsoleHelper;
import com.codegym.task.task26.task2613.CurrencyManipulator;
import com.codegym.task.task26.task2613.CurrencyManipulatorFactory;
import com.codegym.task.task26.task2613.exception.InsufficientFundsException;
import com.codegym.task.task26.task2613.exception.InterruptedOperationException;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class WithdrawCommand implements Command{

    @Override
    public void execute()  throws InterruptedOperationException {

        String currencyCode = ConsoleHelper.requestCurrencyCode();
        CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
        Map<Integer, Integer> withdrawalBanknotes;

        Pattern pattern = null;
        Matcher matcher = null;
        String amount = null;
        Integer amountAsInt = null;

        while (true) {

            ConsoleHelper.writeMessage("Write amount, please");
            amount = ConsoleHelper.readString();

            pattern = Pattern.compile("^[0-9]+$");
            matcher = pattern.matcher(amount);

            if (matcher.matches()) {
                amountAsInt = Integer.parseInt(amount);
            } else {
                amountAsInt = null;
            }

            if (!matcher.matches()) {
                ConsoleHelper.writeMessage("Invalid amount is entered");
                continue;
            } else if (matcher.matches() && !currencyManipulator.isAmountAvailable(amountAsInt)) {
                ConsoleHelper.writeMessage("There's less money than you expect :(");
                continue;
            }

            if (matcher.matches() && currencyManipulator.isAmountAvailable(amountAsInt)) {

                withdrawalBanknotes = new TreeMap<>();

                try {
                    withdrawalBanknotes = currencyManipulator.withdrawAmount(amountAsInt);
                } catch (InsufficientFundsException ignored) {
                    ConsoleHelper.writeMessage("InsufficientFundsException");
                    continue;
                }

                for (Map.Entry<Integer, Integer> entry : withdrawalBanknotes.entrySet()) {
                    System.out.println(String.format("\t%d - %d", entry.getKey(), entry.getValue()));
                }

                ConsoleHelper.writeMessage("Transaction completed");
                break;

            }

        }
    }
}