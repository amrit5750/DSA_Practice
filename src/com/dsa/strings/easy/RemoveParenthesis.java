package com.dsa.strings.easy;

public class RemoveParenthesis {

    public static void main(String[] args) {

        String s = "(()())(())";
        System.out.println(removeOuterParentheses(s));
    }

    public static String removeOuterParentheses(String s) {

        StringBuilder ans = new StringBuilder();

        int counter = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                if (counter > 0) {
                    ans.append(s.charAt(i));
                }
                counter++;
            } else {
                counter--;
                if (counter > 0) {
                    ans.append(s.charAt(i));
                }

            }

        }

        return ans.toString();

    }

}
