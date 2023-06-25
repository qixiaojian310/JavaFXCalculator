package org.example;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import org.example.panel.ButtonPanel;
import org.example.panel.HistoryControlPanel;
import org.example.panel.HistoryPanel;
import org.example.panel.ShowPanel;

public class Calculator extends AnchorPane {
    private ShowPanel showPanel;
    private ButtonPanel buttonPanel;
    private HistoryControlPanel historyControlPanel;
    private HistoryPanel historyPanel;

    public Calculator() {
        showPanel = new ShowPanel();
        buttonPanel = new ButtonPanel();
        historyControlPanel = new HistoryControlPanel();
        historyPanel = new HistoryPanel();
        buttonPanel.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Button button = (Button) mouseEvent.getTarget();
                String buttonValue = button.getText();
                System.out.println(buttonValue);
                showPanel.calculate();
            }
        });
        historyControlPanel.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                System.out.println("历史记录");
                historyPanel.toggleHistoryPanel();
            }
        });
        super.getChildren().addAll(historyControlPanel,showPanel, buttonPanel, historyPanel);
    }
}
