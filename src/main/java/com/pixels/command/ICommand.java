package com.pixels.command;

import com.pixels.cpu.impl.CpuImpl;

public interface ICommand {
    void execute(CpuImpl cpu);
}
