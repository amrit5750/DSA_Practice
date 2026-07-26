package com.dsa.dailyDigest;

public class MinimumCostTwo {

    static int MOD = 1000000007;

    public static void main(String[] args) {

        int[] nums = { 1, 2, 3, 4 };
        int k = 4;
        System.out.println(minimumCost(nums, k));

    }

    public static int minimumCost(int[] nums, int k) {

        long available = k;
        long totalCost = 0;
        long operationsDone = 0;

        for (int num : nums) {

            if (available < num) {

                long need = num - available;
                long ops = (need + k - 1L) / k; // Ceiling division

                long first = operationsDone + 1;
                long last = operationsDone + ops;

                // Sum of arithmetic progression:
                // first + (first+1) + ... + last
                totalCost += (first + last) * ops / 2;

                operationsDone += ops;
                available += ops * (long) k;
            }

            available -= num;
        }

        return (int) (totalCost % MOD);

    }

}
