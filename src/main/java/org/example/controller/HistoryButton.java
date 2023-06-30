package org.example.controller;


import com.jfoenix.controls.JFXButton;
import javafx.event.Event;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import org.example.event.NewHistoryEvent;
import org.example.event.OpenHistoryEvent;
import org.example.staticValue.CalculatorSize;

public class HistoryButton extends JFXButton {
    private final String buttonName = "历史记录";
    public HistoryButton(){
        this.setText(buttonName);
        this.setFont(new Font(24));
        this.setLayoutY(0);
        this.setPrefSize(160,50);
        this.setLayoutX(CalculatorSize.width-160);
        this.setStyle("-jfx-button-type: RAISED;-fx-background-color:black;-fx-text-fill: white;");
        this.setOnAction((event) -> {
            Event.fireEvent(this,new OpenHistoryEvent());
        });
    }
}
