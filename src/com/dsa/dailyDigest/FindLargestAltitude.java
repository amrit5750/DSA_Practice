package com.dsa.dailyDigest;

import java.util.ArrayList;
import java.util.List;

public class FindLargestAltitude {

    public static void main(String[] args) {

        int[] gain = { -4, -3, -2, -1, 4, 3, 2 };
        System.out.println(largestAltitude(gain));

    }

    public static int largestAltitude(int[] gain) {

        int maxGain = 0;
        int current = 0;
        List<Integer> ls = new ArrayList<>();
        ls.add(current);
        for (int i = 0; i < gain.length; i++) {
            current += gain[i];
            maxGain = Math.max(maxGain, current);
        }

        return maxGain;

    }

}
