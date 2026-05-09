package com.dsa.Stack.Hard;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemprature {

    public static void main(String[] args) {

        int[] temperatures = { 73, 74, 75, 71, 69, 72, 76, 73 };

        System.out.println(Arrays.toString(dailyTemperatures(temperatures)));

    }

    public static int[] NGE(int[] nums) {

        Stack<Integer> stack = new Stack<>();
        int[] NGE = new int[nums.length];

        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                stack.pop();
            }
            NGE[i] = stack.empty() ? nums.length : stack.peek();
            stack.push(i);
        }
        return NGE;
    }

    public static int[] dailyTemperatures(int[] temperatures) {

        int[] warmerDay = new int[temperatures.length];

        int[] NGE = NGE(temperatures);

        for (int i = 0; i < NGE.length; i++) {
            if (NGE[i] == temperatures.length) {
                warmerDay[i] = 0;
            } else {
                warmerDay[i] = NGE[i] - i;
            }
        }
        return warmerDay;
    }

}
