package com.dsa.strings.medium;

public class SumOfBeautyOfAllSubstrings {

    public static void main(String[] args) {

        String s = "aabcb";
        System.out.println(beautySum(s));

    }

    public static int beautySum(String s) {

        int sum = 0;

        for (int i = 0; i < s.length(); i++) {

            int[] map = new int[26];

            for (int j = i; j < s.length(); j++) {

                map[s.charAt(j) - 'a']++;

                int mostFrequentChar = Integer.MIN_VALUE;
                int leastFrequencyChar = Integer.MAX_VALUE;

                for (int k = 0; k < map.length; k++) {
                    if (map[k] > 0) {
                        mostFrequentChar = Math.max(mostFrequentChar, map[k]);
                        leastFrequencyChar = Math.min(map[k], leastFrequencyChar);
                    }
                }
                sum += mostFrequentChar - leastFrequencyChar;
            }
        }
        return sum;
    }
}
