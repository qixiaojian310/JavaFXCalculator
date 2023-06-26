package org.example.pojo;

public class History {
    private String expression;
    private String result;

    public History(String expression, String result) {
        this.expression = expression;
        this.result = result;
    }

    public String getExpression() {
        return expression;
    }

    public String getResult() {
        return result;
    }
}
