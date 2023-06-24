package org.example.panel;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import org.example.staticValue.CalculatorSize;

public class ShowPanelCreator {

    public static final double showPanelHeight = 140;

    public static GridPane createShowPanel() {
        GridPane panel = new GridPane();
        panel.setPrefSize(CalculatorSize.width,showPanelHeight);
        panel.setLayoutY(0);
        panel.setStyle("-fx-background-color: #ffffff;");
        //增加行数和列数（2，2）
        RowConstraints row1 = new RowConstraints(showPanelHeight/2);
        RowConstraints row2 = new RowConstraints(showPanelHeight/2);
        panel.getRowConstraints().addAll(row1,row2);
        ColumnConstraints column1 = new ColumnConstraints(120);
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setHgrow(Priority.ALWAYS);
        panel.getColumnConstraints().addAll(column1,column2);
        //加入对应的组件
        TextField inputTextField = new TextField();
        inputTextField.setPrefSize(column2.getPrefWidth(),showPanelHeight/2);
        Label inputLabel = new Label("Your input:");
        Label outputLabel = new Label("Your output:");
        Label output = new Label();
        panel.add(inputLabel,0,0);
        panel.add(inputTextField,1,0);
        panel.add(outputLabel,0,1);
        panel.add(output,1,1);
        return panel;
    }
}
