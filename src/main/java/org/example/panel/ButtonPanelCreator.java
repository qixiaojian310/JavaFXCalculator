package org.example.panel;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import org.example.staticValue.CalculatorSize;

public class ButtonPanelCreator {

    private final static double buttonPanelHeight = 500;
    private final static int rowNumber = 5;
    private final static int columnNumber = 4;

    public static GridPane createButtonPanel() {
        GridPane panel = new GridPane();
        panel.setPrefSize(CalculatorSize.width,buttonPanelHeight);
        panel.setLayoutY(CalculatorSize.height-buttonPanelHeight);
        panel.setStyle("-fx-background-color: #ff0000;");
        for (int row = 0; row < rowNumber; row++) {
            panel.getRowConstraints().add(new RowConstraints(buttonPanelHeight/rowNumber));
        }
        for (int column = 0; column < columnNumber; column++) {
            panel.getColumnConstraints().add(new ColumnConstraints(CalculatorSize.width/columnNumber));
        }
        for (int row = 0; row < rowNumber; row++) {
            for (int column = 0; column < columnNumber; column++) {
                Button button = new Button("123");
                button.setPrefSize(CalculatorSize.width/columnNumber,buttonPanelHeight/rowNumber);
                panel.add(button,column,row);
            }
        }
        return panel;
    }
}
