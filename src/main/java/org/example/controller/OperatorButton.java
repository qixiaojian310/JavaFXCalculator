package org.example.controller;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class OperatorButton extends Button {
    private final String operator;
    private final int rowNum;
    private final int columnNum;

    public OperatorButton(String operator, int rowNum, int columnNum) {
        this.columnNum = columnNum;
        this.rowNum = rowNum;
        this.operator = operator;
        this.setText(operator);
        this.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                System.out.println(operator);
            }
        });
    }

    public String inputOperator() {
        return operator;
    }
    public int[] getButtonPosition(){
        return new int[]{rowNum, columnNum};
    }
}
