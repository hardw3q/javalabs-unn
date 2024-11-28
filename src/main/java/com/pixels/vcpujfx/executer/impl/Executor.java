package com.pixels.vcpujfx.executer.impl;


import com.pixels.vcpujfx.command.impl.Command;
import com.pixels.vcpujfx.cpu.impl.Cpu;
import com.pixels.vcpujfx.executer.IExecuter;
import com.pixels.vcpujfx.program.impl.Program;

public class Executor implements IExecuter {
    private Cpu cpu;
    private int instructionPointer = -1;
    private Program program = null;
    public Executor(Cpu cpu){
        this.cpu = cpu;
    }
    @Override
    public void run() {
        cpu.exec(program.getCommands().get(instructionPointer));
    }

    @Override
    public void loadProgram(Program program) {
        this.program = program;
        instructionPointer = 0;
    }

    @Override
    public void nextInstruction() {
        if(instructionPointer == program.getCommands().size() - 1){
            instructionPointer = 0;
        }else {
            instructionPointer++;
        }
        run();
    }
    @Override
    public int getIP() {
        return instructionPointer;
    }

    @Override
    public void resetExecutor() {
        program = null;
        instructionPointer = -1;
    }

}
