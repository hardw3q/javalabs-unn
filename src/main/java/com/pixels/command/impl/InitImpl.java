package com.pixels.command.impl;

import com.pixels.command.ICommand;
import com.pixels.cpu.impl.CpuImpl;

public class InitImpl implements ICommand {
    private int memoryAddress;
    private int val;

    public InitImpl(int memoryAddress, int val) {
        this.memoryAddress = memoryAddress;
        this.val = val;
    }

    @Override
    public void execute(CpuImpl cpu) {
        cpu.memory[memoryAddress] = val;
    }
}
