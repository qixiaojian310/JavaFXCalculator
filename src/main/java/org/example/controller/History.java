package org.example.controller;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import org.example.staticValue.CalculatorSize;

public class History extends GridPane {
    private final static double historyControlPanelHeight = 80;
    private String formula;
    private String result;
    public History(String formula, String result){
        //增加行数和列数（2，2）
        RowConstraints row1 = new RowConstraints(historyControlPanelHeight/2);
        RowConstraints row2 = new RowConstraints(historyControlPanelHeight/2);
        this.getRowConstraints().addAll(row1,row2);
        ColumnConstraints column1 = new ColumnConstraints(120);
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setHgrow(Priority.ALWAYS);
        this.getColumnConstraints().addAll(column1,column2);
        this.formula = formula;
        this.result = result;
        Label formulaLabel = new Label(formula);
        Label resultLabel = new Label(result);
        Label formulaTitle = new Label("Formula:");
        Label resultTitle = new Label("Result:");
        this.add(formulaTitle,0,0);
        this.add(resultTitle,0,1);
        this.add(formulaLabel,1,0);
        this.add(resultLabel,1,1);
        this.setPrefSize(CalculatorSize.width,historyControlPanelHeight);
    }
    public String[] getFormulaAndResult(){
        String[] formulaAndResult = new String[2];
        formulaAndResult[0] = this.formula;
        formulaAndResult[1] = this.result;
        return formulaAndResult;
    }
}
