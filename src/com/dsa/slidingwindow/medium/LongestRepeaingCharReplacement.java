package com.dsa.slidingwindow.medium;

//time complexity O(n) and space complexity O(1)
//https://leetcode.com/problems/longest-repeating-character-replacement/description/
//how to works
//1. we will keep track of the frequency of the characters in the current window using a hash array of size 26 (assuming only uppercase letters).
//2. we will also keep track of the maximum frequency of any character in the current window.
//3. we will expand the right pointer of the window and update the frequency of the current character and the maximum frequency.
//4. if the length of the current window minus the maximum frequency is greater than k, it means we need to shrink the window from the left until the condition is satisfied.
//5. we will keep track of the maximum length of the window that satisfies the condition and return it at the end.
public class LongestRepeaingCharReplacement {

    public static void main(String[] args) {

        String s = "ABAB";
        int k = 2;
        System.out.println(characterReplacement(s, k));
    }

    public static int characterReplacement(String s, int k) {

        int len = 0;
        int maxFrequency = 0;
        int left = 0;
        int right = 0;

        int[] hash = new int[26];

        while (right < s.length()) {

            hash[s.charAt(right) - 'A']++;
            maxFrequency = Math.max(maxFrequency, hash[s.charAt(right) - 'A']);

            while (right - left + 1 - maxFrequency > k) {
                hash[s.charAt(left) - 'A']--;
                left++;
            }

            len = Math.max(len, right - left + 1);
            right++;
        }
        return len;

    }

}
