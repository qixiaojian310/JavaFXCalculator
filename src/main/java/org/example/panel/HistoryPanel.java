package org.example.panel;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.beans.value.ObservableValueBase;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import org.example.controller.History;
import org.example.staticValue.CalculatorSize;

import java.util.ArrayList;

public class HistoryPanel extends AnchorPane {
    private final static double historyPanelHeight = 500;
    private final static double labelPanelHeight = 50;
    private boolean isShow = false;
    private ScrollPane scrollPanel = new ScrollPane();
    private AnchorPane labelPanel = new AnchorPane();
    private TilePane historyPanel = new TilePane();
    private Label label = new Label("History");
    private ArrayList<History> histories = new ArrayList<History>();

    public HistoryPanel(){
        this.addHistory(new History("1+1","2"));
        this.setStyle("-fx-background-color: #ffffff;");
        this.setPrefSize(CalculatorSize.width, historyPanelHeight);
        this.setLayoutY(CalculatorSize.height-historyPanelHeight);
        this.labelPanel.setPrefSize(CalculatorSize.width,labelPanelHeight);
        this.labelPanel.setLayoutY(0);
        this.labelPanel.setStyle("-fx-background-color: #ffffff; -fx-font-size: 20px;");
        this.scrollPanel.setPrefSize(CalculatorSize.width,historyPanelHeight-labelPanelHeight);
        this.scrollPanel.setLayoutY(labelPanelHeight);
        this.scrollPanel.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        this.scrollPanel.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        this.scrollPanel.fitToHeightProperty().set(true);
        this.scrollPanel.fitToWidthProperty().set(true);
        this.scrollPanel.setContent(historyPanel);
        this.historyPanel.setPrefSize(CalculatorSize.width,historyPanelHeight-labelPanelHeight);
        this.historyPanel.getChildren().addAll(histories);
        this.labelPanel.getChildren().add(label);
        this.getChildren().addAll(labelPanel,scrollPanel);
        hideHistoryPanel();
    }
    private void showHistoryPanel(){
        this.setStyle("visibility: visible;");
        this.isShow = true;
    }
    private void hideHistoryPanel(){
        this.setStyle("visibility: hidden;");
        this.isShow = false;
    }
    public void toggleHistoryPanel(){
        if (isShow){
            hideHistoryPanel();
        }else {
            showHistoryPanel();
        }
    }
    private void addHistory(History history){
        this.histories.add(history);
        history.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                System.out.println(history.getFormulaAndResult()[0]+history.getFormulaAndResult()[1]);
            }
        });
    }
}
