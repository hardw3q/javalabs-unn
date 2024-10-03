package com.pixels.command.impl;

import com.pixels.command.ICommand;
import com.pixels.cpu.impl.ICpuImpl;

public class PrintCommand implements ICommand {
        private int register;

        public PrintCommand(int register) {
            this.register = register;
        }

        @Override
        public void execute(ICpuImpl cpu) {
            System.out.println("Register " + register + ": " + cpu.registers[register]);
        }
}
