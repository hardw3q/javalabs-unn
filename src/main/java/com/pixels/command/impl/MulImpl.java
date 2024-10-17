package com.pixels.command.impl;

import com.pixels.command.ICommand;
import com.pixels.cpu.impl.Cpu;

public class MulImpl implements ICommand {
    private Character reg1;
    private Character reg2;
    public MulImpl(Character reg1, Character reg2) {
        this.reg1 = reg1;
        this.reg2 = reg2;
    }

    @Override
    public void execute(Cpu cpu) {
        int value1 = cpu.registers.get(reg1);
        int value2 = cpu.registers.get(reg2);
        int result = value1 * value2;
        cpu.registers.put(reg1, result);    }
}
