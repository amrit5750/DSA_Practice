package com.dsa.Stack.Monotonic;

import java.util.Stack;

public class SumOFRangeOFSubarrays {

    public static void main(String[] args) {

        int[] arr = { 1, 2, 3 };

        System.out.println(subArrayRanges(arr));
    }

    public static int[] NSE(int[] nums) {

        Stack<Integer> stack = new Stack<>();
        int[] NSE = new int[nums.length];

        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }
            NSE[i] = stack.empty() ? nums.length : stack.peek();
            stack.push(i);
        }
        return NSE;
    }

    public static int[] PSE(int[] nums) {

        Stack<Integer> stack = new Stack<>();
        int[] PSE = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                stack.pop();
            }
            PSE[i] = stack.empty() ? -1 : stack.peek();
            stack.push(i);
        }
        return PSE;

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

    public static int[] PGE(int[] nums) {

        Stack<Integer> stack = new Stack<>();
        int[] PGE = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                stack.pop();
            }
            PGE[i] = stack.empty() ? -1 : stack.peek();
            stack.push(i);
        }
        return PGE;
    }

    public static long subArrayRanges(int[] nums) {

        long totalMinofSubarrays = 0;
        long totalMaxofSubarrays = 0;

        int[] NSE = NSE(nums);
        int[] PSE = PSE(nums);
        int[] NGE = NGE(nums);
        int[] PGE = PGE(nums);
        for (int i = 0; i < nums.length; i++) {
            long leftmin = i - PSE[i];
            long rightmin = NSE[i] - i;
            totalMinofSubarrays += (leftmin * rightmin) * nums[i];

            long leftmax = i - PGE[i];
            long rightmax = NGE[i] - i;
            totalMaxofSubarrays += (leftmax * rightmax) * nums[i];
        }

        return totalMaxofSubarrays - totalMinofSubarrays;

    }

}
