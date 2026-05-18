package com.dsa.dailyDigest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SeparateDigits {
    public static void main(String[] args) {

        int[] nums = { 13, 25, 83, 77 };
        // Output: [1,3,2,5,8,3,7,7]
        System.out.println(Arrays.toString(separateDigits(nums)));

    }

    public static int[] separateDigits(int[] nums) {

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            List<Integer> ls = new ArrayList<>();
            while (nums[i] > 0) {
                int rem = nums[i] % 10;
                nums[i] = nums[i] / 10;
                ls.add(rem);
            }
            Collections.reverse(ls);
            ans.addAll(ls);
        }

        int[] result = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);

        }
        return result;

    }

}
