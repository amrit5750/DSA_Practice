package com.dsa.dp.Strings;

import java.util.HashMap;
import java.util.Map;

public class PrintLcs {

    public static void main(String[] args) {

        String str1 = "abcd";
        String str2 = "bdef";

        System.out.println(lcs(str1, str2));

    }

    public static String lcs(String str1, String str2) {
        Map<String, String> map = new HashMap<>();
        return lcsHelper(str1, str2, 0, 0, "", map);

    }

    public static String lcsHelper(String str1, String str2, int i, int j, String s, Map<String, String> map) {

        if (i >= str1.length() || j >= str2.length()) {
            return "";
        }

        String key = i + "|" + j;

        if (map.containsKey(key)) {
            return map.get(key);
        }

        if (str1.charAt(i) == str2.charAt(j)) {

            String str = str1.charAt(i) + lcsHelper(str1, str2, i + 1, j + 1, s, map);
            map.put(key, str);
            return str;
        } else {
            String s1 = lcsHelper(str1, str2, i + 1, j, s, map);
            String s2 = lcsHelper(str1, str2, i, j + 1, s, map);
            String str = (s1.length() > s2.length()) ? s1 : s2;
            map.put(key, str);
            return str;
        }

    }

}
