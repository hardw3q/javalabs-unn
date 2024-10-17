package com.pixels.command;

import com.pixels.cpu.impl.Cpu;

public interface ICommand {
    void execute(Cpu cpu);
}
