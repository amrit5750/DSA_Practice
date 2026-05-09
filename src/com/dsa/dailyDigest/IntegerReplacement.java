package com.dsa.dailyDigest;

import java.util.HashMap;
import java.util.Map;

public class IntegerReplacement {

    static Map<Long, Integer> memo = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(integerReplacement(7));
    }

    public static int integerReplacement(int n) {
        return helper((long) n);
    }

    public static int helper(long n) {

        // base case
        if (n == 1) {
            return 0;
        }

        // check memo
        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        int ans;

        if (n % 2 == 0) {
            ans = 1 + helper(n / 2);
        } else {
            ans = 1 + Math.min(helper(n - 1), helper(n + 1));
        }

        // store result
        memo.put(n, ans);

        return ans;
    }
}