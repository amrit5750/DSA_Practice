package com.dsa.Recursion.Medium;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

    public static void main(String[] args) {

        System.out.println(generateParenthesis(3));

    }

    public static List<String> generateParenthesis(int n) {

        List<String> list = new ArrayList<>();

        helper("", 0, 0, list, n);

        return list;

    }

    public static void helper(String s, int open, int close, List<String> list, int n) {

        if (s.length() == 2 * n) {
            list.add(s);
            return;
        }

        if (open < n) {
            helper(s + "(", open + 1, close, list, n);
        }

        if (close < open) {
            helper(s + ")", open, close + 1, list, n);
        }
    }

}
