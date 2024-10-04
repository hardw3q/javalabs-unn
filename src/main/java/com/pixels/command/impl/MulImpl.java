package com.pixels.command.impl;

import com.pixels.command.ICommand;
import com.pixels.cpu.impl.ICpuImpl;

public class MulImpl implements ICommand {
    private int reg1;
    private int reg2;

    public MulImpl(int reg1, int reg2) {
        this.reg1 = reg1;
        this.reg2 = reg2;
    }

    @Override
    public void execute(ICpuImpl cpu) {
        cpu.registers[reg1] *= cpu.registers[reg2];
    }
}
