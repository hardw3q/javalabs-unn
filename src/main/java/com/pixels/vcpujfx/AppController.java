package com.pixels.vcpujfx;

import com.pixels.vcpujfx.command.impl.Command;
import com.pixels.vcpujfx.cpu.impl.Cpu;
import com.pixels.vcpujfx.executer.impl.Executor;
import com.pixels.vcpujfx.program.impl.Program;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class AppController {

    @FXML
    private ListView<String> instructionList;
    @FXML
    private Button addButton;
    @FXML
    private Button runButton;
    @FXML
    private Button resButton;
    @FXML
    private Button nextButton;
    @FXML
    private TextField instructionInput;
    @FXML
    private ListView<String> registerList;
    @FXML
    private ListView<String> memoryList;
    @FXML
    private ListView<String> statList;
    private Alert noSuchInstruction;
    private Cpu cpu;
    private Executor e;

    @FXML
    public void initialize() {
        noSuchInstruction = new Alert(Alert.AlertType.ERROR);
        noSuchInstruction.setTitle("No such instruction");
        noSuchInstruction.setHeaderText("No such instruction");
        hardwareInitialization();
        updateRegistries();
        updateMemory();
        instructionList.setCellFactory(listView -> new InstructionListCell());
        runButton.setOnAction(event -> runProgram());
        resButton.setOnAction(actionEvent -> resetProgram());
        addButton.setOnAction(event -> addInstruction());
        nextButton.setOnAction(event -> nextInstruction());
    }
    private void hardwareInitialization(){
        cpu = new Cpu();
        e = new Executor(cpu);
    }
    private void updateRegistries(){
        registerList.getItems().clear();
        registerList.setItems(cpu.getRegistersList());
    }
    private void updateMemory(){
        memoryList.getItems().clear();
        memoryList.setItems(cpu.getMemoryList());
    }
    private void addInstruction(){
        try{
            String instruction = instructionInput.getText();

            if (instruction != null && !instruction.isEmpty()) {
                new Command(instruction);
                instructionList.getItems().add(instruction);
                instructionInput.clear();
            }
            updateStat();
        }catch (Exception e){
            noSuchInstruction.setContentText(e.getMessage());
            noSuchInstruction.showAndWait();
        }
    }
    private void updateStat(){
        statList.getItems().clear();
        Program program = new Program();

        for(String instruction : instructionList.getItems()){
            System.out.println(instruction);
            program.addCommand(new Command(instruction));
        }
        statList.setItems(program.getFrequencyListObservable());
    }
    private void runProgram(){
        Program program = new Program();

        for(String instruction : instructionList.getItems()){
            System.out.println(instruction);
            program.addCommand(new Command(instruction));
        }
        e.loadProgram(program);
        e.run();
        cpu.printRegisters();
        instructionList.getSelectionModel().select(e.getIP());
        updateRegistries();
        updateMemory();
    }
    private void nextInstruction(){

        e.nextInstruction();
        instructionList.getSelectionModel().select(e.getIP());
        updateRegistries();
        updateMemory();
    }
    private void setSelection(int id){

    }
    private void resetProgram(){

        e.resetExecutor();
        hardwareInitialization();
        updateRegistries();
        updateMemory();
        updateStat();

        instructionList.getSelectionModel().clearSelection();
    }
}
