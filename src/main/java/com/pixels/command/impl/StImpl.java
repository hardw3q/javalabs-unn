package com.pixels.command.impl;

import com.pixels.command.ICommand;
import com.pixels.cpu.impl.ICpuImpl;

public class StImpl implements ICommand {
    private Character reg;
    private int memoryAddress;

    public StImpl(Character register, int memoryAddress) {
        this.reg = register;
        this.memoryAddress = memoryAddress;
    }

    @Override
    public void execute(ICpuImpl cpu) {
        int value = cpu.registers.get(reg);
        cpu.memory[memoryAddress] = value;    }
}
