package com.dsa.dailyDigest;

public class MinOperationsTwo {

    public static void main(String[] args) {

        String s1 = "11";
        String s2 = "00";
        System.out.println(minOperations(s1, s2));

    }

    public static int minOperations(String s1, String s2) {

        if (s1.equals("1") && s2.equals("0")) {
            return -1;
        }
        char[] s = s1.toCharArray();
        int res = 0, n = s1.length();
        for (int i = 0; i < n; i++) {
            if (s[i] == s2.charAt(i))
                continue;
            if (s[i] == '0') {
                res++;
            } else if (i < n - 1) {
                res += s[i + 1] == '1' ? 1 : 2;
                s[i + 1] = '0';
            } else {
                res += 2;
            }
        }
        return res;

    }

}
