package com.dsa.contest.fourSeventyeight;

import java.util.HashSet;
import java.util.Set;

public class MaximumStringsDistinctStart {

    public static void main(String[] args) {

        String s = "abcd";

        System.out.println(maxDistinct(s));

    }

    public static int maxDistinct(String s) {

        Set<Character> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));

        }
        return set.size();

    }

}
