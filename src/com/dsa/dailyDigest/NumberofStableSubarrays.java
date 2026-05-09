package com.dsa.dailyDigest;

//https://leetcode.com/problems/number-of-stable-subarrays/description/
//You are given three integers zero, one, and limit. You have zero 0's and one 1's. A subarray is stable if the absolute difference between the number of 0's and the number of 1's in the subarray is at most limit.
// Return the number of stable subarrays you can create using all zero 0's and one 1
// Since the answer may be too large, return it modulo 109 + 7.
// A subarray is a contiguous non-empty sequence of elements within an array.
// Example 1:
//Input: zero = 2, one = 1, limit = 1
//Output: 3
//Explanation: The stable subarrays are:
//- [0,0,1] (the absolute difference is 1)
//- [0,1] (the absolute difference is 1)
//- [1] (the absolute difference is 1)
//Example 2:
//Input: zero = 3, one = 3, limit = 2
//Output: 20
//Explanation: Some of the stable subarrays are:
//- [0,0,0,1,1,1] (the absolute difference is 0)
//- [0,0,1,1] (the absolute difference is 0)
//- [0,1] (the absolute difference is 0)
//- [1] (the absolute difference is 0)  
//time complexity: O(zero * one * limit)
//space complexity: O(zero * one * 2)

//why 3DPDP solution?
//we need to keep track of the number of zeros and ones left to use, as well as the last used element (0 or 1) to ensure we are creating stable subarrays. The 3D DP array allows us to store results for different combinations of these parameters, avoiding redundant calculations and improving efficiency.
//In this problem, we are trying to count the number of stable subarrays that can be formed using a given number of zeros and ones, while ensuring that the absolute difference between the count of zeros and ones in any subarray does not exceed a specified limit. The 3D DP approach is suitable here because we need to keep track of three parameters: the number of zeros left, the number of ones left, and the last used element (0 or 1). This allows us to efficiently explore all possible combinations and avoid redundant calculations, ultimately leading to an optimal solution.
public class NumberofStableSubarrays {

    static int MOD = 1_000_000_007;
    static Integer[][][] dp;

    public static void main(String[] args) {

        System.out.println(numberOfStableArrays(3, 3, 2));

    }

    public static int numberOfStableArrays(int zero, int one, int limit) {
        // why +1 in dp array size?
        // The +1 in the DP array size is to accommodate the case when there are zero
        // zeros or ones left. Since we are using 1-based indexing for the number of
        // zeros and ones, we need to ensure that the DP array can store results for all
        // possible counts, including the case when there are no zeros or ones left to
        // use. This allows us to handle the base case where both zeros and ones are
        // exhausted, which is essential for the recursive calculations in our DP
        // approach.
        dp = new Integer[zero + 1][one + 1][2];

        return (getStableSubarrays(zero, one, 0, limit) + getStableSubarrays(zero, one, 1, limit)) % MOD;
    }

    public static int getStableSubarrays(int zerosLeft, int onesLeft, int lastUsed, int limit) {

        int res = 0;

        if (zerosLeft == 0 && onesLeft == 0) {
            return 1;
        }

        if (dp[zerosLeft][onesLeft][lastUsed] != null) {
            return dp[zerosLeft][onesLeft][lastUsed];
        }

        if (lastUsed == 1) {
            for (int i = 1; i <= Math.min(zerosLeft, limit); i++) {
                res = (res + getStableSubarrays(zerosLeft - i, onesLeft, 0, limit)) % MOD;
            }
        } else {
            for (int i = 1; i <= Math.min(onesLeft, limit); i++) {
                res = (res + getStableSubarrays(zerosLeft, onesLeft - i, 1, limit)) % MOD;
            }
        }
        // Store the result in the DP array before returning
        // how assigning res to dp array helps in optimization?
        // Assigning the result to the DP array helps in optimization by storing the
        // computed results for specific combinations of zeros left, ones left, and last
        // used element. This way, if the same combination is encountered again during
        // the recursive calls, we can directly return the stored result from the DP
        // array instead of recalculating it. This avoids redundant calculations and
        // significantly reduces the time complexity of the algorithm, especially when
        // there are overlapping subproblems, which is common in recursive solutions. By
        // using memoization through the DP array, we can achieve a more efficient
        // solution to the problem.

        return dp[zerosLeft][onesLeft][lastUsed] = res;

    }

}
