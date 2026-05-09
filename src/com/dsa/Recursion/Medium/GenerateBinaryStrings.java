package com.dsa.Recursion.Medium;

import java.util.ArrayList;
import java.util.List;

public class GenerateBinaryStrings {

    public static void main(String[] args) {

        List<String> ls = generateBinaryStrings(3);
        System.out.println(ls);

    }

    public static List<String> generateBinaryStrings(int n) {

        List<String> result = new ArrayList<>();

        helperGenerateString("", 0, result, n);
        return result;
    }

    public static void helperGenerateString(String s, int last, List<String> result, int n) {

        if (n == s.length()) {
            result.add(s);
            return;
        }

        helperGenerateString(s + "0", 0, result, n);

        if (last == 0) {
            helperGenerateString(s + "1", 1, result, n);
        }
    }

}
