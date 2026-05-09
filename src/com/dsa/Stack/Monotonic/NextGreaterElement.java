package com.dsa.Stack.Monotonic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement {

    public static void main(String[] args) {

        int[] nums1 = { 4, 1, 2 };
        int[] nums2 = { 1, 3, 4, 2 };

        System.out.println(Arrays.toString(nextGreaterElement(nums1, nums2)));

    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int[] ans = new int[nums1.length];
        Stack<Integer> stack = new Stack<>();

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], i);

        }

        for (int i = nums2.length - 1; i >= 0; i--) {

            while (!stack.isEmpty() && stack.peek() <= nums2[i]) {
                stack.pop();
            }

            if (map.containsKey(nums2[i])) {
                int index = map.get(nums2[i]);

                if (stack.isEmpty()) {
                    ans[index] = -1;
                } else {
                    ans[index] = stack.peek();
                }

            }

            stack.push(nums2[i]);

        }

        return ans;

    }

}
