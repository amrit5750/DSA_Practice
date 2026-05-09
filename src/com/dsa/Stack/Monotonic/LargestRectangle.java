package com.dsa.Stack.Monotonic;

import java.util.Stack;

public class LargestRectangle {

    public static void main(String[] args) {

        int[] heights = { 2, 1, 5, 6, 2, 3 };
        System.out.println(largestRectangleArea(heights));
    }

    public static int largestRectangleArea(int[] heights) {

        int[] PSE = PSE(heights);
        int[] NSE = NSE(heights);

        int LargestRectangle = 0;

        for (int i = 0; i < heights.length; i++) {
            LargestRectangle = Math.max(LargestRectangle, heights[i] * (NSE[i] - PSE[i] - 1));

        }

        // System.out.println(Arrays.toString(PSE));
        // System.out.println(Arrays.toString(NSE));

        return LargestRectangle;

    }

    public static int largestRectangleAreaOptimal(int[] heights) {

        int LargestRectangle = 0;

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < heights.length; i++) {
            int height = (i == heights.length) ? 0 : heights[i];
            while (!stack.isEmpty() && heights[stack.peek()] > height) {
                int ele = stack.pop();
                int nse = i;
                int pse = stack.isEmpty() ? -1 : stack.peek();
                int width = nse - pse - 1;
                LargestRectangle = Math.max(LargestRectangle, heights[ele] * width);
            }
            stack.push(i);

        }

        return LargestRectangle;

    }

    public static int[] PSE(int[] arr) {

        int[] PSE = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            PSE[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return PSE;
    }

    public static int[] NSE(int[] arr) {

        int[] NSE = new int[arr.length];

        Stack<Integer> stack = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            NSE[i] = stack.isEmpty() ? arr.length : stack.peek();
            stack.push(i);
        }
        return NSE;
    }
}
