package com.dsa.slidingwindow.hard;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithatmostk {

    public static void main(String[] args) {

        String s = "pqpqs";
        int k = 2;

        System.out.println(longestSubstring(s, k));

    }

    public static String longestSubstring(String s, int k) {

        int length = Integer.MIN_VALUE;
        String result = null;
        int left = 0;

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);

            while (map.size() > k) {
                char ch = s.charAt(left);
                map.put(ch, map.get(ch) - 1);
                if (map.get(ch) <= 0) {
                    map.remove(ch);
                }
                left++;
            }

            int currentLength = i - left + 1;
            if (currentLength > length) {
                length = currentLength;
                result = s.substring(left, i + 1);
            }

        }

        return result;

    }

}
