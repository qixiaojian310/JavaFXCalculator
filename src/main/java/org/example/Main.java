package org.example;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.example.staticValue.CalculatorSize;


public class Main extends Application {

    @Override
    public void start(Stage stage) {
        stage.initStyle(StageStyle.DECORATED);
        stage.setTitle("JavaFX Calculator");
        String javaVersion = System.getProperty("java.version");
        String javafxVersion = System.getProperty("javafx.version");
        System.out.println("javaVersion = " + javaVersion + ", javafxVersion = " + javafxVersion);
        Calculator calculator = new Calculator();
        StackPane app = new StackPane(calculator);
        app.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);");
        Scene scene = new Scene(app, CalculatorSize.width, CalculatorSize.height);
        scene.setFill(new Color(0, 0, 0, 0.5));
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}