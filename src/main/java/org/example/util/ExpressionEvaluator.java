package org.example.util;

import java.util.Stack;

public class ExpressionEvaluator {
    public static double evaluateExpression(String expression) throws IllegalArgumentException, ArithmeticException {
        // 去除空格
        expression = expression.replaceAll("\\s+", "");
        Stack<Double> numberStack = new Stack<>();      // 存储数字的栈
        Stack<Character> operatorStack = new Stack<>(); // 存储操作符的栈
        boolean isNegative = false; // 用于标记负数

        //中缀表达式转后缀表达式
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            if (Character.isDigit(ch)) {
                // 处理多位数字
                StringBuilder sb = new StringBuilder();
                while (i < expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                    sb.append(expression.charAt(i));
                    i++;
                }
                i--;

                double number = Double.parseDouble(sb.toString());
                if (isNegative) {
                    number = -number;
                    isNegative = false; // 重置负数标记
                }
                numberStack.push(number);
            } else if (ch == '-') {
                // 遇到负号
                if (i == 0 || expression.charAt(i - 1) == '(') {
                    // 当负号出现在表达式开头或左括号后面时，标记下一个数字为负数
                    isNegative = true;
                } else {
                    // 当负号出现在其他位置时，表示减法操作符
                    while (!operatorStack.isEmpty() && hasPrecedence(ch, operatorStack.peek())) {
                        double result = performOperation(operatorStack.pop(), numberStack.pop(), numberStack.pop());
                        numberStack.push(result);
                    }
                    operatorStack.push(ch);
                }
            } else if (ch == '(') {
                operatorStack.push(ch);
            } else if (ch == ')') {
                // 遇到右括号，将操作符栈中的操作符弹出并添加到数字栈，直到遇到左括号
                while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                    double result = performOperation(operatorStack.pop(), numberStack.pop(), numberStack.pop());
                    numberStack.push(result);
                }
                operatorStack.pop(); // 弹出左括号
            } else if (isOperator(ch)) {
                // 遇到操作符
                // 将操作符栈顶的操作符弹出并添加到数字栈，直到满足优先级条件，然后将当前操作符入栈
                while (!operatorStack.isEmpty() && hasPrecedence(ch, operatorStack.peek())) {
                    double result = performOperation(operatorStack.pop(), numberStack.pop(), numberStack.pop());
                    numberStack.push(result);
                }
                operatorStack.push(ch);
            } else {
                throw new NumberFormatException();
            }
        }

        // 将操作符栈中剩余的操作符弹出并添加到数字栈
        while (!operatorStack.isEmpty()) {
            double result = performOperation(operatorStack.pop(), numberStack.pop(), numberStack.pop());
            numberStack.push(result);
        }

        return numberStack.pop(); // 数字栈中最后剩下的数就是结果
    }

    private static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    private static boolean hasPrecedence(char op1, char op2) {
        // 比较两个操作符的优先级
        if (op2 == '(' || op2 == ')') {
            return false;
        }
        if ((op1 == '+' || op1 == '-') && (op2 == '+' || op2 == '-')) {
            return true;
        }
        if ((op1 == '*' || op1 == '/') && (op2 == '*' || op2 == '/')) {
            return true;
        }
        return (op1 == '+' || op1 == '-') && (op2 == '*' || op2 == '/');
    }

    private static double performOperation(char operator, double b, double a) {
        // 执行操作符的计算
        switch (operator) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return a / b;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
}
