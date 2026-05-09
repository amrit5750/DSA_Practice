package com.dsa.Recursion.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//time complexity: O(4^n) where n is the length of the input digits string (since each digit can map to at most 4 letters)
//space complexity: O(k) where k is the depth of the recursion tree (which can be at most the length of the input digits string)
// This is a backtracking problem where we explore all possible combinations of letters that can be formed from the input digits string. We use a map to store the mapping of digits to letters, and
// we recursively build the combinations by appending letters corresponding to each digit and moving to the next digit until we reach the end of the input string. When we reach the end, we add the current combination to the result list.
// We also need to handle the base case where the input digits string is empty, in which case we return an empty list.
// We also need to handle the case where the input digits string contains invalid characters (not between 2 and 9), in which case we can simply ignore those characters and continue building combinations with the valid digits.
public class LetterCombination {

    public static void main(String[] args) {

        String digits = "23";

        System.out.println(letterCombinations(digits));

    }

    public static List<String> letterCombinations(String digits) {
        Map<Integer, String> map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");

        List<String> result = new ArrayList<>();

        letterCombinationsHelper(digits, 0, "", result, map);

        return result;

    }

    public static void letterCombinationsHelper(String str, int index, String temp, List<String> result,
            Map<Integer, String> map) {

        if (index == str.length()) {
            result.add(temp);
            return;
        }

        char ch = str.charAt(index);
        String letters = map.get(Integer.parseInt(String.valueOf(ch)));

        for (int i = 0; i < letters.length(); i++) {
            letterCombinationsHelper(str, index + 1, temp + letters.charAt(i), result, map); // recursive call

            // as Strings are immuatable in nature so it will not affect

        }
    }

}
