package com.dsa.Stack.Easy;

public class ReversePrefix {

    public static void main(String[] args) {

        String word = "abcdefd";
        char ch = 'd';

        System.out.println(reversePrefix(word, ch));

    }

    public static String reversePrefix(String word, char ch) {

        int idx = word.indexOf(ch);

        if (idx == -1)
            return word;

        StringBuilder sb = new StringBuilder(word.substring(0, idx + 1));
        sb.reverse();

        sb.append(word.substring(idx + 1));

        return sb.toString();

    }

}
