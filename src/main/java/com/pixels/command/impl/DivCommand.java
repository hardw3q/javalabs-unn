package com.pixels.command.impl;

import com.pixels.command.ICommand;
import com.pixels.cpu.ICpu;
import com.pixels.cpu.impl.ICpuImpl;

public class DivCommand implements ICommand {
    private int register;
    private int value;

    public DivCommand(int register, int value) {
        this.register = register;
        this.value = value;
    }

    @Override
    public void execute(ICpuImpl cpu) {
        if (value != 0) {
            cpu.registers[register] /= value;
        } else {
            System.out.println("Error: Division by zero!");
        }
    }
}
