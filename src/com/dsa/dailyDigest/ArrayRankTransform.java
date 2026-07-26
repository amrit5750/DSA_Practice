package com.dsa.dailyDigest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArrayRankTransform {

    public static void main(String[] args) {

        int[] arr = { 40, 10, 20, 30 };
        System.out.println(Arrays.toString(arrayRankTransform(arr)));

    }

    public static int[] arrayRankTransform(int[] arr) {

        int[] arrCopy = arr.clone();
        Arrays.sort(arrCopy);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arrCopy.length; i++) {
            if (!map.containsKey(arrCopy[i])) {
                map.put(arrCopy[i], map.size() + 1);
            }
        }

        int[] ans = new int[arr.length];

        for (int i = 0; i < ans.length; i++) {
            ans[i] = map.get(arr[i]);

        }

        return ans;

    }

}
