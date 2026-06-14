package com.dsa.dailyDigest;

public class TotalWavinessThree {

    public static void main(String[] args) {

        int num1 = 120;
        int num2 = 130;

        System.out.println(totalWaviness(num1, num2));

    }

    public static long totalWaviness(long num1, long num2) {

        return getWaves(num2) - getWaves(num1 - 1);
    }

    public static long getWaves(long num) {

        String str = String.valueOf(num);

        if (str.length() < 3) {
            return 0;
        }

        long ans[] = helper(str, 0, -1, -1, true, true);
        return ans[1];

    }

    public static long[] helper(String str, int index, int prev, int prePrec, boolean isbound, boolean isLeadingZeros) {

        if (index == str.length()) {
            return new long[] { 1, 0 }; // no score can be generated
        }

        long totalNumers = 0;
        long totalWaves = 0;

        int limitDigit = isbound ? str.charAt(index) - '0' : 9;

        for (int digit = 0; digit <= limitDigit; digit++) {
            boolean isNewLeadingZerops = isLeadingZeros && (digit == 0);

            int newPrevPrev = prev;
            int newPrev = isNewLeadingZerops ? -1 : digit;

        }

        return new long[] { totalNumers, totalWaves };

    }

}
