package com.dsa.Stack.Monotonic;

import java.util.Stack;

public class MaximalRectangle {

    public static void main(String[] args) {

        char[][] matrix = { { '1', '0', '1', '0', '0' },
                { '1', '0', '1', '1', '1' },
                { '1', '1', '1', '1', '1' },
                { '1', '0', '0', '1', '0' } };

        System.out.println(maximalRectangle(matrix));

    }

    public static int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0)
            return 0;

        int m = matrix[0].length;
        int[] height = new int[m];
        int maxArea = 0;
        for (char[] row : matrix) {

            for (int i = 0; i < m; i++) {
                if (row[i] == '1')
                    height[i]++;
                else
                    height[i] = 0;
            }
            maxArea = Math.max(maxArea, largestRectangleArea(height));
        }
        return maxArea;

    }

    public static int largestRectangleArea(int[] heights) {
        int area = 0;

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i <= heights.length; i++) {
            int height = (i == heights.length) ? 0 : heights[i];
            while (!stack.isEmpty() && heights[stack.peek()] > height) {
                int ele = stack.pop();
                int nse = i;
                int pse = stack.isEmpty() ? -1 : stack.peek();
                int width = nse - pse - 1;
                area = Math.max(area, heights[ele] * width);
            }
            stack.push(i);

        }

        return area;

    }

}
