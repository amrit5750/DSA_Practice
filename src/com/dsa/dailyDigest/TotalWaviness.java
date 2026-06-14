package com.dsa.dailyDigest;

import java.util.HashMap;
import java.util.Map;

public class TotalWaviness {

    static Map<String, long[]> map;

    public static void main(String[] args) {

        System.out.println(totalWaviness(120, 130));

    }

    public static long totalWaviness(long num1, long num2) {

        return getWaves(num2) - getWaves(num1 - 1);

    }

    public static long getWaves(long num) {
        map = new HashMap<>();
        String str = String.valueOf(num);

        if (str.length() < 3) {
            return 0;
        }

        long ans[] = helper(str, 0, true, -1, -1, true);
        return ans[1];
    }

    public static long[] helper(String s, int idx, boolean isBound, int twobefore, int onebefore,
            boolean leadingZero) {

        // Base case: full number formed
        if (idx == s.length()) {
            // Leading zero means the number was effectively empty/zero — not valid
            return leadingZero ? new long[] { 0, 0 } : new long[] { 1, 0 };
        }

        String key = idx + "#" + isBound + "#" + twobefore + "#" + onebefore + "#" + leadingZero;
        if (map.containsKey(key))
            return map.get(key);

        int upper = isBound ? (s.charAt(idx) - '0') : 9;
        long totalCount = 0L, totalWaves = 0L;

        for (int i = 0; i <= upper; i++) {
            long wave = 0;
            int nextTwoBefore, nextOneBefore;

            if (leadingZero) {
                // Still in leading zero phase — don't count digits as part of the number yet
                nextTwoBefore = -1;
                nextOneBefore = (i == 0) ? -1 : i;
            } else {
                nextTwoBefore = onebefore;
                nextOneBefore = i;

                // Check if onebefore forms a wave peak or valley with its neighbors
                if (twobefore >= 0 && onebefore >= 0) {
                    if ((onebefore > twobefore && onebefore > i) // peak
                            || (onebefore < twobefore && onebefore < i)) // valley
                        wave = 1;
                }
            }

            boolean nextBound = isBound && (i == upper);
            boolean nextLeadingZero = leadingZero && (i == 0);

            long[] sub = helper(s, idx + 1, nextBound, nextTwoBefore, nextOneBefore, nextLeadingZero);

            totalCount += sub[0];
            // Each of the sub[0] numbers contributes the current wave, plus their own
            // internal waves
            totalWaves += sub[1] + sub[0] * wave;
        }

        long[] result = { totalCount, totalWaves };
        map.put(key, result);
        return result;

    }

}
