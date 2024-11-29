package com.pixels.vcpujfx;

import com.pixels.vcpujfx.executer.impl.Executor;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;

public class InstructionListCell extends ListCell<String> {
    private final HBox content;
    private final Label label;
    private final Button deleteButton;
    private final Button upButton;
    private final Button downButton;
    private Executor e;


    public InstructionListCell(Executor e) {
        this.e = e;
        label = new Label();
        deleteButton = new Button("Delete");
        upButton = new Button("Up");
        downButton = new Button("Down");


        deleteButton.setOnAction(event -> {
            if(e.isRunning){
                alertExсeption();
                return;
            }
            getListView().getItems().remove(getItem());
        });
        upButton.setOnAction(event -> {
            if(e.isRunning){
                alertExсeption();
                return;

            }
            int currentIndex = getIndex();
            if (currentIndex > 0) {
                swapItems(getListView(), currentIndex, currentIndex - 1);
            }
        });

        downButton.setOnAction(event -> {
            if(e.isRunning){
                alertExсeption();
                return;

            }
            int currentIndex = getIndex();
            if (currentIndex < getListView().getItems().size() - 1) {
                swapItems(getListView(), currentIndex, currentIndex + 1);
            }
        });

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        content = new HBox(label, spacer,upButton, downButton,  deleteButton);
        content.setSpacing(10);
    }
    private void alertExсeption(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Ошибка");
        alert.setHeaderText("Программа запущена");
        alert.showAndWait();
    }
    private void swapItems(ListView<String> listView, int index1, int index2) {
        var items = listView.getItems();
        String temp = items.get(index1);
        items.set(index1, items.get(index2));
        items.set(index2, temp);

        listView.getSelectionModel().select(index2);
    }
    @Override
    protected void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);
        if (empty || item == null) {
            setGraphic(null);
        } else {
            label.setText(item);

            setGraphic(content);
        }
    }

}