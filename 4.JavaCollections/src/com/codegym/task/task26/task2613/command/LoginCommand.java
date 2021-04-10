package com.codegym.task.task26.task2613.command;

import com.codegym.task.task26.task2613.CashMachine;
import com.codegym.task.task26.task2613.ConsoleHelper;
import com.codegym.task.task26.task2613.exception.InterruptedOperationException;

import java.util.Enumeration;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginCommand implements Command{

    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "login_en");

    //fields
//    private ResourceBundle validCreditCards = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + ".resources.verifiedCards");

    @Override
    public void execute() throws InterruptedOperationException {

        while (true) {

            ConsoleHelper.writeMessage(res.getString("before"));
            ConsoleHelper.writeMessage(res.getString("specify.data"));

            //card number
            String providedCardNumber = ConsoleHelper.readString();
            Pattern patternCardNumber = Pattern.compile("^[0-9]{12}$");
            Matcher matcherCardNumber = patternCardNumber.matcher(providedCardNumber);

            //pin
            String providedPin = ConsoleHelper.readString();
            Pattern patternPin = Pattern.compile("^[0-9]{4}$");
            Matcher matcherPin = patternPin.matcher(providedPin);

            if (!matcherPin.matches() || !matcherCardNumber.matches()) {
                ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
                ConsoleHelper.writeMessage(String.format(res.getString("not.verified.format"), providedCardNumber));
                continue;
            }

            //comparation with ResourceBoundle numbers
            if (res.containsKey(providedCardNumber) && providedPin.equals(res.getString(providedCardNumber))) {
                ConsoleHelper.writeMessage(String.format(res.getString("success.format"), providedCardNumber));
                break;
            } else {
                ConsoleHelper.writeMessage(res.getString("try.again.or.exit"));
                continue;
            }

        }
    }



//    //todo: wywal
//    public static void main(String[] args) throws InterruptedOperationException{
//        LoginCommand loginCommand = new LoginCommand();
//        loginCommand.execute();
//    }


}