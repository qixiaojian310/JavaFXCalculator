package org.example.controller;

import javafx.event.Event;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import org.example.event.HistoryClickEvent;
import org.example.pojo.History;
import org.example.staticValue.CalculatorSize;

public class HistoryShow extends GridPane {
    private final static double historyControlPanelHeight = 80;
    private History history;
    public HistoryShow(History history){
        //增加行数和列数（2，2）
        RowConstraints row1 = new RowConstraints(historyControlPanelHeight/2);
        RowConstraints row2 = new RowConstraints(historyControlPanelHeight/2);
        this.getRowConstraints().addAll(row1,row2);
        ColumnConstraints column1 = new ColumnConstraints(120);
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setHgrow(Priority.ALWAYS);
        this.getColumnConstraints().addAll(column1,column2);
        this.history = history;
        Label formulaLabel = new Label(history.getExpression());
        Label resultLabel = new Label(history.getResult());
        Label formulaTitle = new Label("Expression:");
        Label resultTitle = new Label("Result:");
        this.add(formulaTitle,0,0);
        this.add(resultTitle,0,1);
        this.add(formulaLabel,1,0);
        this.add(resultLabel,1,1);
        this.setPrefSize(CalculatorSize.width,historyControlPanelHeight);
        this.setOnMouseClicked((MouseEvent event)->{
            Event.fireEvent(this,new HistoryClickEvent());
        });
    };
    public History getHistory(){
        return this.history;
    }
}
