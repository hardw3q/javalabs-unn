package com.pixels.command.impl;

import com.pixels.command.ICommand;
import com.pixels.cpu.impl.Cpu;

public class PrintImpl implements ICommand {
        private Character reg;

        public PrintImpl(Character register) {
            this.reg = register;
        }

        @Override
        public void execute(Cpu cpu) {
            System.out.println("Register " + reg + ": " + cpu.registers.get(reg));
        }
}
