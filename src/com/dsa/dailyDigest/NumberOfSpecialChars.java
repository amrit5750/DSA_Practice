package com.dsa.dailyDigest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberOfSpecialChars {

    public static void main(String[] args) {

        System.out.println(numberOfSpecialChars("AbBCab"));

    }

    public static int numberOfSpecialChars(String word) {

        Map<Character, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < word.length(); i++) {
            map.computeIfAbsent(word.charAt(i), k -> new ArrayList<>()).add(i);
        }
        int count = 0;
        for (char ch = 'a'; ch <= 'z'; ch++) {
            char lower = ch;
            char upper = Character.toUpperCase(ch);

            if (map.containsKey(lower) && map.containsKey(upper)) {
                List<Integer> lowerIndices = map.get(lower);
                List<Integer> upperIndices = map.get(upper);

                int lastLower = lowerIndices.get(lowerIndices.size() - 1);
                int firstUpper = upperIndices.get(0);

                if (lastLower < firstUpper) {
                    count++;
                }
            }
        }
        return count;
    }
}
