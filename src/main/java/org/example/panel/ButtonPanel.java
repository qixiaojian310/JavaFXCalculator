package org.example.panel;

import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import org.example.staticValue.CalculatorSize;

public class ButtonPanel extends GridPane {
    private final static double buttonPanelHeight = 500;
    private final static int rowNumber = 5;
    private final static int columnNumber = 4;
    public ButtonPanel(){
        this.setPrefSize(CalculatorSize.width,buttonPanelHeight);
        this.setLayoutY(CalculatorSize.height-buttonPanelHeight);
        this.setStyle("-fx-background-color: #ff0000;");
        for (int row = 0; row < rowNumber; row++) {
            this.getRowConstraints().add(new RowConstraints(buttonPanelHeight/rowNumber));
        }
        for (int column = 0; column < columnNumber; column++) {
            this.getColumnConstraints().add(new ColumnConstraints(CalculatorSize.width/columnNumber));
        }
        for (int row = 0; row < rowNumber; row++) {
            for (int column = 0; column < columnNumber; column++) {
                Button button = new Button("123");
                button.setPrefSize(CalculatorSize.width/columnNumber,buttonPanelHeight/rowNumber);
                this.add(button,column,row);
            }
        }
    }
}
