package com.dsa.BinarySearch.BSOnAnswers;

public class MinimizeGasStationDistance {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5 };
        int k = 4;

        System.out.println(getMinDistance(nums, k));

    }

    public static double getMinDistance(int[] nums, int k) {

        double low = 0;
        double high = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            high = Math.max(high, nums[i + 1] - nums[i]);
        }

        double diff = 1e-6;
        double ans = 0;

        while (high - low > diff) {
            double mid = (low + high) / 2.0;

            int cnt = getGasStations(nums, mid);

            if (cnt > k) {
                low = mid;
            } else {
                high = mid;
                ans = high;
            }
        }
        return ans;

    }

    public static int getGasStations(int[] nums, double mid) {

        int count = 0;

        for (int i = 1; i < nums.length; i++) {
            double dist = nums[i] - nums[i - 1];
            // we are using ceil because if the distance is 3.2 and mid is 1 then we need 3
            // gas stations to cover that distance
            // this will give us the total number of gas stations needed to cover the
            // distance between two gas stations and we need to subtract 1 because we are
            // not counting the gas station at the end of the distance
            // it will give me the segments of the distance and we need to subtract 1
            // because we are not counting the gas station at the end of the distance
            count += (int) Math.ceil(dist / mid) - 1;

        }

        return count;
    }
}
