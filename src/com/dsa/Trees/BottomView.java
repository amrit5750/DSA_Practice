package com.dsa.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class BottomView {

    public static void main(String[] args) {

    }

    public static List<Integer> getBottomView(TreeNode root) {

        List<Integer> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair current = q.poll();
            TreeNode node = current.key;
            int line = current.val;

            map.put(line, node.val);

            if (node.left != null) {
                q.add(new Pair(node.left, line - 1));

            }
            if (node.right != null) {
                q.add(new Pair(node.right, line + 1));
            }

        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            ans.add(entry.getValue());
        }

        return ans;

    }

}

class Pair {

    TreeNode key;
    int val;

    Pair(TreeNode key, int val) {
        this.key = key;
        this.val = val;
    }
}
