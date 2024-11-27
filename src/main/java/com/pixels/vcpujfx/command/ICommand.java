package com.pixels.vcpujfx.command;


import com.pixels.vcpujfx.cpu.impl.Cpu;

public interface ICommand {
    void execute(Cpu cpu);
}
