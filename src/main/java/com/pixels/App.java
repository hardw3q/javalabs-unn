package com.pixels;

import com.pixels.command.impl.*;
import com.pixels.cpu.impl.Cpu;
import com.pixels.executer.impl.Executor;
import com.pixels.program.impl.Program;


public class App 
{
    public static void main( String[] args )
    {
        Program prog = new Program();
        prog.addCommand(new Command("init 10 20"));
        prog.addCommand(new Command("init" ,"11", "25"));
        prog.addCommand(new Command("ld", "a" ,"10"));
        prog.addCommand(new Command("ld", "b" ,"11"));
        prog.addCommand(new Command("ld", "c" ,"11"));
        prog.addCommand(new Command("add a c"));
        prog.addCommand(new Command("mv", "a" ,"d"));
        prog.addCommand(new Command("add a d"));
        prog.addCommand(new Command("print a"));
        Cpu cpu = new Cpu();
        Executor exec = new Executor(cpu);
        exec.run(prog);
        cpu.printRegisters();
    }
}
