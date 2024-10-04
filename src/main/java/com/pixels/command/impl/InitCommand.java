package com.pixels.command.impl;

import com.pixels.command.ICommand;
import com.pixels.cpu.ICpu;
import com.pixels.cpu.impl.ICpuImpl;

public class InitCommand implements ICommand {
    private int register;

    public InitCommand(int register) {
        this.register = register;
    }

    @Override
    public void execute(ICpuImpl cpu) {
        cpu.registers[register] = 0;
    }
}
