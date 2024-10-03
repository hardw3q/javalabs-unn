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
                new InitCommand(0),
                new AddCommand(0, 10),
                new PrintCommand(0),
                new AddCommand(0, 5),
                new PrintCommand(0),
                new MulCommand(0, 2), // multiply register 0 by 2
                new PrintCommand(0),
                new DivCommand(0, 4), // divide register 0 by 4
                new PrintCommand(0),
                new SaveCommand(0, 10), // save register 0 to memory address 10
                new LoadCommand(1, 10), // load from memory address 10 to register 1
                new PrintCommand(1),
        };
        ICpuImpl cpu = BCpu.build();
        for (ICommand c : prog) {
            cpu.exec(c);
        }
        cpu.printRegisters();
    }
}
