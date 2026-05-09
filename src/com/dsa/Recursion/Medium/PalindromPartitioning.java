package com.dsa.Recursion.Medium;

import java.util.ArrayList;
import java.util.List;

public class PalindromPartitioning {

    public static void main(String[] args) {

        String s = "aab";
        System.out.println(partition(s));

    }

    public static List<List<String>> partition(String s) {

        List<List<String>> result = new ArrayList<>();
        partitionHelper(s, 0, new ArrayList<>(), result);
        return result;

    }

    public static boolean isPalindrom(String s, int start, int end) {

        int low = start;
        int high = end;
        while (low < high) {
            if (s.charAt(low) != s.charAt(high)) {
                return false;
            }
            low++;
            high--;
        }
        return true;
    }

    public static void partitionHelper(String s, int index, List<String> current, List<List<String>> result) {

        if (index == s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if (isPalindrom(s, index, i)) {
                current.add(s.substring(index, i + 1));
                partitionHelper(s, i + 1, current, result);
                current.remove(current.size() - 1);
            }
        }
    }
}
