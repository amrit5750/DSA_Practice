package com.dsa.dailyDigest;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class GetResults {

    public static void main(String[] args) {

        int[][] queries = { { 1, 2 }, { 2, 3, 3 }, { 2, 3, 1 }, { 2, 2, 2 } };
        System.out.println(getResults(queries));

    }

    public static List<Boolean> getResults(int[][] queries) {

        int maxX = 0;
        for (int[] q : queries) {
            maxX = Math.max(maxX, q[1]);
        }

        SegmentTree seg = new SegmentTree(maxX + 2);

        TreeSet<Integer> obstacles = new TreeSet<>();

        obstacles.add(0);
        obstacles.add(maxX + 1);

        seg.update(maxX + 1, maxX + 1);

        List<Boolean> ans = new ArrayList<>();

        for (int[] q : queries) {

            if (q[0] == 1) {

                int x = q[1];

                Integer right = obstacles.ceiling(x);
                Integer left = obstacles.floor(x);

                if (obstacles.contains(x))
                    continue;

                obstacles.add(x);

                seg.update(x, x - left);
                seg.update(right, right - x);

            } else {

                int x = q[1];
                int sz = q[2];

                Integer prev = obstacles.floor(x);

                int bestGap = seg.query(0, prev);

                int tailGap = x - prev;

                ans.add(Math.max(bestGap, tailGap) >= sz);
            }
        }

        return ans;
    }

}

class SegmentTree {
    int[] tree;
    int n;

    SegmentTree(int n) {
        this.n = n;
        tree = new int[4 * n];
    }

    void update(int idx, int val) {
        update(1, 0, n - 1, idx, val);
    }

    private void update(int node, int l, int r, int idx, int val) {
        if (l == r) {
            tree[node] = val;
            return;
        }

        int mid = (l + r) / 2;

        if (idx <= mid)
            update(node * 2, l, mid, idx, val);
        else
            update(node * 2 + 1, mid + 1, r, idx, val);

        tree[node] = Math.max(tree[node * 2], tree[node * 2 + 1]);
    }

    int query(int ql, int qr) {
        return query(1, 0, n - 1, ql, qr);
    }

    private int query(int node, int l, int r, int ql, int qr) {
        if (ql > r || qr < l)
            return 0;

        if (ql <= l && r <= qr)
            return tree[node];

        int mid = (l + r) / 2;

        return Math.max(
                query(node * 2, l, mid, ql, qr),
                query(node * 2 + 1, mid + 1, r, ql, qr));
    }
}
