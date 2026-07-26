package com.dsa.dailyDigest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class FindSafeWalk {

    public static void main(String[] args) {

        List<List<Integer>> grid = new ArrayList<>();
        grid.add(Arrays.asList(0, 1, 0, 0, 0));
        grid.add(Arrays.asList(0, 1, 0, 1, 0));
        grid.add(Arrays.asList(0, 0, 0, 1, 0));
        int health = 1;
        System.out.println(findSafeWalk(grid, health));

    }

    public static boolean findSafeWalk(List<List<Integer>> grid, int health) {

        int m = grid.size();
        int n = grid.get(0).size();

        int startHealth = health - grid.get(0).get(0);

        if (startHealth <= 0)
            return false;

        int[][] best = new int[m][n];
        for (int[] row : best)
            Arrays.fill(row, -1);

        PriorityQueue<Item> pq = new PriorityQueue<>((a, b) -> b.health - a.health);

        pq.offer(new Item(0, 0, startHealth));
        best[0][0] = startHealth;

        int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        while (!pq.isEmpty()) {

            Item cur = pq.poll();

            if (cur.r == m - 1 && cur.c == n - 1)
                return true;

            if (cur.health < best[cur.r][cur.c])
                continue;

            for (int[] d : dir) {

                int nr = cur.r + d[0];
                int nc = cur.c + d[1];

                if (nr < 0 || nr >= m || nc < 0 || nc >= n)
                    continue;

                int nextHealth = cur.health - grid.get(nr).get(nc);

                if (nextHealth <= 0)
                    continue;

                if (nextHealth > best[nr][nc]) {
                    best[nr][nc] = nextHealth;
                    pq.offer(new Item(nr, nc, nextHealth));
                }
            }
        }

        return false;

    }

}

class Item {

    int r;
    int c;
    int health;

    public Item(int r, int c, int health) {
        this.r = r;
        this.c = c;
        this.health = health;
    }

}
