package com.dsa.dailyDigest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RearrangeBarcodes {
    public static void main(String[] args) {

        int[] barcodes = { 1, 1, 1, 2, 2, 2 };
        System.out.println(Arrays.toString(rearrangeBarcodes(barcodes)));

    }

    public static int[] rearrangeBarcodes(int[] barcodes) {

        int[] ans = new int[barcodes.length];

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < ans.length; i++) {
            map.put(barcodes[i], map.getOrDefault(barcodes[i], 0) + 1);
        }

        List<Integer> nums = new ArrayList<>(map.keySet());
        nums.sort((a, b) -> map.get(b) - map.get(a));

        int idx = 0;

        for (Integer num : nums) {
            int count = map.get(num);

            while (count != 0) {
                ans[idx] = num;
                count--;
                idx += 2;

                if (idx >= ans.length) {
                    idx = 1;
                }
            }
        }
        return ans;
    }

}
