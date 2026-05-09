package com.dsa.dp.MCM;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ParseBollExpression {

    public static void main(String[] args) {

        String expression = "|(f,f,f,t)";

        System.out.println(parseBoolExpr(expression));

    }

    public static boolean parseBoolExpr(String expression) {

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == ',') {
                continue;
            }
            if (expression.charAt(i) == ')') {
                List<Character> temp = new ArrayList<>();
                while (!stack.empty() && stack.peek() != '(') {
                    temp.add(stack.pop());
                }
                stack.pop(); // removing the "(" Char
                char operator = stack.peek();
                stack.pop();

                char result = evaluateExpression(temp, operator);
                stack.add(result);

            } else {
                stack.add(expression.charAt(i));
            }
        }

        return stack.peek() == 't' ? true : false;
    }

    public static char evaluateExpression(List<Character> temp, char operator) {

        if (operator == '!') {
            return temp.get(0) == 't' ? 'f' : 't';
        }

        if (operator == '|') {
            if (temp.contains('t')) {
                return 't';
            }
            return 'f';
        }
        if (operator == '&') {
            if (temp.contains('f')) {
                return 'f';
            }
            return 't';
        }

        return 't';

    }

}
