package com.dsa.dailyDigest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxProduct {

    public static void main(String[] args) {

        int n = 22;
        System.out.println(maxProduct(n));

    }

    public static int maxProduct(int n) {
        List<Integer> eleIntegers = new ArrayList<>();

        while (n != 0) {
            int rem = n % 10;
            eleIntegers.add(rem);
            n = n / 10;

        }
        int size = eleIntegers.size();
        Collections.sort(eleIntegers);
        return eleIntegers.get(size - 1) * eleIntegers.get(size - 2);

    }

}
