package org.example.panel;

import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import org.example.controller.OperatorButton;

public class OperatorButtonBox extends VBox {
    private final int rowNum;
    private final int columnNum;
    public OperatorButtonBox(int rowNum, int columnNum, OperatorButton button){
        this.columnNum = columnNum;
        this.rowNum = rowNum;
        this.setAlignment(Pos.CENTER);
        this.getChildren().add(button);
        this.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");
    }
    public int[] getButtonPosition(){
        return new int[]{rowNum, columnNum};
    }
}
