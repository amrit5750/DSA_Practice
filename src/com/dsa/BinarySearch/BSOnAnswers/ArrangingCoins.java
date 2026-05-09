package com.dsa.BinarySearch.BSOnAnswers;

public class ArrangingCoins {

    public static void main(String[] args) {

        System.out.println(arrangeCoins(1));

    }

    public static int arrangeCoins(int n) {

        int ans = 0;
        long start = 1;
        long end = n;
        while (start <= end) {
            long mid = start + (end - start) / 2;
            long sum = (long) (mid * (mid + 1)) / 2;
            if (sum <= n) {
                start = mid + 1;
                ans = (int) mid;
            } else
                end = mid - 1;
        }

        return ans;

    }
}
