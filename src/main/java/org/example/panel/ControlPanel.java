package org.example.panel;

import javafx.scene.layout.AnchorPane;
import org.example.controller.HistoryButton;
import org.example.controller.NewHistory;
import org.example.staticValue.CalculatorSize;

public class ControlPanel extends AnchorPane {
    private final static double historyControlPanelHeight = 100;
    private HistoryButton historyButton;

    private NewHistory newHistoryButton;
    public ControlPanel() {
        this.setLayoutY(0);
        this.setPrefSize(CalculatorSize.width, historyControlPanelHeight);
        this.historyButton = new HistoryButton();
        this.newHistoryButton = new NewHistory();
        this.getChildren().addAll(historyButton,newHistoryButton);
    }
}
