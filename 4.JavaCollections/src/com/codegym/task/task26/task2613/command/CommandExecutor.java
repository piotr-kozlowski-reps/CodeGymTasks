package com.codegym.task.task26.task2613.command;

import com.codegym.task.task26.task2613.Operation;

import java.util.HashMap;
import java.util.Map;

public class CommandExecutor {

    //field
    private static final Map<Operation, Command> allKnownCommandsMap;

    //init
    static{
        allKnownCommandsMap = new HashMap<>();
        allKnownCommandsMap.put(Operation.INFO, new InfoCommand());
        allKnownCommandsMap.put(Operation.DEPOSIT, new DepositCommand());
        allKnownCommandsMap.put(Operation.WITHDRAW, new WithdrawCommand());
        allKnownCommandsMap.put(Operation.EXIT, new ExitCommand());
    }

    //contr
    private CommandExecutor(){}


    public static final void execute(Operation operation) {
        allKnownCommandsMap.get(operation).execute();


    }

}
