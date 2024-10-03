package com.pixels.command;

import com.pixels.cpu.ICpu;
import com.pixels.cpu.impl.ICpuImpl;

public interface ICommand {
    void execute(ICpuImpl cpu);
}
