package com.dsa.GoldmanSaches.Easy;

import java.util.Arrays;

public class MissingNumber {

    public static void main(String[] args) {

    }

    public int missingNumber(int[] nums) {

        int ArraySum = Arrays.stream(nums).sum();

        int n = nums.length;
        int sum = n * (n - 1) / 2;

        return sum - ArraySum;

    }

}
