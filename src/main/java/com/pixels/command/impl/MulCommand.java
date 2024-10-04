package com.pixels.command.impl;

import com.pixels.command.ICommand;
import com.pixels.cpu.ICpu;
import com.pixels.cpu.impl.ICpuImpl;

public class MulCommand implements ICommand {
    private int register;
    private int value;

    public MulCommand(int register, int value) {
        this.register = register;
        this.value = value;
    }

    @Override
    public void execute(ICpuImpl cpu) {
        cpu.registers[register] *= value;
    }
}
