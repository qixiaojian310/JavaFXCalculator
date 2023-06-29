package org.example.panel;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.TilePane;
import org.example.controller.HistoryShow;
import org.example.event.HistoryClickEvent;
import org.example.event.HistoryDeleteEvent;
import org.example.event.HistoryLoadEvent;
import org.example.pojo.History;
import org.example.staticValue.CalculatorSize;
import org.example.util.HistoryRecorder;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;

public class HistoryPanel extends AnchorPane {
    private final static double historyPanelHeight = 500;
    private final static double labelPanelHeight = 50;
    private boolean isShow = false;
    private ScrollPane scrollPanel = new ScrollPane();
    private AnchorPane labelPanel = new AnchorPane();
    private TilePane historyPanel = new TilePane();
    private Label label = new Label("History");
    private ArrayList<HistoryShow> historyShows = new ArrayList<HistoryShow>();
    private ArrayList<History> histories = new ArrayList<History>();
    private History loadedHistory = null;

    public HistoryPanel(){
        this.setStyle("-fx-background-color: rgba(0,0,0,0);");
        this.setPrefSize(CalculatorSize.width, historyPanelHeight);
        this.setLayoutY(CalculatorSize.height-historyPanelHeight);
        this.labelPanel.setPrefSize(CalculatorSize.width,labelPanelHeight);
        this.labelPanel.setLayoutY(0);
        this.labelPanel.setStyle("-fx-background-color: black; -fx-font-size: 20px;");
        this.scrollPanel.setPrefSize(CalculatorSize.width,historyPanelHeight-labelPanelHeight);
        this.scrollPanel.setLayoutY(labelPanelHeight);
        this.scrollPanel.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        this.scrollPanel.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        this.scrollPanel.fitToHeightProperty().set(true);
        this.scrollPanel.fitToWidthProperty().set(true);
        this.scrollPanel.setContent(historyPanel);
        this.scrollPanel.setStyle("-fx-background-color: rgba(0,0,0,0);");
        this.historyPanel.setPrefSize(CalculatorSize.width,historyPanelHeight-labelPanelHeight);
        this.historyPanel.setVgap(10);
        this.historyPanel.setPadding(new Insets(10,10,10,10));
        this.setStyle("visibility: hidden;");
        this.isShow = false;
        this.addEventHandler(HistoryDeleteEvent.HISTORY_DELETE_EVENT_TYPE, new EventHandler<HistoryDeleteEvent>() {
            @Override
            public void handle(HistoryDeleteEvent historyDeleteEvent) {
                HistoryRecorder.deleteHistory(historyDeleteEvent.getHistory().getHistoryId());
                for (HistoryShow historyShow : historyShows) {
                    if(Objects.equals(historyShow.getHistory().getHistoryId(), historyDeleteEvent.getHistory().getHistoryId())){
                        historyShows.remove(historyShow);
                        historyPanel.getChildren().remove(historyShow);
                        break;
                    }
                }
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("操作成功");
                alert.setHeaderText("你已经删除了这条记录");
                alert.show();
            }
        });
    }
    private void showHistoryPanel(){
        try {
            this.histories = HistoryRecorder.readHistory();
            for (History history : this.histories) {
                addHistory(new HistoryShow(history));
            }
        }catch (NullPointerException e){
            System.out.println("No history");
        }
        this.historyPanel.getChildren().addAll(historyShows);
        this.label.setStyle("-fx-text-fill: white;");
        this.labelPanel.getChildren().add(label);
        this.getChildren().addAll(labelPanel,scrollPanel);
        this.setStyle("visibility: visible;");
        this.isShow = true;
    }
    private void hideHistoryPanel(){
        this.histories.clear();
        this.historyShows.clear();
        this.historyPanel.getChildren().clear();
        this.labelPanel.getChildren().clear();
        this.getChildren().clear();
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
    private void addHistory(HistoryShow historyShow){
        this.historyShows.add(historyShow);
        historyShow.addEventHandler(HistoryClickEvent.HISTORY_CLICK_EVENT_TYPE, (HistoryClickEvent historyClickEvent) -> {
            HistoryShow historyShowActive = (HistoryShow) historyClickEvent.getTarget();
            this.loadedHistory = historyShowActive.getHistory();
            Event.fireEvent(this,new HistoryLoadEvent(historyShowActive.getHistory()));
        });
    }
}
