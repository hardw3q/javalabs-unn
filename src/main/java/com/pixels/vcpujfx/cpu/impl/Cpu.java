package com.pixels.vcpujfx.cpu.impl;



import com.pixels.vcpujfx.InstructionListCell;
import com.pixels.vcpujfx.command.impl.Command;
import com.pixels.vcpujfx.cpu.ICpu;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Cpu implements ICpu {
    public HashMap<Character, Integer> registers = new HashMap<>();
    public int[] memory = new int[1024];

    public Cpu() {
        registers.put('a', 0);
        registers.put('b', 0);
        registers.put('c', 0);
        registers.put('d', 0);
    }
    public ObservableList<String> getRegistersList() {
        ObservableList<String> result = FXCollections.observableArrayList();
        for (Character key : registers.keySet()) {
            result.add(key + "=" + registers.get(key));
        }
        return result;
    }
    public ObservableList<String> getMemoryList() {
        ObservableList<String> result = FXCollections.observableArrayList();
        for (int i = 0; i < memory.length; i++) {
            result.add(i + ":" + memory[i]);
        }
        return result;
    }

    public void printRegisters() {
        System.out.println("Registers: " + registers.toString());
    }

    @Override
    public void exec(Command c) {
        c.execute(this);
    }


}
