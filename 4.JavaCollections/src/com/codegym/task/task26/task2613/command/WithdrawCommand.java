package com.codegym.task.task26.task2613.command;

import com.codegym.task.task26.task2613.CashMachine;
import com.codegym.task.task26.task2613.ConsoleHelper;
import com.codegym.task.task26.task2613.CurrencyManipulator;
import com.codegym.task.task26.task2613.CurrencyManipulatorFactory;
import com.codegym.task.task26.task2613.exception.InsufficientFundsException;
import com.codegym.task.task26.task2613.exception.InterruptedOperationException;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class WithdrawCommand implements Command{

    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "withdraw_en");

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


            ConsoleHelper.writeMessage(res.getString("before"));
            ConsoleHelper.writeMessage(res.getString("specify.amount"));

            amount = ConsoleHelper.readString();

            pattern = Pattern.compile("^[0-9]+$");
            matcher = pattern.matcher(amount);

            if (matcher.matches()) {
                amountAsInt = Integer.parseInt(amount);
            } else {
                amountAsInt = null;
            }

            if (!matcher.matches()) {
                ConsoleHelper.writeMessage(res.getString("specify.not.empty.amount"));
                continue;
            } else if (matcher.matches() && !currencyManipulator.isAmountAvailable(amountAsInt)) {
                ConsoleHelper.writeMessage(res.getString("not.enough.money"));
                continue;
            }

            if (matcher.matches() && currencyManipulator.isAmountAvailable(amountAsInt)) {

                withdrawalBanknotes = new TreeMap<>();

                try {
                    withdrawalBanknotes = currencyManipulator.withdrawAmount(amountAsInt);
                } catch (InsufficientFundsException ignored) {
                    ConsoleHelper.writeMessage(res.getString("exact.amount.not.available"));
                    continue;
                }

//                for (Map.Entry<Integer, Integer> entry : withdrawalBanknotes.entrySet()) {
//                    System.out.println(String.format("\t%d - %d", entry.getKey(), entry.getValue()));
//                }

                int amountWithdrawn = 0;
                for (Map.Entry<Integer, Integer> entry : withdrawalBanknotes.entrySet()) {
                    amountWithdrawn = amountWithdrawn + (entry.getKey() * entry.getValue());
                }
                ConsoleHelper.writeMessage(String.format(res.getString("exact.amount.not.available"), amountWithdrawn, currencyManipulator.getCurrencyCode()));


//                ConsoleHelper.writeMessage("Transaction completed");
                break;

            }

        }
    }
}

