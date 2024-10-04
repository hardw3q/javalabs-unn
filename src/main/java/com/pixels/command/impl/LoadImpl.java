package com.pixels.command.impl;

import com.pixels.command.ICommand;
import com.pixels.cpu.impl.ICpuImpl;

public class LoadImpl implements ICommand {
    private int reg;
    private int memoryAddress;

    public LoadImpl(int register, int memoryAddress) {
        this.reg = register;
        this.memoryAddress = memoryAddress;
    }

    @Override
    public void execute(ICpuImpl cpu) {
        cpu.registers[reg] = cpu.memory[memoryAddress];
    }
}
