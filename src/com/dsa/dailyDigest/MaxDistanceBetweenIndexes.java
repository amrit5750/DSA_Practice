package com.dsa.dailyDigest;

public class MaxDistanceBetweenIndexes {

    public static void main(String[] args) {

        int[] nums1 = { 55, 30, 5, 4, 2 };
        int[] nums2 = { 100, 20, 10, 10, 5 };
        System.out.println(maxDistance(nums1, nums2));

    }

    public static int maxDistance(int[] nums1, int[] nums2) {

        int i = 0;
        int j = 0;
        int result = Integer.MIN_VALUE;
        while (i < nums1.length && j < nums2.length) {

            if (nums1[i] > nums2[j]) {
                i++;
                if (i > j) {
                    j = i;
                }
            } else {
                result = Math.max(j - i, result);
                j++;
            }

        }

        return result == Integer.MIN_VALUE ? 0 : result;
    }

}
