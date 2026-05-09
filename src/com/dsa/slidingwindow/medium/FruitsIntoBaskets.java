package com.dsa.slidingwindow.medium;

import java.util.HashMap;
import java.util.Map;

//max lengthSubarray with K distinct Numbers.
public class FruitsIntoBaskets {

    public static void main(String[] args) {

        int[] fruits = { 1, 2, 1 };

        System.out.println(totalFruit(fruits, 2));

    }

    public static int totalFruit(int[] fruits, int k) {

        int count = 0;
        int left = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < fruits.length; i++) {
            map.put(fruits[i], map.getOrDefault(fruits[i], 0) + 1);

            if (map.size() > k) {
                map.put(fruits[left], map.get(fruits[left]) - 1);
                if (map.get(fruits[left]) <= 0) {
                    map.remove(fruits[left]);

                }
                left++;

            }

            count = Math.max(count, i - left + 1);
        }

        return count;

    }

}
