package com.dsa.Tries;

import java.util.LinkedHashMap;
import java.util.Map;

public class Frequency {

    public static void main(String[] args) {

        String s = "swiss";
        getFirstWord(s);

    }

    public static void getFirstWord(String str) {

        Map<Character, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < str.length(); i++) {
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
        }

        for (java.util.Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                System.out.println(entry.getKey());
                break;
            }

        }

    }

}
