package com.pixels.program;

import com.pixels.command.impl.Command;

import java.util.List;

public interface IProgram {
    List<Command> getCommands(); // Получить список всех команд
    Command getMostFrequentCommand(); // Наиболее часто встречающаяся команда
    int[] getMemoryAddressRange(); // Диапазон адресов памяти
    List<Command> getCommandsSortedByFrequency();
    public void addCommand(Command command);// Список команд, отсортированных по частоте
}
