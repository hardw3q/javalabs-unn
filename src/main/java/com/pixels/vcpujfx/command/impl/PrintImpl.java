package com.pixels.vcpujfx.command.impl;

import com.pixels.vcpujfx.command.CommandFactory;
import com.pixels.vcpujfx.command.ICommand;
import com.pixels.vcpujfx.cpu.impl.Cpu;

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
