package org.example.panel;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import org.example.controller.OperatorButton;
import org.example.staticValue.CalculatorSize;

public class ButtonPanel extends GridPane {
    private final static double buttonPanelHeight = 500;
    private final static int rowNumber = 5;
    private final static int columnNumber = 4;

    private final static OperatorButton[] operatorButtons = new OperatorButton[]{
        new OperatorButton("AC",0,0),
        new OperatorButton("DEL",0,1),
        new OperatorButton("(",0,2),
        new OperatorButton(")",0,3),
        new OperatorButton("7",1,0),
        new OperatorButton("8",1,1),
        new OperatorButton("9",1,2),
        new OperatorButton("/",1,3),
        new OperatorButton("4",2,0),
        new OperatorButton("5",2,1),
        new OperatorButton("6",2,2),
        new OperatorButton("*",2,3),
        new OperatorButton("1",3,0),
        new OperatorButton("2",3,1),
        new OperatorButton("3",3,2),
        new OperatorButton("-",3,3),
        new OperatorButton("0",4,0),
        new OperatorButton(".",4,1),
        new OperatorButton("=",4,2),
        new OperatorButton("+",4,3),
    };

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
        for (OperatorButton operatorButton : operatorButtons) {
            operatorButton.setPrefSize(CalculatorSize.width/columnNumber,buttonPanelHeight/rowNumber);
            this.add(operatorButton,operatorButton.getButtonPosition()[1],operatorButton.getButtonPosition()[0]);
        }
    }
}
