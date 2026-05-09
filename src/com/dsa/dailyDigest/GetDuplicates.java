package com.dsa.dailyDigest;

import java.util.ArrayList;
import java.util.List;

public class GetDuplicates {

    public static void main(String[] args) {

        int[] nums = { 4, 3, 2, 7, 8, 2, 3, 1 };

        System.out.println(findDuplicates(nums));

    }

    public static List<Integer> findDuplicates(int[] nums) {

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]);
            int index = num - 1;
            if (nums[index] < 0) {
                result.add(num);
            } else {
                nums[index] *= -1;
            }
        }

        return result;

    }

}
