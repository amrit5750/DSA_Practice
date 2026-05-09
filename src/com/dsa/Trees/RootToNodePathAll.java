package com.dsa.Trees;

import java.util.ArrayList;
import java.util.List;

public class RootToNodePathAll {

    public static void main(String[] args) {

    }

    public static List<List<Integer>> allRootToLeaf(TreeNode root) {

        List<List<Integer>> ls = new ArrayList<>();
        allRootToLeafHelper(root, ls, 5, new ArrayList<>());
        return ls;
    }

    public static void allRootToLeafHelper(TreeNode root, List<List<Integer>> ls, int x, List<Integer> current) {

        if (root == null) {
            return;
        }

        current.add(root.data);

        if (root.left == null && root.right == null) {
            ls.add(new ArrayList<>(current));
        } else {
            allRootToLeafHelper(root.left, ls, x, current);
            allRootToLeafHelper(root.right, ls, x, current);
        }
        current.remove(current.size() - 1);
    }

}

class TreeNode {

    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        data = val;
        left = null;
        right = null;
    }
}