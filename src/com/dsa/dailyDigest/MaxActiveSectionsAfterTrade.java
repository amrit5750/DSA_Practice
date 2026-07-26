package com.dsa.dailyDigest;

public class MaxActiveSectionsAfterTrade {
    public static void main(String[] args) {
        System.out.println(maxActiveSectionsAfterTrade("01"));

    }

    public static int maxActiveSectionsAfterTrade(String s) {

        String t = "1" + s + "1";
        int n = t.length();

        int initialOnes = 0;
        for (char c : s.toCharArray()) {
            if (c == '1')
                initialOnes++;
        }

        int ans = initialOnes;

        int i = 1;

        while (i < n - 1) {

            if (t.charAt(i) == '0') {
                i++;
                continue;
            }

            // one block
            int oneStart = i;
            while (i < n && t.charAt(i) == '1')
                i++;
            int oneEnd = i - 1;

            // must be surrounded by zeros
            if (t.charAt(oneStart - 1) != '0' || t.charAt(oneEnd + 1) != '0')
                continue;

            // left zero block
            int left = oneStart - 1;
            while (left >= 0 && t.charAt(left) == '0')
                left--;

            int leftZeros = oneStart - left - 1;

            // right zero block
            int right = oneEnd + 1;
            while (right < n && t.charAt(right) == '0')
                right++;

            int rightZeros = right - oneEnd - 1;

            int oneLen = oneEnd - oneStart + 1;

            int mergedZeros = leftZeros + oneLen + rightZeros;

            int gain = mergedZeros - oneLen;

            ans = Math.max(ans, initialOnes + gain);
        }

        return ans;

    }

}
