package com.dsa.Practice;

public class MaxProductSubarray {

    public static void main(String[] args) {

        int[] nums = { 2, 3, -2, 4 };

        System.out.println(maxProduct(nums));

    }

    public static int maxProduct(int[] nums) {

        int prefixproduct = 1;
        int suffixProduct = 1;

        int maxProduct = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {

            if (prefixproduct <= 0) {
                prefixproduct = 1;
            }
            if (suffixProduct <= 0) {
                suffixProduct = 1;
            }

            prefixproduct *= nums[i];
            suffixProduct *= nums[nums.length - i - 1];
            maxProduct = Math.max(maxProduct, Math.max(prefixproduct, suffixProduct));

        }

        return maxProduct;

    }

}
