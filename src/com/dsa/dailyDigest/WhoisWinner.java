package com.dsa.dailyDigest;

import java.util.ArrayList;
import java.util.List;

public class WhoisWinner {
    public static void main(String[] args) {
        System.out.println(findTheWinner(5, 2));

    }

    public static int findTheWinner(int n, int k) {
        List<Integer> ls = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            ls.add(i);

        }
        int i = 0;
        while (ls.size() > 1) {
            i = (i + k - 1) % ls.size();
            ls.remove(i);

        }
        return ls.get(0);

    }

}
