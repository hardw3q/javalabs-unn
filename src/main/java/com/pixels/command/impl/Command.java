package com.pixels.command.impl;


import com.pixels.command.ICommand;
import com.pixels.cpu.impl.CpuImpl;

public class Command implements ICommand {
    public void execute(CpuImpl cpu){

    };

    public static Command createCommand(String instruction, String ...params) {

        switch (instruction) {
            case "init":
                return new InitImpl(Integer.parseInt(params[0]), Integer.parseInt(params[1]));
            case "add":
                return new AddImpl(params[0].toCharArray()[0],params[1].toCharArray()[0]);
            case "mult":
                return new MulImpl(params[0].toCharArray()[0], params[1].toCharArray()[0]);
            case "ld":
                return new LoadImpl(params[0].toCharArray()[0], Integer.parseInt(params[1]));
            case "print":
                return new PrintImpl(params[0].toCharArray()[0]);
            default:
                throw new UnsupportedOperationException("Unknown instruction: " + instruction);
        }
    }
}
