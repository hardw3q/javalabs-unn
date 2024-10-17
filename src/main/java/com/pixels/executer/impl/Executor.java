package com.pixels.executer.impl;

import com.pixels.command.impl.Command;
import com.pixels.cpu.impl.Cpu;
import com.pixels.executer.IExecuter;
import com.pixels.program.impl.Program;

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
