package com.dsa.Trees.BST;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindTarget {

    static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) {

    }

    public boolean findTarget(TreeNode root, int k, Set<Integer> set) {

        if (root == null) {
            return false;
        }
        if (set.contains(k - root.val)) {
            return true;
        }
        set.add(root.val);

        return findTarget(root.left, k, set) || findTarget(root.right, k, set);

    }

}
