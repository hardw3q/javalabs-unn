package com.pixels.cpu.impl;

import com.pixels.command.ICommand;
import com.pixels.cpu.ICpu;

public class ICpuImpl implements ICpu {
    public int[] registers = new int[4];
    public int[] memory = new int[1024];



    public void printRegisters() {
        System.out.println("Registers: " + java.util.Arrays.toString(registers));
    }

    @Override
    public void exec(ICommand c) {
        c.execute(this);
    }
}
