package com.dsa.greedy.easy;

import java.util.Arrays;

// LeetCode Problem 455. Assign Cookies
// time complexity: O(n log n)
// space complexity: O(1)
// how to solve: Greedy Algorithm
// how it works: Sort both the greed factor array and the cookie size array. 
// Use two  pointers to iterate through both arrays.
public class AssignCookies {

    public static void main(String[] args) {

        int[] greeds = { 1, 2, 3 };
        int[] cookies = { 1, 1 };

        System.out.println(findContentChildren(greeds, cookies));

    }

    public static int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);
        int cookiesIndex = 0;
        int childIndex = 0;

        while (childIndex < g.length && cookiesIndex < s.length) {
            if (g[childIndex] <= s[cookiesIndex]) {
                childIndex++;
            }
            cookiesIndex++;
        }

        return childIndex;
    }

}
