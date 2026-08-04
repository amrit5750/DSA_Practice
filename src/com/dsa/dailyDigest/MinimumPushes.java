package com.dsa.dailyDigest;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class MinimumPushes {

    public static void main(String[] args) {
        System.out.println(minimumPushes("aabbccddeeffgghhiiiiii"));

    }

    public static int minimumPushes(String word) {

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            map.put(word.charAt(i), map.getOrDefault(word.charAt(i), 0) + 1);
        }

        Map<Character, Integer> sortedMap = map.entrySet()
                .stream()
                .sorted(Map.Entry.<Character, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new));

        int pushes = 0;
        int index = 0;

        for (Map.Entry<Character, Integer> entry : sortedMap.entrySet()) {
            pushes += (index / 8 + 1) * entry.getValue();
            index++;
        }

        return pushes;

    }

}
