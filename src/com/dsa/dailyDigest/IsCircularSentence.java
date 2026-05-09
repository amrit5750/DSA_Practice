package com.dsa.dailyDigest;

public class IsCircularSentence {
    public static void main(String[] args) {

        String sentence = "leetcode exercises sound delightful";
        System.out.println(isCircularSentence(sentence));

    }

    public static boolean isCircularSentence(String sentence) {

        String[] list = sentence.split(" ");
        boolean isAllMatched = true;

        for (int i = 0; i < list.length - 1; i++) {

            if (list[i].charAt(list[i].length() - 1) != list[i + 1].charAt(0)) {
                isAllMatched = false;
                break;
            }

        }

        if (isAllMatched) {
            String first = list[0];
            String last = list[list.length - 1];
            if (first.charAt(0) != last.charAt(last.length() - 1)) {
                isAllMatched = false;
            }
        }

        return isAllMatched;

    }

}
