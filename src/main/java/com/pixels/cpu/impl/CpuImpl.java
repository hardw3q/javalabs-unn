package com.pixels.cpu.impl;

import com.pixels.command.ICommand;
import com.pixels.cpu.ICpu;

import java.util.HashMap;

public class CpuImpl implements ICpu {
    public HashMap<Character, Integer> registers = new HashMap<>();
    public int[] memory = new int[1024];

    public CpuImpl() {
        registers.put('a', 0);
        registers.put('b', 0);
        registers.put('c', 0);
        registers.put('d', 0);
    }
    public void printRegisters() {
        System.out.println("Registers: " + registers.toString());
    }

    @Override
    public void exec(ICommand c) {
        c.execute(this);
    }
}
