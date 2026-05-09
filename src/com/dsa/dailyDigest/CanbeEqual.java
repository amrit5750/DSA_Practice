package com.dsa.dailyDigest;

public class CanbeEqual {

    public static void main(String[] args) {
        String s1 = "bnxw";
        String s2 = "bwxn";

        System.out.println(canBeEqual(s1, s2));

    }

    public static boolean canBeEqual(String s1, String s2) {

        if (s1.equals(s2)) {
            return true;
        }

        int i = 0;

        for (i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                break;
            }

        }

        int j = i + 2;
        char[] charString = s1.toCharArray();
        while (j < s2.length()) {
            char temp = charString[i];
            charString[i] = charString[j];
            charString[j] = temp;
            i++;
            j++;
            if (String.valueOf(charString).equals(s2)) {
                return true;
            }
        }
        return false;

    }
}
