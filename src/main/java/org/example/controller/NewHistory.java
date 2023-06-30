package org.example.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.text.Font;
import org.example.event.NewHistoryEvent;
import org.example.staticValue.CalculatorSize;

public class NewHistory extends JFXButton {
    public NewHistory(){
        this.setText("开始新的记录");
        this.setStyle("-fx-background-color: #40d040;-fx-text-fill: #000000");
        this.setFont(new Font(24));
        this.setPrefSize(CalculatorSize.width-160,50);
        this.setOnAction((event) -> {
            Event.fireEvent(this,new NewHistoryEvent());
        });
    }
}
