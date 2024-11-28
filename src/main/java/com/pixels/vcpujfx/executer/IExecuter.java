package com.pixels.vcpujfx.executer;


import com.pixels.vcpujfx.program.impl.Program;

public interface IExecuter {
    public void run();
    public void loadProgram(Program program);
    public void nextInstruction();
    public int getIP();
    public void resetExecutor();

}
