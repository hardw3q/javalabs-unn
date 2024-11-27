package com.pixels.vcpujfx.command.impl;

import com.pixels.vcpujfx.command.CommandFactory;
import com.pixels.vcpujfx.command.ICommand;
import com.pixels.vcpujfx.cpu.impl.Cpu;

public class InitImpl implements ICommand {
    private int memoryAddress;
    private int val;

    public InitImpl(int memoryAddress, int val) {
        this.memoryAddress = memoryAddress;
        this.val = val;
    }

    @Override
    public void execute(Cpu cpu) {
        cpu.memory[memoryAddress] = val;
    }
}
