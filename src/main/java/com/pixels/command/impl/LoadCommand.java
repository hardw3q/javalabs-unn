package com.pixels.command.impl;

import com.pixels.command.ICommand;
import com.pixels.cpu.impl.ICpuImpl;

public class LoadCommand implements ICommand {
    private int register;
    private int memoryAddress;

    public LoadCommand(int register, int memoryAddress) {
        this.register = register;
        this.memoryAddress = memoryAddress;
    }

    @Override
    public void execute(ICpuImpl cpu) {
        cpu.registers[register] = cpu.memory[memoryAddress];
    }
}
