package com.codegym.task.task26.task2613.command;

import com.codegym.task.task26.task2613.CashMachine;
import com.codegym.task.task26.task2613.ConsoleHelper;
import com.codegym.task.task26.task2613.CurrencyManipulator;
import com.codegym.task.task26.task2613.CurrencyManipulatorFactory;

import java.util.Collection;
import java.util.Locale;
import java.util.ResourceBundle;

class InfoCommand implements Command{

    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "info_en");

    @Override
    public void execute() {

        ConsoleHelper.writeMessage(res.getString("before"));

        Collection<CurrencyManipulator> allCurrencyManipulators = CurrencyManipulatorFactory.getAllCurrencyManipulators();

        int howManyEmptyDenominations = allCurrencyManipulators.size();

        for (CurrencyManipulator entry : allCurrencyManipulators) {
            if (!entry.hasMoney()) howManyEmptyDenominations--;
        }

        if (howManyEmptyDenominations == 0 || allCurrencyManipulators.size() == 0) {
            ConsoleHelper.writeMessage(res.getString("no.money"));
            return;
        }

        for (CurrencyManipulator entry : allCurrencyManipulators) {
            ConsoleHelper.writeMessage(String.format("%s - %d", entry.getCurrencyCode(), entry.getTotalAmount()));
        }

    }
}
