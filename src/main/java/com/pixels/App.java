package com.pixels;

import com.pixels.command.ICommand;
import com.pixels.command.impl.*;
import com.pixels.cpu.BCpu;
import com.pixels.cpu.impl.CpuImpl;


public class App 
{
    public static void main( String[] args )
    {
        Command prog[] = {
                new Command("init", "1", "20"),
                new Command("ld a 1"),
                new Command("print", "a")
        };
        CpuImpl cpu = BCpu.build();
        for (Command c : prog) {
            cpu.exec(c);
        }
        cpu.printRegisters();
    }
}
