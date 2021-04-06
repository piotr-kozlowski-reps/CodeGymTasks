package com.codegym.task.task26.task2613.command;

import com.codegym.task.task26.task2613.ConsoleHelper;

class ExitCommand implements Command {
    @Override
    public void execute() {
        ConsoleHelper.writeMessage("Do you really want to exit? [yes (y) or no (n)]");
        String answer = ConsoleHelper.readString();
        if (answer.equals("y")) ConsoleHelper.writeMessage("goodbye");
        else System.exit(0);
    }
}