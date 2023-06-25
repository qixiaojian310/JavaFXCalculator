package org.example.util;

import java.util.Stack;

public class ExpressionEvaluator {
    public static double evaluateExpression(String expression) {
        // 去除空格
        expression = expression.replaceAll("\\s+", "");

        Stack<Double> numberStack = new Stack<>();      // 存储数字的栈
        Stack<Character> operatorStack = new Stack<>(); // 存储操作符的栈

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
                numberStack.push(number);
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
        return (op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-');
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
