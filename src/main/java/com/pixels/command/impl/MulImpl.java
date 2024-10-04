package com.pixels.command.impl;

import com.pixels.command.ICommand;
import com.pixels.cpu.impl.ICpuImpl;

public class MulImpl implements ICommand {
    private int reg;
    private int val;

    public MulImpl(int register, int value) {
        this.reg = register;
        this.val = value;
    }

    @Override
    public void execute(ICpuImpl cpu) {
        cpu.registers[reg] *= val;
    }
}
