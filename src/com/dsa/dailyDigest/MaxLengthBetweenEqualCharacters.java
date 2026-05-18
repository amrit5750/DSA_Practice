package com.dsa.dailyDigest;

public class MaxLengthBetweenEqualCharacters {
    public static void main(String[] args) {

        String s = "cbzxy";
        System.out.println(maxLengthBetweenEqualCharacters(s));

    }

    public static int maxLengthBetweenEqualCharacters(String s) {
        int[] first = new int[26];

        // initialize with -1
        for (int i = 0; i < 26; i++) {
            first[i] = -1;
        }

        int max = -1;

        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';

            if (first[idx] == -1) {
                first[idx] = i;
            } else {
                max = Math.max(max, i - first[idx] - 1);
            }
        }

        return max;

    }

}
