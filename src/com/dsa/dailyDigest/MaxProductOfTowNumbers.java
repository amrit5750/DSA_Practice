package com.dsa.dailyDigest;

import java.util.PriorityQueue;

public class MaxProductOfTowNumbers {
    public static void main(String[] args) {

        int[] nums = { 1, 5, 4, 5 };
        System.out.println(maxProduct(nums));

    }

    public static int maxProduct(int[] nums) {

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);

            if (queue.size() > 2) {
                queue.poll();
            }

        }

        return (queue.poll() - 1) * (queue.poll() - 1);
    }

}
