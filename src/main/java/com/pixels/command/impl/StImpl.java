package com.pixels.command.impl;

import com.pixels.command.ICommand;
import com.pixels.cpu.impl.ICpuImpl;

public class StImpl implements ICommand {
    private int reg;
    private int memoryAddress;

    public StImpl(int register, int memoryAddress) {
        this.reg = register;
        this.memoryAddress = memoryAddress;
    }

    @Override
    public void execute(ICpuImpl cpu) {
        cpu.memory[memoryAddress] = cpu.registers[reg];
    }
}
