package com.pixels.vcpujfx.command.impl;

import com.pixels.vcpujfx.command.CommandFactory;
import com.pixels.vcpujfx.command.ICommand;
import com.pixels.vcpujfx.cpu.impl.Cpu;
public class LoadImpl implements ICommand {
    private Character reg;
    private int memoryAddress;

    public LoadImpl(Character register, int memoryAddress) {
        this.reg = register;
        this.memoryAddress = memoryAddress;
    }

    @Override
    public void execute(Cpu cpu) {
        int value = cpu.memory[memoryAddress];
        cpu.registers.put(reg, value);    }
}
