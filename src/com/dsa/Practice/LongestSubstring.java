package com.dsa.Practice;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {

    public static void main(String[] args) {

        String s = "abcabcbb";

        System.out.println(lengthOfLongestSubstring(s));

    }

    public static int lengthOfLongestSubstring(String s) {

        Map<Character, Integer> map = new HashMap<>();

        int left = 0;
        int maxLen = 0;

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
