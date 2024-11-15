package com.pixels.command.impl;


import com.pixels.command.CommandFactory;
import com.pixels.command.ICommand;
import com.pixels.cpu.impl.Cpu;


public class Command {
    public String name;
    private String[] args;
    private ICommand command;

    public Command(String command) {
        String[] parts = command.split(" ");
        this.name = parts[0];
        this.args = new String[parts.length - 1];
        System.arraycopy(parts, 1, this.args, 0, this.args.length);

        this.command = CommandFactory.getCommand(this.name, this.args);
    }

    public Command(String name, String... args) {
        this.name = name;
        this.args = args;

        this.command = CommandFactory.getCommand(this.name, this.args);
    }

    public void execute(Cpu cpu) {
        this.command.execute(cpu);
    }
}
