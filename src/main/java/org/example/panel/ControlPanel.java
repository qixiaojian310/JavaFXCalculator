package org.example.panel;

import javafx.scene.layout.AnchorPane;
import org.example.controller.HistoryButton;
import org.example.staticValue.CalculatorSize;

public class ControlPanel extends AnchorPane {
    private final static double historyControlPanelHeight = 100;
    private HistoryButton historyButton;

    public ControlPanel() {
        this.setLayoutY(0);
        this.setPrefSize(CalculatorSize.width, historyControlPanelHeight);
        this.historyButton = new HistoryButton();
        this.getChildren().add(historyButton);
    }
}
