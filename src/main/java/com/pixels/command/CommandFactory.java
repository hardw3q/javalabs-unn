package com.pixels.command;

import com.pixels.command.ICommand;
import com.pixels.command.impl.*;


public class CommandFactory {

    public static ICommand getCommand(String commandName, String... args) {
        switch (commandName) {
            case "init":
                return new InitImpl(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
            case "add":
                return new AddImpl(args[0].toCharArray()[0],args[1].toCharArray()[0]);
            case "mult":
                return new MulImpl(args[0].toCharArray()[0], args[1].toCharArray()[0]);
            case "ld":
                return new LoadImpl(args[0].toCharArray()[0], Integer.parseInt(args[1]));
            case "print":
                return new PrintImpl(args[0].toCharArray()[0]);
            default:
                throw new UnsupportedOperationException("Unknown instruction: " + commandName);
        }
    }
}
