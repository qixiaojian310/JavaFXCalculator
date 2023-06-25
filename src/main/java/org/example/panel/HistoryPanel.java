package org.example.panel;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.beans.value.ObservableValueBase;
import javafx.scene.control.ScrollPane;
import org.example.staticValue.CalculatorSize;

public class HistoryPanel extends ScrollPane {
    private final static double historyPanelHeight = 500;
    private boolean isShow = false;

    public HistoryPanel(){
        this.setPrefSize(CalculatorSize.width, historyPanelHeight);
        this.setLayoutY(CalculatorSize.height-historyPanelHeight);
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
}
