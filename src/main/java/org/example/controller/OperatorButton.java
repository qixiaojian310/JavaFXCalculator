package org.example.controller;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import org.example.event.OperatorButtonClickEvent;

public class OperatorButton extends Button {
    private final String operator;
    private final int rowNum;
    private final int columnNum;

    public OperatorButton(String operator, int rowNum, int columnNum) {
        this.columnNum = columnNum;
        this.rowNum = rowNum;
        this.operator = operator;
        this.setText(operator);
        this.setStyle("-fx-font-size: 24px;");
        this.setOnAction((event)->{
            Event.fireEvent(this,new OperatorButtonClickEvent());
        });
    }
    public String inputOperator() {
        return operator;
    }
    public int[] getButtonPosition(){
        return new int[]{rowNum, columnNum};
    }
}
