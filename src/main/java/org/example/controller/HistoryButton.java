package org.example.controller;


import javafx.scene.control.Button;
import org.example.staticValue.CalculatorSize;

public class HistoryButton extends Button {
    private final String buttonName = "历史记录";
    public HistoryButton(){
        this.setText(buttonName);
        this.setLayoutY(0);
        this.setPrefSize(100,50);
        this.setLayoutX(CalculatorSize.width-100);
    }
}
