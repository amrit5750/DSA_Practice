package com.dsa.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.TreeMap;

public class TreeTopView {

    public static void main(String[] args) {

    }

    public static List<Integer> topView(TreeNode node) {

        List<Integer> ls = new ArrayList<>();
        if (node == null) {
            return ls;
        }
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(node, 0));

        while (!q.isEmpty()) {
            Pair it = q.poll();
            TreeNode root = it.key;
            int val = it.val;

            if (!map.containsKey(val)) {
                map.put(val, root.val);
            }

            if (root.left != null) {
                q.add(new Pair(root.left, val - 1));
            }
            if (root.right != null) {
                q.add(new Pair(root.right, val + 1));
            }

        }

        for (Entry<Integer, Integer> entry : map.entrySet()) {
            ls.add(entry.getValue());
        }
        return ls;
    }

}

class Pair {
    TreeNode key;
    int val;

    public Pair(TreeNode key, int val) {
        this.key = key;
        this.val = val;
    }
}
