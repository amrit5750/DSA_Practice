package com.dsa.Stack.Monotonic;

import java.util.Arrays;
import java.util.Stack;

public class NextSmallerElement {

    public static void main(String[] args) {

        int[] arr = { 4, 8, 5, 2, 25 };

        System.out.println(Arrays.toString(getNextSmaller(arr)));

    }

    public static int[] getNextSmaller(int[] arr) {

        int[] ans = new int[arr.length];

        Stack<Integer> stack = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {

            while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();

            }

            if (stack.isEmpty()) {
                ans[i] = -1;
            } else {
                ans[i] = stack.peek();
            }
            stack.push(arr[i]);

        }

        return ans;

    }

}
