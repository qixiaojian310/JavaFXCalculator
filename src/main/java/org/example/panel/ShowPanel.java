package org.example.panel;

import com.alibaba.fastjson2.JSON;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import org.example.controller.ErrorAlert;
import org.example.pojo.History;
import org.example.staticValue.CalculatorSize;
import org.example.util.ExpressionEvaluator;
import org.example.util.HistoryRecorder;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

public class ShowPanel extends GridPane {
    private TextField inputTextField;
    private Label result;
    private String historyID = "";
    public static final double showPanelHeight = 140;
    public ShowPanel(){
        this.setPrefSize(CalculatorSize.width,showPanelHeight);
        this.setLayoutY(50);
        this.setPadding(new Insets(10,20,10,20));
        this.setStyle("-fx-background-color: rgba(0,0,0,0);");
        //增加行数和列数（2，2）
        RowConstraints row1 = new RowConstraints(showPanelHeight/2);
        RowConstraints row2 = new RowConstraints(showPanelHeight/2);
        this.getRowConstraints().addAll(row1,row2);
        ColumnConstraints column1 = new ColumnConstraints(160);
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setHgrow(Priority.ALWAYS);
        this.getColumnConstraints().addAll(column1,column2);
        //加入对应的组件
        this.inputTextField = new TextField();
        this.inputTextField.setPrefSize(column2.getPrefWidth(),showPanelHeight/2);
        this.inputTextField.setFont(new Font(16));
        this.inputTextField.setStyle("-fx-border-radius: 20;-fx-background-radius: 20;");
        Label inputLabel = new Label("Your input:");
        inputLabel.setFont(new Font(20));
        Label outputLabel = new Label("Your output:");
        outputLabel.setFont(new Font(20));
        this.result = new Label();
        result.setFont(new Font(20));
        this.add(inputLabel,0,0);
        this.add(this.inputTextField,1,0);
        this.add(outputLabel,0,1);
        this.add(this.result,1,1);
    }
    public void calculate(){
        try{
            String resultString = String.valueOf(ExpressionEvaluator.evaluateExpression(this.inputTextField.getText()));
            String expression = this.inputTextField.getText();
            //计算结果
            this.result.setText(resultString);
            HistoryRecorder.writeDownHistory(expression,resultString,historyID);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("计算成功");
            alert.setHeaderText("计算成功，已写入记录");
            alert.show();
        }catch (Exception e){
            ErrorAlert alert = new ErrorAlert(e);
            Optional<ButtonType> result = alert.showAndWait();
            if(result.get()==ButtonType.OK){
                //已经确认了此时要清除输入框
                this.inputTextField.setText("");
                this.result.setText("");
            }

        }
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
    public void loadHistory(History history){
        //加载历史记录
        this.inputTextField.setText(history.getExpression());
        this.result.setText(history.getResult());
        this.historyID = history.getHistoryId();
    }
    public void resetHistoryID(){
        this.historyID = "";
    }
}
