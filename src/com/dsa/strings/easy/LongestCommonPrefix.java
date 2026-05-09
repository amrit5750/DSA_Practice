package com.dsa.strings.easy;

import java.util.Arrays;

public class LongestCommonPrefix {

    public static void main(String[] args) {

        String[] strs = { "flower", "flow", "flight" };

        System.out.println(longestCommonPrefix(strs));

    }

    public static String longestCommonPrefix(String[] strs) {

        if (strs.length == 1) {
            return strs[0];
        }

        String comString = "";

        Arrays.sort(strs);

        String firstString = strs[0];
        String lastString = strs[strs.length - 1];

        int i = 0;

        while (i < firstString.length() && i < lastString.length()) {
            if (firstString.charAt(i) == lastString.charAt(i)) {
                comString += firstString.charAt(i);
                i++;
            } else {
                break;
            }
        }
        return comString;

    }

}
