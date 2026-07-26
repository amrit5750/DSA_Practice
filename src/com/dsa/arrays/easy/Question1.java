package com.dsa.arrays.easy;

import java.util.ArrayList;

import java.util.List;

public class Question1 {

    public static void main(String[] args) {

        String s1 = "rahul";
        String s2 = "rajesh";

        System.out.println(getunCommonChar(s1, s2));

    }

    public static List<Character> getunCommonChar(String s1, String s2) {

        List<Character> result = new ArrayList<>();

        for (Character c : s1.toCharArray()) {
            if (s2.indexOf(c) == -1) {
                result.add(c);
            }
        }

        for (Character c : s2.toCharArray()) {
            if (s1.indexOf(c) == -1) {
                result.add(c);
            }
        }

        // Set<Character> set1 = new HashSet<>();
        // Set<Character> set2 = new HashSet<>();

        // for (int i = 0; i < s1.length(); i++) {
        // set1.add(s1.charAt(i));

        // }
        // for (int i = 0; i < s2.length(); i++) {
        // set1.add(s2.charAt(i));
        // }

        // for (Character ch : set1) {
        // if (!set2.contains(ch)) {
        // result.add(ch);
        // }
        // }

        // for (Character ch : set2) {
        // if (!set1.contains(ch)) {
        // result.add(ch);
        // }
        // }

        return result;

    }

}
