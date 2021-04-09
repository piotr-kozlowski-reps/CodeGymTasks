package com.codegym.task.task26.task2613.command;

import com.codegym.task.task26.task2613.CashMachine;
import com.codegym.task.task26.task2613.ConsoleHelper;
import com.codegym.task.task26.task2613.exception.InterruptedOperationException;

import java.util.Enumeration;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginCommand implements Command{

    //fileds
//    private ResourceBundle validCreditCards = ResourceBundle.getBundle(
//            CashMachine.class.getPackage().toString().replaceAll("\\.", "\\\\").replace("package ", "")
//            + "\\resources\\verifiedCards");
    private ResourceBundle validCreditCards = ResourceBundle.getBundle(CashMachine.class.getPackage().getName() + ".resources.verifiedCards");

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

            //comparation with ResourceBoundle numbers
            if (validCreditCards.containsKey(providedCardNumber) && providedPin.equals(validCreditCards.getString(providedCardNumber))) {
                ConsoleHelper.writeMessage("Verification was successful");
                break;
            } else {
                ConsoleHelper.writeMessage("Verification failed.");
                continue;
            }







//            boolean isCardValid = false;
//            Enumeration<String> keys = validCreditCards.getKeys();
//
//            while (keys.hasMoreElements()) {
//                String key = keys.nextElement();
//                String value = validCreditCards.getString(key);
//
//                if (providedCardNumber.equals(key) && providedPin.equals(value)) {
//                    isCardValid = true;
//                }
//
//            }
//
//            if (isCardValid) {
//                ConsoleHelper.writeMessage("Verification was successful");
//                break;
//            } else {
//                ConsoleHelper.writeMessage("Verification failed.");
//                continue;
//            }

        }

    }

//    //todo: wywal
//    public static void main(String[] args) throws InterruptedOperationException{
//        LoginCommand loginCommand = new LoginCommand();
//        loginCommand.execute();
//    }


}