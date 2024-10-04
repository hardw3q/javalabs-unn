package com.pixels.command.impl;

import com.pixels.command.ICommand;
import com.pixels.cpu.impl.ICpuImpl;

public class DivImpl implements ICommand {
    private int reg1;
    private int reg2;

    public DivImpl(int reg1, int reg2) {
        this.reg1 = reg1;
        this.reg2 = reg2;
    }

    @Override
    public void execute(ICpuImpl cpu) {
        if (cpu.registers[reg2] != 0) {
            cpu.registers[reg1] /= reg2;
        } else {
            System.out.println("Error: Division by zero!");
        }
    }
}
