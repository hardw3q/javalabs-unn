package com.pixels;

import com.pixels.command.ICommand;
import com.pixels.command.impl.*;
import com.pixels.cpu.BCpu;
import com.pixels.cpu.impl.CpuImpl;


public class App 
{
    public static void main( String[] args )
    {
        ICommand prog[] = {
                new LoadImpl('a', 1 ),
                new PrintImpl('a')
        };
        CpuImpl cpu = BCpu.build();
        for (ICommand c : prog) {
            cpu.exec(c);
        }
        cpu.printRegisters();
    }
}
