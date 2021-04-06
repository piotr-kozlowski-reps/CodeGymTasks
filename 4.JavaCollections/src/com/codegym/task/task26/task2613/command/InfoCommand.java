package com.codegym.task.task26.task2613.command;

import com.codegym.task.task26.task2613.ConsoleHelper;
import com.codegym.task.task26.task2613.CurrencyManipulator;
import com.codegym.task.task26.task2613.CurrencyManipulatorFactory;

import java.util.Collection;
import java.util.Locale;

class InfoCommand implements Command{

    @Override
    public void execute() {

        Collection<CurrencyManipulator> allCurrencyManipulators = CurrencyManipulatorFactory.getAllCurrencyManipulators();

        int howManyEmptyDenominations = allCurrencyManipulators.size();

        for (CurrencyManipulator entry : allCurrencyManipulators) {
            if (!entry.hasMoney()) howManyEmptyDenominations--;
        }

        if (howManyEmptyDenominations == 0 || allCurrencyManipulators.size() == 0) {
            ConsoleHelper.writeMessage("No money available.");
            return;
        }

        for (CurrencyManipulator entry : allCurrencyManipulators) {
            ConsoleHelper.writeMessage(String.format("%s - %d", entry.getCurrencyCode(), entry.getTotalAmount()));
        }

    }
}
