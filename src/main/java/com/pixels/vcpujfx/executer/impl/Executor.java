package com.pixels.vcpujfx.executer.impl;


import com.pixels.vcpujfx.command.impl.Command;
import com.pixels.vcpujfx.cpu.impl.Cpu;
import com.pixels.vcpujfx.executer.IExecuter;
import com.pixels.vcpujfx.program.impl.Program;

public class Executor implements IExecuter {
    private Cpu cpu;
    public Executor(Cpu cpu){
        this.cpu = cpu;
    }
    @Override
    public void run(Program program) {
        for (Command c : program.getCommands()) {
            cpu.exec(c);
        }
    }
}
