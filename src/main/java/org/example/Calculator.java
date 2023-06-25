package org.example;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import org.example.panel.ButtonPanel;
import org.example.panel.ShowPanel;

public class Calculator extends AnchorPane {
    private ShowPanel showPanel;
    private ButtonPanel buttonPanel;

    public Calculator() {
        showPanel = new ShowPanel();
        buttonPanel = new ButtonPanel();
        buttonPanel.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Button button = (Button) mouseEvent.getTarget();
                String buttonValue = button.getText();
                System.out.println(buttonValue);
                showPanel.calculate();
            }
        });
        super.getChildren().addAll(showPanel, buttonPanel);
    }
}
