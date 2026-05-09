package com.dsa.strings.medium;

import java.util.HashMap;
import java.util.Map;

public class ConvertRomanToNumber {

    public static void main(String[] args) {

        String s = "III"; // 58
        // MCMXCIV // 1994

        System.out.println(romanToInt(s));

    }

    public static int romanToInt(String s) {

        Map<Character, Integer> map = new HashMap<>();

        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int sum = 0;

        for (int i = 0; i < s.length() - 1; i++) {

            if (map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
                sum -= map.get(s.charAt(i));
            } else {
                sum += map.get(s.charAt(i));
            }
        }

        sum += map.get(s.charAt(s.length() - 1));
        return sum;
    }
}
