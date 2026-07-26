package com.dsa.dailyDigest;

import java.util.HashMap;
import java.util.Map;

public class NumberOfSubstringsTwo {
    public static void main(String[] args) {

        String s = "abcabc";
        System.out.println(numberOfSubstrings(s));

    }

    public static int numberOfSubstrings(String s) {

        int count = 0;

        Map<Character, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int n = s.length();

        while (j < n) {
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);

            while (map.size() == 3) {
                count += n - j;
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) - 1);
                if (map.get(s.charAt(i)) <= 0) {
                    map.remove(s.charAt(i));

                }
                i++;

            }
            j++;

        }

        return count;

    }

}
