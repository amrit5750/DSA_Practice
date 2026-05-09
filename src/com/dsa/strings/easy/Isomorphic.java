package com.dsa.strings.easy;

public class Isomorphic {

    public static void main(String[] args) {

        String s = "egg";
        String t = "add";

        System.out.println(isIsomorphic(s, t));

    }

    public static boolean isIsomorphic(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        int[] sHash = new int[256];
        int[] tHash = new int[256];

        for (int i = 0; i < s.length(); i++) {

            if (sHash[s.charAt(i)] != tHash[t.charAt(i)]) {
                return false;
            }

            sHash[s.charAt(i)] = i + 1;
            tHash[t.charAt(i)] = i + 1;
        }
        return true;

    }

}
