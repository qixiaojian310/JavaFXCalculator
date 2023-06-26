package org.example.panel;

import com.alibaba.fastjson2.JSON;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import org.example.pojo.History;
import org.example.staticValue.CalculatorSize;
import org.example.util.ExpressionEvaluator;
import org.example.util.HistoryRecorder;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class ShowPanel extends GridPane {
    private TextField inputTextField;
    private Label result;
    public static final double showPanelHeight = 140;
    public ShowPanel(){
        this.setPrefSize(CalculatorSize.width,showPanelHeight);
        this.setLayoutY(50);
        this.setStyle("-fx-background-color: #ffffff;");
        //增加行数和列数（2，2）
        RowConstraints row1 = new RowConstraints(showPanelHeight/2);
        RowConstraints row2 = new RowConstraints(showPanelHeight/2);
        this.getRowConstraints().addAll(row1,row2);
        ColumnConstraints column1 = new ColumnConstraints(120);
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setHgrow(Priority.ALWAYS);
        this.getColumnConstraints().addAll(column1,column2);
        //加入对应的组件
        this.inputTextField = new TextField();
        this.inputTextField.setPrefSize(column2.getPrefWidth(),showPanelHeight/2);
        Label inputLabel = new Label("Your input:");
        Label outputLabel = new Label("Your output:");
        this.result = new Label();
        this.add(inputLabel,0,0);
        this.add(this.inputTextField,1,0);
        this.add(outputLabel,0,1);
        this.add(this.result,1,1);
    }
    public void calculate(){
        String resultString = String.valueOf(ExpressionEvaluator.evaluateExpression(this.inputTextField.getText()));
        String expression = this.inputTextField.getText();
        //计算结果
        result.setText(resultString);
        HistoryRecorder.writeDownHistory(new History(expression,resultString));
    }
    public void clear(){
        //清空输入框
        this.inputTextField.setText("");
        this.result.setText("");
    }
    public void input(String input){
        //输入
        this.inputTextField.setText(this.inputTextField.getText()+input);
    }
    public void delete(){
        //删除
        String input = this.inputTextField.getText();
        if(input.length()>0){
            this.inputTextField.setText(input.substring(0,input.length()-1));
        }
    }
}
