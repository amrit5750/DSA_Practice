package com.dsa.dailyDigest;

public class MapWordWeights {

    static int Mod = 26;

    public static void main(String[] args) {
        String[] words = { "abcd", "def", "xyz" };
        int[] weights = { 5, 3, 12, 14, 1, 2, 3, 2, 10, 6, 6, 9, 7, 8, 7, 10, 8, 9, 6, 9, 9, 8, 3, 7, 7, 2 };
        System.out.println(mapWordWeights(words, weights));
    }

    public static String mapWordWeights(String[] words, int[] weights) {

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < words.length; i++) {

            String word = words[i];
            int number = 0;
            for (int j = 0; j < word.length(); j++) {
                number += weights[word.charAt(j) - 'a'];
            }

            int mod = number % 26;
            char mappedChar = (char) ('z' - mod);
            stringBuilder.append(mappedChar);
        }
        return stringBuilder.toString();

    }

}
