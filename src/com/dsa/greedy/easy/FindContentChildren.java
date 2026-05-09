package com.dsa.greedy.easy;

import java.util.Arrays;

public class FindContentChildren {

    public static void main(String[] args) {

        int[] g = { 3, 4, 5, 6, 7, 8 }, s = { 6, 7, 8 };

        System.out.println(findContentChildren(g, s));

    }

    public static int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);

        int cookies = 0;
        int children = 0;

        while (cookies < s.length && children < g.length) {
            if (s[cookies] >= g[children]) {
                children++;
            }
            cookies++;
        }

        return children;

    }

}
