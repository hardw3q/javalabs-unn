package com.pixels.command.impl;

import com.pixels.cpu.impl.CpuImpl;

public class StImpl extends Command {
    private Character reg;
    private int memoryAddress;

    public StImpl(Character register, int memoryAddress) {
        this.reg = register;
        this.memoryAddress = memoryAddress;
    }

    @Override
    public void execute(CpuImpl cpu) {
        int value = cpu.registers.get(reg);
        cpu.memory[memoryAddress] = value;    }
}
