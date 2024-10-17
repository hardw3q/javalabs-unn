package com.pixels.command.impl;

import com.pixels.command.ICommand;
import com.pixels.cpu.impl.Cpu;

public class StImpl implements ICommand {
    private Character reg;
    private int memoryAddress;

    public StImpl(Character register, int memoryAddress) {
        this.reg = register;
        this.memoryAddress = memoryAddress;
    }

    @Override
    public void execute(Cpu cpu) {
        int value = cpu.registers.get(reg);
        cpu.memory[memoryAddress] = value;    }
}
