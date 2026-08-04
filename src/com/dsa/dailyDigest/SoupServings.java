package com.dsa.dailyDigest;

import java.util.HashMap;
import java.util.Map;

public class SoupServings {

    public static void main(String[] args) {

        System.out.println(soupServings(50));

    }

    public static double soupServings(int n) {
        int[][] serves = { { 100, 0 }, { 75, 25 }, { 50, 50 }, { 25, 75 } };
        Map<String, Double> memo = new HashMap<>();
        if (n >= 5000) {
            return 1;
        }
        return soupServingHelper(n, n, serves, memo);

    }

    public static double soupServingHelper(int A, int B, int[][] serves, Map<String, Double> memo) {
        if (A <= 0 && B <= 0) {
            return 0.5;
        }

        if (A <= 0) {
            return 1.0;
        }

        if (B <= 0) {
            return 0.0;
        }

        String key = A + "," + B;

        if (memo.containsKey(key))
            return memo.get(key);

        double probaility = 0.0;
        for (int[] serve : serves) {
            int take_A = serve[0];
            int take_B = serve[1];

            probaility += soupServingHelper(A - take_A, B - take_B, serves, memo);

        }
        probaility *= 0.25;
        memo.put(key, probaility);
        return probaility;

    }

}
