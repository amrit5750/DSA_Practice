package com.dsa.strings.medium;

import java.util.HashMap;
import java.util.Map;

public abstract class CountNumberofSubstrings {

    public static void main(String[] args) {

        String s = "pqpqs";
        int k = 2;

        // we need to get the eactly k Distinct Chararters string so call the function
        // with
        // s,k and s,k-1 the return the difference
        System.out.println(CountStrings(s, k) - CountStrings(s, k - 1));

    }

    // this will give all the Substring which having atmost k distinct character.
    public static int CountStrings(String s, int k) {

        if (k < 0)
            return 0;

        int count = 0;

        Map<Character, Integer> map = new HashMap<>();
        int left = 0;

        for (int i = 0; i < s.length(); i++) {

            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);

            while (map.size() > k) {
                char ch = s.charAt(left);
                map.put(ch, map.get(ch) - 1);
                if (map.get(ch) <= 0) {
                    map.remove(ch);
                }
                left++;
            }

            count += i - left + 1;

        }

        return count;

    }

}
