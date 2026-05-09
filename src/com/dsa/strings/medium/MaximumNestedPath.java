package com.dsa.strings.medium;

public class MaximumNestedPath {

    public static void main(String[] args) {

        String s = "(1+(2*3)+((8)/4))+1";
        System.out.println(maxDepth(s));

    }

    public static int maxDepth(String s) {

        int counter = 0;
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                counter++;
            }
            if (s.charAt(i) == ')') {

                max = Math.max(max, counter);
                counter--;
            }
        }
        return max;

    }

}
