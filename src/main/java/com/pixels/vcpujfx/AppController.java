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

public class AppController {

    @FXML
    private ListView<String> instructionList;
    @FXML
    private Button addButton;
    @FXML
    private TextField instructionInput;

    private Program program;

    private Alert noSuchInstruction;

    private Executor e;
    @FXML
    public void initialize() {
        noSuchInstruction = new Alert(Alert.AlertType.ERROR);
        noSuchInstruction.setTitle("No such instruction");
        noSuchInstruction.setHeaderText("No such instruction");
        program = new Program();
        e = new Executor(new Cpu());
        // Устанавливаем фабрику ячеек для ListView
        instructionList.setCellFactory(listView -> new CustomListCell());
        addButton.setOnAction(event -> {
            try{
                String instruction = instructionInput.getText();

                if (instruction != null && !instruction.isEmpty()) {
                    program.addCommand(new Command(instruction));
                    // Добавляем текст в ListView
                    instructionList.getItems().add(instruction);
                    // Очищаем поле ввода
                    instructionInput.clear();
                }
            }catch (Exception e){
                noSuchInstruction.setContentText(e.getMessage());
                noSuchInstruction.showAndWait();
                return;
            }
        });
    }

    // Внутренний класс для настройки ячеек
    private static class CustomListCell extends ListCell<String> {
        private final HBox content;
        private final Label label;
        private final Button deleteButton;
        private final Button upButton;
        private final Button downButton;


        public CustomListCell() {
            label = new Label();
            deleteButton = new Button("Delete");
            upButton = new Button("Up");
            downButton = new Button("Down");


            // Обработчик кнопки Delete
            deleteButton.setOnAction(event -> {
                // Удаляем текущий элемент из списка
                getListView().getItems().remove(getItem());
            });
            upButton.setOnAction(event -> {
                int currentIndex = getIndex();
                if (currentIndex > 0) {
                    // Меняем местами с предыдущим элементом
                    swapItems(getListView(), currentIndex, currentIndex - 1);
                }
            });

            // Обработчик кнопки "Down"
            downButton.setOnAction(event -> {
                int currentIndex = getIndex();
                if (currentIndex < getListView().getItems().size() - 1) {
                    // Меняем местами с следующим элементом
                    swapItems(getListView(), currentIndex, currentIndex + 1);
                }
            });

            // Создаем пустое пространство между текстом и кнопкой
            Region spacer = new Region();
            HBox.setHgrow(spacer, Priority.ALWAYS);

            // Компонуем ячейку
            content = new HBox(label, spacer,upButton, downButton,  deleteButton);
            content.setSpacing(10); // Расстояние между элементами
        }
        private void swapItems(ListView<String> listView, int index1, int index2) {
            var items = listView.getItems();
            String temp = items.get(index1);
            items.set(index1, items.get(index2));
            items.set(index2, temp);

            // Обновляем выделение после перемещения
            listView.getSelectionModel().select(index2);
        }
        @Override
        protected void updateItem(String item, boolean empty) {
            super.updateItem(item, empty);
            if (empty || item == null) {
                setGraphic(null); // Очищаем содержимое ячейки, если она пустая
            } else {
                label.setText(item); // Устанавливаем текст инструкции
                setGraphic(content); // Устанавливаем компоновку HBox
            }
        }

    }

}
