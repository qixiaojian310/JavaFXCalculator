package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.example.panel.ButtonPanel;
import org.example.panel.ShowPanel;
import org.example.staticValue.CalculatorSize;


public class Main extends Application {

    @Override
    public void start(Stage stage) {
        String javaVersion = System.getProperty("java.version");
        String javafxVersion = System.getProperty("javafx.version");
        System.out.println("javaVersion = " + javaVersion + ", javafxVersion = " + javafxVersion);
        Calculator calculator = new Calculator();
        Scene scene = new Scene(new StackPane(calculator), CalculatorSize.width,CalculatorSize.height);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}