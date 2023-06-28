package org.example.controller;

import javafx.scene.control.Alert;

public class ErrorAlert extends Alert {
    public ErrorAlert(Exception e){
        super(AlertType.ERROR);
        this.setTitle("计算错误");
        if(e.getClass().getName().equals("java.lang.ArithmeticException"))
            this.setHeaderText("除数不能为0");
        else if(e.getClass().getName().equals("java.util.EmptyStackException"))
            this.setHeaderText("计算式为空");
        else
            this.setHeaderText("计算式包含非法字符");
        e.printStackTrace();
    }
}
