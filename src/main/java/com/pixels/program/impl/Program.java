package com.pixels.program.impl;

import com.pixels.command.ICommand;
import com.pixels.command.impl.Command;
import com.pixels.cpu.impl.Cpu;
import com.pixels.program.IProgram;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Program implements IProgram {
    private final List<Command> commands; // Список команд
    public Program(List<Command> commands) {
        this.commands = new ArrayList<>(commands);
    }
    public Program() {
        this.commands = new ArrayList<>();
    }
    @Override
    public List<Command> getCommands() {
        return Collections.unmodifiableList(commands);
    }
    @Override
    public void addCommand(Command command) {
        commands.add(command); // Добавляем команду в список программы
    }
    @Override
    public Command getMostFrequentCommand() {
        return commands.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())) // Группировка команд по количеству их появления
                .entrySet().stream()
                .max(Map.Entry.comparingByValue()) // Поиск команды с максимальным количеством
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    @Override
    public int[] getMemoryAddressRange() {
        return new int[0];
    }

    @Override
    public List<Command> getCommandsSortedByFrequency() {
        return commands.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<Command, Long>comparingByValue().reversed())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}
