package com.pixels.command.impl;

import com.pixels.command.ICommand;
import com.pixels.cpu.impl.ICpuImpl;

public class DivImpl implements ICommand {
    private int reg;
    private int val;

    public DivImpl(int register, int value) {
        this.reg = register;
        this.val = value;
    }

    @Override
    public void execute(ICpuImpl cpu) {
        if (val != 0) {
            cpu.registers[reg] /= val;
        } else {
            System.out.println("Error: Division by zero!");
        }
    }
}
