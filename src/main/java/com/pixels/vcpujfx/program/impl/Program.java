package com.pixels.vcpujfx.program.impl;



import com.pixels.vcpujfx.command.impl.Command;
import com.pixels.vcpujfx.program.IProgram;

import java.util.*;
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
                .collect(Collectors.groupingBy(
                        command -> command.name,
                        Collectors.counting()
                ))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(entry -> commands.stream()
                        .filter(command -> command.name.equals(entry.getKey()))
                        .findFirst()
                        .orElseThrow()) // Выбрасывает исключение, если команды с этим именем нет
                .orElseThrow(() -> new NoSuchElementException("Список команд пуст."));
    }

    @Override
    public int[] getMemoryAddressRange() {
        return new int[0];
    }

    @Override
    public List<Command> getCommandsSortedByFrequency() {
        Map<String, Long> frequencyMap = commands.stream()
                .collect(Collectors.groupingBy(
                        command -> command.name,
                        Collectors.counting()
                ));

        Map<String, Command> uniqueCommandsByName = commands.stream()
                .collect(Collectors.toMap(
                        command -> command.name,    // Ключ — имя команды
                        command -> command,         // Значение — сам объект команды
                        (existing, replacement) -> existing // Если есть дубликаты, оставляем первый
                ));

        return uniqueCommandsByName.values().stream()
                .sorted(Comparator.comparingLong(
                        command -> -frequencyMap.get(command.name))) // Убывающая сортировка по частоте
                .collect(Collectors.toList());
    }
}
