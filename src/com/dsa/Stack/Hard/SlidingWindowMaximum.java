package com.dsa.Stack.Hard;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {

    public static void main(String[] args) {

        int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };

        System.out.println(Arrays.toString(maxSlidingWindowOptimal(nums, 3)));

    }

    public static int getMax(int[] window) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < window.length; i++) {
            max = Math.max(max, window[i]);
        }
        return max;
    }

    public static int[] maxSlidingWindowOptimal(int[] nums, int k) {

        if (nums == null || nums.length == 0 || k <= 0)
            return new int[0];

        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {

            // maintaing the size of the window
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }
            // remove the smaller element from the back
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            deque.offerLast(i);

            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }

        return result;

    }

    // public static int[] maxSlidingWindow(int[] nums, int k) {

    // int[] arr = new int[nums.length - k + 1];

    // int[] window = new int[k];

    // for (int i = 0; i < k; i++) {
    // window[i] = nums[i];

    // }
    // arr[0] = getMax(window);

    // int j = 0;
    // for (int i = k; i < nums.length; i++) {
    // window[j % k] = nums[i];
    // arr[j + 1] = getMax(window);
    // j++;
    // }
    // return arr;

    // }

}
