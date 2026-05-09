package com.dsa.dailyDigest;

import java.util.ArrayList;
import java.util.List;

public class TwoEditWords {

    public static void main(String[] args) {

        String[] queries = { "yes" },
                dictionary = { "not" };

        System.out.println(twoEditWords(queries, dictionary));

    }

    public static List<String> twoEditWords(String[] queries, String[] dictionary) {

        List<String> result = new ArrayList<>();

        for (String query : queries) {
            for (String word : dictionary) {
                int diff = 0;
                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) != query.charAt(i)) {
                        diff++;
                        if (diff > 2) {
                            break;
                        }
                    }
                }
                if (diff <= 2) {
                    result.add(query);
                    break;
                }

            }

        }

        return result;

    }

}
