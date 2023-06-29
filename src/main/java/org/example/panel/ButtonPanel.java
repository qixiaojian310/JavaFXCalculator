package org.example.panel;

import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import org.example.controller.OperatorButton;
import org.example.staticValue.CalculatorSize;

public class ButtonPanel extends GridPane {
    private final static double buttonPanelHeight = 500;
    private final static int rowNumber = 5;
    private final static int columnNumber = 4;

    private final static OperatorButtonBox[] operatorButtonBoxes = new OperatorButtonBox[]{
            new OperatorButtonBox(0, 0, new OperatorButton("AC")),
            new OperatorButtonBox(0, 1, new OperatorButton("DEL")),
            new OperatorButtonBox(0, 2, new OperatorButton("(")),
            new OperatorButtonBox(0, 3, new OperatorButton(")")),
            new OperatorButtonBox(1, 0, new OperatorButton("7")),
            new OperatorButtonBox(1, 1, new OperatorButton("8")),
            new OperatorButtonBox(1, 2, new OperatorButton("9")),
            new OperatorButtonBox(1, 3, new OperatorButton("/")),
            new OperatorButtonBox(2, 0, new OperatorButton("4")),
            new OperatorButtonBox(2, 1, new OperatorButton("5")),
            new OperatorButtonBox(2, 2, new OperatorButton("6")),
            new OperatorButtonBox(2, 3, new OperatorButton("*")),
            new OperatorButtonBox(3, 0, new OperatorButton("1")),
            new OperatorButtonBox(3, 1, new OperatorButton("2")),
            new OperatorButtonBox(3, 2, new OperatorButton("3")),
            new OperatorButtonBox(3, 3, new OperatorButton("-")),
            new OperatorButtonBox(4, 0, new OperatorButton("0")),
            new OperatorButtonBox(4, 1, new OperatorButton(".")),
            new OperatorButtonBox(4, 2, new OperatorButton("=")),
            new OperatorButtonBox(4, 3, new OperatorButton("+")),
    };

    public ButtonPanel() {
        this.setPrefSize(CalculatorSize.width, buttonPanelHeight);
        this.setLayoutY(CalculatorSize.height - buttonPanelHeight);
        this.setStyle("-fx-background-color: rgba(255, 255, 255, 0);");
        for (int row = 0; row < rowNumber; row++) {
            this.getRowConstraints().add(new RowConstraints(buttonPanelHeight / rowNumber));
        }
        for (int column = 0; column < columnNumber; column++) {
            this.getColumnConstraints().add(new ColumnConstraints(CalculatorSize.width / columnNumber));
        }
        for (OperatorButtonBox operatorButtonBox : operatorButtonBoxes) {
//            operatorButton.setPrefSize(CalculatorSize.width/columnNumber,buttonPanelHeight/rowNumber);
            this.add(operatorButtonBox, operatorButtonBox.getButtonPosition()[1], operatorButtonBox.getButtonPosition()[0]);
        }
    }
}
