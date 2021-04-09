package com.codegym.task.task26.task2613.command;

import com.codegym.task.task26.task2613.ConsoleHelper;
import com.codegym.task.task26.task2613.exception.InterruptedOperationException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginCommand implements Command{

    //fileds
    private String cardNumber = "123456789012";
    private String pin = "1234";


    @Override
    public void execute() throws InterruptedOperationException {

        while (true) {


            ConsoleHelper.writeMessage("Write 12-digit cardNumber and 4-digit PIN");

            //card number
            String providedCardNumber = ConsoleHelper.readString();
            Pattern patternCardNumber = Pattern.compile("^[0-9]{12}$");
            Matcher matcherCardNumber = patternCardNumber.matcher(providedCardNumber);
            if (!matcherCardNumber.matches()) {
                ConsoleHelper.writeMessage("Wrong card Number");
                continue;
            }

            //pin
            String providedPin = ConsoleHelper.readString();
            Pattern patternPin = Pattern.compile("^[0-9]{4}$");
            Matcher matcherPin = patternPin.matcher(providedPin);

            if (!matcherPin.matches()) {
                ConsoleHelper.writeMessage("Wrong pin");
                continue;
            }

            //comparation with hardcoded values
            if (providedCardNumber.equals(cardNumber) && providedPin.equals(pin)) {
                ConsoleHelper.writeMessage("Verification was successful");
                break;
            } else {
                continue;
            }


        }



    }


}

