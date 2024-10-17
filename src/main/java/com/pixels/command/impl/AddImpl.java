package com.pixels.command.impl;

import com.pixels.command.ICommand;
import com.pixels.cpu.impl.Cpu;

public class AddImpl implements ICommand {
    private Character reg;
    private Character reg2;

    public AddImpl(Character register1, Character register2) {
        this.reg = register1;
        this.reg2 = register2;
    }

    @Override
    public void execute(Cpu cpu) {
        int value1 = cpu.registers.get(reg);
        int value2 = cpu.registers.get(reg2);
        int result = value1 + value2;
        cpu.registers.put(reg, result);

    }
}
