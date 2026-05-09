package com.dsa.dp.Strings;

import java.util.HashMap;
import java.util.Map;

// Time:O(m*n*min(m,n))Space:O(m*n*min(m,n))

public class LongestCommonSubstring {

    static int maxLen = 0;
    static int endIndex = 0;

    public static void main(String[] args) {

        String str1 = "abcde";
        String str2 = "abfce";

        System.out.println(longestCommonSubstr(str1, str2));

    }

    public static String longestCommonSubstr(String str1, String str2) {
        Map<String, Integer> map = new HashMap<>();
        lcsHelper(str1, str2, 0, 0, map, 0);

        return str1.substring(endIndex - maxLen, endIndex);

    }

    public static int lcsHelper(String str1, String str2, int i, int j, Map<String, Integer> map,
            int currentLen) {

        if (i >= str1.length() || j >= str2.length()) {
            return currentLen;
        }

        String key = i + "|" + j + "|" + currentLen;

        if (map.containsKey(key)) {
            return map.get(key);
        }

        int len = currentLen;
        if (str1.charAt(i) == str2.charAt(j)) {
            len = lcsHelper(str1, str2, i + 1, j + 1, map, currentLen + 1);
            if (len > maxLen) {
                maxLen = len;
                endIndex = i + 1;
            }
        }
        lcsHelper(str1, str2, i + 1, j, map, 0);
        lcsHelper(str1, str2, i, j + 1, map, 0);
        map.put(key, len);
        return len;

    }

}
