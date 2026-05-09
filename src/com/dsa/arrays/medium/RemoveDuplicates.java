package com.dsa.arrays.medium;

import java.util.stream.Collectors;

public class RemoveDuplicates {

    public static void main(String[] args) {

        String s = "bcabc";
        System.out.println(removeDuplicateLetters(s));

    }

    public static String removeDuplicateLetters(String s) {

        String distinctChars = s.chars()
                .mapToObj(c -> String.valueOf((char) c))
                .distinct()
                .collect(Collectors.joining());

        return distinctChars;

    }

}
