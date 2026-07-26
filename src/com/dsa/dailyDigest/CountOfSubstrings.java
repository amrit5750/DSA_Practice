package com.dsa.dailyDigest;

import java.util.HashMap;
import java.util.Map;

public class CountOfSubstrings {

    public static void main(String[] args) {

        String word = "aeioqq";
        int k = 1;
        System.out.println(countOfSubstrings(word, k));

    }

    public static long countOfSubstrings(String word, int k) {

        int n = word.length();
        Map<Character, Integer> map = new HashMap<>();

        int[] nextCons = new int[n];

        int nextConstSeen = n;
        for (int i = n - 1; i >= 0; i--) {
            nextCons[i] = nextConstSeen;
            if (!isVowel(word.charAt(i))) {
                nextConstSeen = i;
            }

        }

        int i = 0;
        int j = 0;
        long ans = 0;
        int cons = 0;
        while (j < n) {
            char ch = word.charAt(j);
            if (isVowel(ch)) {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            } else {
                cons++;
            }

            while (cons > k) {
                char ch_ = word.charAt(i);
                if (isVowel(ch_)) {
                    map.put(ch_, map.getOrDefault(ch_, 0) - 1);

                    if (map.get(ch_) <= 0) {
                        map.remove(ch_);
                    }

                } else {
                    cons--;

                }
                i++;
            }

            while (map.size() == 5 && cons == k) {
                int idx = nextCons[j];
                ans += idx - j;
                char ch_ = word.charAt(i);
                if (isVowel(ch_)) {
                    map.put(ch_, map.getOrDefault(ch_, 0) - 1);

                    if (map.get(ch_) <= 0) {
                        map.remove(ch_);
                    }

                } else {
                    cons--;

                }
                i++;

            }
            j++;

        }
        return ans;

    }

    public static boolean isVowel(char ch) {
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
            return true;
        }
        return false;
    }

}
