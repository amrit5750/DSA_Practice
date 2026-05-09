package com.dsa.dailyDigest;

public class CanbeEqualII {

    public static void main(String[] args) {
        String s1 = "abcdba";
        String s2 = "cabdab";

        System.out.println(canBeEqual(s1, s2));

    }

    public static boolean canBeEqual(String s1, String s2) {

        int[] even = new int[26];
        int[] odd = new int[26];

        for (int i = 0; i < s1.length(); i++) {

            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);

            if (i % 2 == 0) {
                even[ch1 - 'a']++;
                even[ch2 - 'a']--;
            } else {
                odd[ch1 - 'a']++;
                odd[ch2 - 'a']--;
            }
        }

        for (int j = 0; j < even.length; j++) {

            if (even[j] != 0 || odd[j] != 0) {
                return false;
            }
        }
        return true;
    }
}
