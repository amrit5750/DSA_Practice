package com.dsa.contest.fourSeventyeight.foureightyNine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ToggleLightbulb {

    public static void main(String[] args) {

        List<Integer> bulbs = Arrays.asList(10, 30, 20, 10);

        List<Integer> onBulbs = toggleLightBulbs(bulbs);

        onBulbs.stream().forEach(bulb -> System.out.print(bulb + " "));

    }

    public static List<Integer> toggleLightBulbs(List<Integer> bulbs) {

        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> onBulbs = new ArrayList<>();

        for (Integer bulb : bulbs) {
            if (map.containsKey(bulb)) {
                map.remove(bulb);
            } else {
                map.put(bulb, bulb);
            }

        }
        onBulbs = new ArrayList<>(map.keySet());
        Collections.sort(onBulbs);
        return onBulbs;

    }

}
