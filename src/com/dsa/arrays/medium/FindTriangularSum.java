package com.dsa.arrays.medium;

public class FindTriangularSum {

    public static void main(String[] args) {
        int[] nums = { 5 };

        System.out.println(triangularSum(nums));

    }

    public static int triangularSum(int[] nums) {

        int counter = 0;
        int[] ans = nums;
        while (counter < nums.length - 1) {
            ans = getArray(ans);
            counter++;
        }
        return ans[0];
    }

    public static int[] getArray(int[] arr) {
        int[] ans = new int[arr.length - 1];

        for (int i = 0; i < arr.length - 1; i++) {
            ans[i] = (arr[i] + arr[i + 1]) % 10;
        }
        return ans;
    }

    public static int triangularSumOptimal(int[] nums) {

        int n = nums.length;
        int result = 0;
        int combination = 1; // C(n-1, 0)

        for (int i = 0; i < n; i++) {
            result = (result + combination * nums[i]) % 10;
            combination = combination * (n - 1 - i) / (i + 1);
        }

        return result;
    }

}
