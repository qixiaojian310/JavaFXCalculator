package org.example.pojo;

import java.util.UUID;

public class History {
    private String expression;
    private String result;
    private String historyId;

    public History(String expression, String result) {
        this.expression = expression;
        this.result = result;
    }
    public History(String expression, String result, String historyId) {
        this.expression = expression;
        this.result = result;
        this.historyId = historyId;
    }

    public String getExpression() {
        return expression;
    }

    public String getResult() {
        return result;
    }
    public void generateHistoryId(){
        this.historyId = UUID.randomUUID().toString();
    }
    public String getHistoryId(){
        return historyId;
    }
    public void setExpression(String expression) {
        this.expression = expression;
    }
    public void setResult(String result) {
        this.result = result;
    }
}
