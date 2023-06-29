package org.example.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.Event;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import org.example.event.HistoryClickEvent;
import org.example.event.HistoryDeleteEvent;
import org.example.pojo.History;
import org.example.staticValue.CalculatorSize;

public class HistoryShow extends GridPane {
    private final static double historyControlPanelHeight = 80;
    private History history;
    public HistoryShow(History history){
        this.setPadding(new Insets(10,10,10,10));
        this.setStyle("-fx-background-color: rgb(220,220,220); -fx-border-radius: 30; -fx-background-radius: 30;");
        //增加行数和列数（2，2）
        RowConstraints row1 = new RowConstraints(historyControlPanelHeight/2);
        RowConstraints row2 = new RowConstraints(historyControlPanelHeight/2);
        this.getRowConstraints().addAll(row1,row2);
        ColumnConstraints column1 = new ColumnConstraints(150);
        ColumnConstraints column2 = new ColumnConstraints();
        ColumnConstraints column3 = new ColumnConstraints(50);
        column2.setHgrow(Priority.ALWAYS);
        this.getColumnConstraints().addAll(column1,column2);
        this.history = history;
        Label formulaLabel = new Label(history.getExpression());
        formulaLabel.setFont(new Font(16));
        Label resultLabel = new Label(history.getResult());
        resultLabel.setFont(new Font(16));
        Label formulaTitle = new Label("Expression:");
        formulaTitle.setFont(new Font(20));
        Label resultTitle = new Label("Result:");
        resultTitle.setFont(new Font(20));
        JFXButton button = new JFXButton("-");
        button.setFont(new Font(24));
        button.setStyle("-fx-background-color: rgb(180,180,180); -fx-border-radius: 50%; -fx-background-radius: 50%;");
        button.setPrefSize(50,50);
        this.add(formulaTitle,0,0);
        this.add(resultTitle,0,1);
        this.add(formulaLabel,1,0);
        this.add(resultLabel,1,1);
        this.add(button,2,0);
        this.setPrefSize(CalculatorSize.width-30,historyControlPanelHeight);
        this.setOnMouseClicked((MouseEvent event)->{
            Event.fireEvent(this,new HistoryClickEvent());
        });
        button.setOnAction((event -> {
            Event.fireEvent(this,new HistoryDeleteEvent(this.history));
        }));
    };
    public History getHistory(){
        return this.history;
    }
}
