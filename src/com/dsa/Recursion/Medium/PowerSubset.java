package com.dsa.Recursion.Medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PowerSubset {

    public static void main(String[] args) {

        String s = "abc";
        System.out.println(getSubStrings(s));

    }

    public static List<String> getSubStrings(String s) {

        List<String> result = new ArrayList<>();
        getSubStringHelper(s, "", 0, result);

        Collections.sort(result);

        return result;

    }

    public static void getSubStringHelper(String s, String current, int index, List<String> result) {

        if (index >= s.length()) {
            if (!current.isEmpty()) {
                result.add(current);
            }
            return;
        }
        getSubStringHelper(s, current + s.charAt(index), index + 1, result);
        getSubStringHelper(s, current, index + 1, result);
    }

}
