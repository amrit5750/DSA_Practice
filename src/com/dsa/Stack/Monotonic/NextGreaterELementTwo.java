package com.dsa.Stack.Monotonic;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterELementTwo {

    public static void main(String[] args) {

        int[] nums = { 1, 2, 1 };
        System.out.println(Arrays.toString(nextGreaterElements(nums)));

    }

    public static int[] nextGreaterElements(int[] nums) {

        Stack<Integer> stack = new Stack<>();

        int[] ans = new int[nums.length];

        for (int i = 2 * nums.length - 1; i >= 0; i--) {

            while (!stack.isEmpty() && stack.peek() <= nums[i % nums.length]) {
                stack.pop();
            }

            if (i < nums.length) {
                ans[i] = stack.empty() ? -1 : stack.peek();

            }
            stack.push(nums[i % nums.length]);

        }

        return ans;

    }

}
