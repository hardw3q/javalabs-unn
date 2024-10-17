package com.pixels.command.impl;

import com.pixels.command.ICommand;
import com.pixels.cpu.impl.CpuImpl;

public class LoadImpl implements ICommand {
    private Character reg;
    private int memoryAddress;

    public LoadImpl(Character register, int memoryAddress) {
        this.reg = register;
        this.memoryAddress = memoryAddress;
    }

    @Override
    public void execute(CpuImpl cpu) {
        int value = cpu.memory[memoryAddress];
        cpu.registers.put(reg, value);    }
}
