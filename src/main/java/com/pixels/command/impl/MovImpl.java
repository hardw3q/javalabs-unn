package com.pixels.command.impl;

import com.pixels.command.ICommand;
import com.pixels.cpu.impl.Cpu;

public class MovImpl implements ICommand {
    private Character reg1;
    private Character reg2;
    public MovImpl(Character reg1, Character reg2){
        this.reg1 = reg1;
        this.reg2 = reg2;
    }
    @Override
    public void execute(Cpu cpu) {
        int value = cpu.registers.get(reg2);
        cpu.registers.put(reg1, value);
    }
}
