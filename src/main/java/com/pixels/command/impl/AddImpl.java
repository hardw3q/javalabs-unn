package com.pixels.command.impl;

import com.pixels.command.ICommand;
import com.pixels.cpu.impl.ICpuImpl;

public class AddImpl implements ICommand {
    private int reg;
    private int reg2;

    public AddImpl(int register1, int register2) {
        this.reg = register1;
        this.reg2 = register2;
    }

    @Override
    public void execute(ICpuImpl cpu) {
        cpu.registers[reg] += cpu.registers[reg2];

    }
}
