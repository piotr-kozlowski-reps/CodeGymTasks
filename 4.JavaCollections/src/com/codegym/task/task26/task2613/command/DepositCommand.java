package com.codegym.task.task26.task2613.command;

import com.codegym.task.task26.task2613.CashMachine;
import com.codegym.task.task26.task2613.ConsoleHelper;
import com.codegym.task.task26.task2613.CurrencyManipulator;
import com.codegym.task.task26.task2613.CurrencyManipulatorFactory;
import com.codegym.task.task26.task2613.exception.InterruptedOperationException;

import java.util.Locale;
import java.util.ResourceBundle;

class DepositCommand implements Command{

    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "deposit_en");


    @Override
    public void execute() throws InterruptedOperationException {
        Locale.setDefault(Locale.ENGLISH);

        ConsoleHelper.writeMessage(res.getString("before"));
        String currencyCode = ConsoleHelper.requestCurrencyCode();
        CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
        String[] denominationAndNumberOfBanknotes = ConsoleHelper.getTwoValidNumbers(currencyCode);

        int denomination = Integer.parseInt(denominationAndNumberOfBanknotes[0]);
        int numberOfBanknotes = Integer.parseInt(denominationAndNumberOfBanknotes[1]);
        int amountDeposited = denomination * numberOfBanknotes;

        if (amountDeposited > 0) {
            ConsoleHelper.writeMessage(String.format(res.getString("success.format"), amountDeposited, currencyManipulator.getCurrencyCode()));
            currencyManipulator.addAmount(denomination, numberOfBanknotes);
        }
        
    }
}
