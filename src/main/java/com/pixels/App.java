package com.pixels;

import com.pixels.command.ICommand;
import com.pixels.command.impl.*;
import com.pixels.cpu.BCpu;
import com.pixels.cpu.impl.ICpuImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ICommand prog[] = {
                new InitImpl(1, 20),
                new LoadImpl(1, 1),
                new InitImpl(2, 10),
                new LoadImpl(2, 2),
                new AddImpl(1,2),
                new PrintImpl(1),
        };
        ICpuImpl cpu = BCpu.build();
        for (ICommand c : prog) {
            cpu.exec(c);
        }
        cpu.printRegisters();
    }
}
