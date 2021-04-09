package com.codegym.task.task26.task2613.command;

import com.codegym.task.task26.task2613.ConsoleHelper;
import com.codegym.task.task26.task2613.CurrencyManipulator;
import com.codegym.task.task26.task2613.CurrencyManipulatorFactory;
import com.codegym.task.task26.task2613.exception.InterruptedOperationException;

import java.util.Locale;

class DepositCommand implements Command{
    @Override
    public void execute() throws InterruptedOperationException {
        Locale.setDefault(Locale.ENGLISH);
        String currencyCode = ConsoleHelper.requestCurrencyCode();
        CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
        String[] denominationAndNumberOfBanknotes = ConsoleHelper.getTwoValidNumbers(currencyCode);
        currencyManipulator.addAmount(Integer.parseInt(denominationAndNumberOfBanknotes[0]), Integer.parseInt(denominationAndNumberOfBanknotes[1]));
    }
}
