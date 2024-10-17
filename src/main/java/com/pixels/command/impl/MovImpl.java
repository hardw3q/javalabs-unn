package com.pixels.command.impl;

import com.pixels.cpu.impl.CpuImpl;

public class MovImpl extends Command {
    private Character reg1;
    private Character reg2;
    public MovImpl(Character reg1, Character reg2){
        this.reg1 = reg1;
        this.reg2 = reg2;
    }
    @Override
    public void execute(CpuImpl cpu) {
        int value = cpu.registers.get(reg2);
        cpu.registers.put(reg1, value);
    }
}
