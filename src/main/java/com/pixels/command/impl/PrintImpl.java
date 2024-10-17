package com.pixels.command.impl;

import com.pixels.cpu.impl.CpuImpl;

public class PrintImpl extends Command{
        private Character reg;

        public PrintImpl(Character register) {
            this.reg = register;
        }

        @Override
        public void execute(CpuImpl cpu) {
            System.out.println("Register " + reg + ": " + cpu.registers.get(reg));
        }
}
