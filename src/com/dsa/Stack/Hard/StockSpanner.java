package com.dsa.Stack.Hard;

import java.util.Stack;

class pair {

    int price;
    int span;

    public pair(int price, int span) {
        this.price = price;
        this.span = span;
    }
}

public class StockSpanner {

    Stack<pair> stack = new Stack<>();

    public StockSpanner() {

    }

    public int next(int price) {
        int span = 1;

        while (!stack.isEmpty() && stack.peek().price <= price) {
            span += stack.peek().span;
            stack.pop();
        }

        stack.push(new pair(price, span));

        return span;
    }

}
