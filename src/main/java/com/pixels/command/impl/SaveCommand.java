package com.pixels.command.impl;

import com.pixels.command.ICommand;
import com.pixels.cpu.impl.ICpuImpl;

public class SaveCommand implements ICommand {
    private int register;
    private int memoryAddress;

    public SaveCommand(int register, int memoryAddress) {
        this.register = register;
        this.memoryAddress = memoryAddress;
    }

    @Override
    public void execute(ICpuImpl cpu) {
        cpu.memory[memoryAddress] = cpu.registers[register];
    }
}
