package org.example.panel;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import org.example.staticValue.CalculatorSize;
import org.example.util.ExpressionEvaluator;

public class ShowPanel extends GridPane {
    private TextField inputTextField;
    private Label result;
    public static final double showPanelHeight = 140;
    public ShowPanel(){
        this.setPrefSize(CalculatorSize.width,showPanelHeight);
        this.setLayoutY(0);
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
        //计算结果
        result.setText(String.valueOf(ExpressionEvaluator.evaluateExpression(this.inputTextField.getText())));
    }
}
