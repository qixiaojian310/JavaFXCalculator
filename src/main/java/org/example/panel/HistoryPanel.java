package org.example.panel;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
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
import org.example.controller.HistoryShow;
import org.example.pojo.History;
import org.example.staticValue.CalculatorSize;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

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

    public HistoryPanel(){
        this.readHistory();
        this.addHistory(new HistoryShow(new History("1+1","2")));
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
        this.historyPanel.getChildren().addAll(historyShows);
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
    private void addHistory(HistoryShow historyShow){
        this.historyShows.add(historyShow);
        this.histories.add(historyShow.getHistory());
        historyShow.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                System.out.println();
            }
        });
    }
    private void writeDownHistory(){
        String historiesString = JSON.toJSONString(this.histories);

        // write json String to file
        try {
            File file = new File("histories.json");
            if (file.exists()){
                file.delete();
            }
            file.createNewFile();
            Writer writer =  new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8);
            writer.write(historiesString);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void readHistory(){
        File file = new File("histories.json");
        if (!file.exists()){
            return;
        }
        try {
            Reader reader = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8);
            char[] chars = new char[(int) file.length()];
            reader.read(chars);
            String historiesString = new String(chars);
            ArrayList<History> histories = (ArrayList<History>) JSON.parseArray(historiesString,History.class);
            for (History history:histories){
                this.addHistory(new HistoryShow(history));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
