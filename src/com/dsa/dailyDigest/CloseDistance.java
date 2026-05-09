package com.dsa.dailyDigest;

public class CloseDistance {

    public static void main(String[] args) {

        String[] words = { "hello", "i", "am", "leetcode", "hello" };
        String target = "hello";
        int startIndex = 1;
        System.out.println(closestTarget(words, target, startIndex));

    }

    public static int closestTarget(String[] words, String target, int startIndex) {

        int result = Integer.MAX_VALUE;

        for (int i = 0; i < words.length; i++) {
            if (target.equals(words[i])) {
                int StraightDistance = Math.abs(i - startIndex);
                int circularDistacce = words.length - StraightDistance;
                result = Math.min(result, Math.min(StraightDistance, circularDistacce));

            }

        }
        return result == Integer.MAX_VALUE ? -1 : result;

    }

}
