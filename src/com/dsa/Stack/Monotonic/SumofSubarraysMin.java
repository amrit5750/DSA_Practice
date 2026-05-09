package com.dsa.Stack.Monotonic;

import java.util.Stack;

public class SumofSubarraysMin {

    public static void main(String[] args) {

        int[] arr = { 3, 1, 2, 4 };

        System.out.println(sumSubarrayMins(arr));

    }

    public static int sumSubarrayMins(int[] arr) {

        long total = 0;
        int[] NSE = findNSE(arr);
        int[] PSE = findPSE(arr);
        System.out.println("NSE " + java.util.Arrays.toString(NSE));
        System.out.println("PSE " + java.util.Arrays.toString(PSE));
        int mod = (int) (1e9 + 7);

        for (int i = 0; i < arr.length; i++) {
            int left = i - PSE[i];
            int right = NSE[i] - i;
            total = (total + (right * 1L * left % mod) * arr[i] % mod) % mod;
        }

        return (int) total;
    }

    public static int[] findNSE(int[] arr) {
        int[] NSE = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {

            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();

            }
            NSE[i] = stack.empty() ? arr.length : stack.peek();
            stack.push(i);
        }

        return NSE;
    }

    public static int[] findPSE(int[] arr) {
        int[] PSE = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {

            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();

            }
            PSE[i] = stack.empty() ? -1 : stack.peek();
            stack.push(i);
        }

        return PSE;

    }

}
