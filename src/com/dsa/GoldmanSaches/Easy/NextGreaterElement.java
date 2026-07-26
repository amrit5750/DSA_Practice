package com.dsa.GoldmanSaches.Easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NextGreaterElement {

    public static void main(String[] args) {

        int[] nums1 = { 4, 1, 2 };

        int[] nums2 = { 1, 3, 4, 2 };
        System.out.println(Arrays.toString(nextGreaterElement(nums1, nums2)));

    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], i);
        }

        int[] ans = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            if (map.containsKey(nums1[i])) {
                int index = map.get(nums1[i]);
                ans[i] = getNextGreater(index, nums2, nums1[i]);
            }
        }
        return ans;

    }

    public static int getNextGreater(int index, int[] nums2, int num) {

        for (int i = index + 1; i < nums2.length; i++) {

            if (nums2[i] > num) {
                return nums2[i];

            }

        }
        return -1;
    }

}
