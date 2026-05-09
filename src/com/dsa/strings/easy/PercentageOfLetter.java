package com.dsa.strings.easy;

public class PercentageOfLetter {
    public static void main(String[] args) {

        System.out.println(percentageLetter("foobar", 'o'));

    }

    public static int percentageLetter(String s, char letter) {

        int counter = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == letter) {
                counter++;
            }
        }
        return (counter * 100) / s.length();

    }

}
