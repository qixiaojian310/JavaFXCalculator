package org.example.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import org.example.event.OperatorButtonClickEvent;

public class OperatorButton extends JFXButton {
    private final String operator;

    public OperatorButton(String operator) {
        this.operator = operator;
        this.setText(operator);
        this.setPrefSize(80,80);
        this.setAlignment(Pos.CENTER);
        this.setStyle("-fx-font-size: 24px;-fx-border-radius: 50%;-fx-background-radius: 50%;-jfx-button-type: RAISED;-fx-background-color:black;-fx-text-fill: white;");
        this.setOnAction((event)->{
            Event.fireEvent(this,new OperatorButtonClickEvent());
        });
    }
    public String inputOperator() {
        return operator;
    }
}
