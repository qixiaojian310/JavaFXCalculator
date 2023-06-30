package org.example;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import org.example.controller.OperatorButton;
import org.example.event.*;
import org.example.panel.ButtonPanel;
import org.example.panel.ControlPanel;
import org.example.panel.HistoryPanel;
import org.example.panel.ShowPanel;

public class Calculator extends AnchorPane {
    private ShowPanel showPanel;
    private ButtonPanel buttonPanel;
    private ControlPanel controlPanel;
    private HistoryPanel historyPanel;

    public Calculator() {
        this.setStyle("-fx-background-color: rgba(255, 255, 255, 0);");
        showPanel = new ShowPanel();
        buttonPanel = new ButtonPanel();
        controlPanel = new ControlPanel();
        historyPanel = new HistoryPanel();
        buttonPanel.addEventHandler(OperatorButtonClickEvent.OPERATOR_BUTTON_CLICK_EVENT_TYPE, new EventHandler<OperatorButtonClickEvent>() {
            @Override
            public void handle(OperatorButtonClickEvent operatorButtonClickEvent) {
                OperatorButton operatorButton = (OperatorButton) operatorButtonClickEvent.getTarget();
                switch (operatorButton.inputOperator()) {
                    case "AC":
                        showPanel.clear();
                        break;
                    case "DEL":
                        showPanel.delete();
                        break;
                    case "=":
                        showPanel.calculate();
                        break;
                    default:
                        showPanel.input(operatorButton.inputOperator());
                        break;
                }
            }
        });
        controlPanel.addEventFilter(NewHistoryEvent.NEW_HISTORY_EVENT_TYPE, new EventHandler<NewHistoryEvent>() {
            @Override
            public void handle(NewHistoryEvent newHistoryEvent) {
                showPanel.newHistory();
            }
        });
        controlPanel.addEventFilter(OpenHistoryEvent.OPEN_HISTORY_EVENT_TYPE, new EventHandler<OpenHistoryEvent>() {
            @Override
            public void handle(OpenHistoryEvent openHistoryEvent) {
                historyPanel.toggleHistoryPanel();
            }
        });
        historyPanel.addEventHandler(HistoryLoadEvent.HISTORY_LOAD_EVENT_TYPE, new EventHandler<HistoryLoadEvent>() {
            @Override
            public void handle(HistoryLoadEvent historyLoadEvent) {
                showPanel.loadHistory(historyLoadEvent.getHistory());
            }
        });
        historyPanel.addEventHandler(HistoryDeleteEvent.HISTORY_DELETE_EVENT_TYPE, new EventHandler<HistoryDeleteEvent>() {
            @Override
            public void handle(HistoryDeleteEvent historyDeleteEvent) {
                showPanel.resetHistoryID();
            }
        });

        super.getChildren().addAll(controlPanel,showPanel, buttonPanel, historyPanel);
    }

}
