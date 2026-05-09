package com.dsa.slidingwindow.medium;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepChar {

    public static void main(String[] args) {

        String s = "abcabcbb";

        System.out.println(lengthOfLongestSubstring(s));

    }

    public static int lengthOfLongestSubstring(String s) {

        int maxLen = 0;
        int left = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);

            }
            map.put(s.charAt(i), i);

            maxLen = Math.max(maxLen, i - left + 1);

        }

        return maxLen;

    }

}
