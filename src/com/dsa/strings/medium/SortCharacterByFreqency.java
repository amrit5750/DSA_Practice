package com.dsa.strings.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortCharacterByFreqency {

    public static void main(String[] args) {

        String s = "tree";
        System.out.println(frequencySort(s));

    }

    public static String frequencySort(String s) {

        StringBuilder res = new StringBuilder();

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);

        }

        List<Character> list = new ArrayList<>(map.keySet());

        Collections.sort(list, (a, b) -> map.get(b) - map.get(a));

        for (char ch : list) {
            int count = map.get(ch);

            for (int i = 0; i < count; i++) {
                res.append(ch);
            }
        }
        return res.toString();
    }
}
