package com.dsa.strings.easy;

import java.util.Arrays;

public class ReverseString {

    public static void main(String[] args) {

        String s = new String("a good   example");

        System.out.println(getReverseString(s));

    }

    public static String getReverseString(String s) {

        StringBuilder string = new StringBuilder();

        String[] stringArray = s.split(" ");

        for (int i = stringArray.length - 1; i >= 0; i--) {

            if (!stringArray[i].isEmpty()) {
                string.append(stringArray[i]);
                string.append(" ");
            }

        }

        System.out.println(Arrays.toString(stringArray));

        return string.toString().trim();
    }

}
