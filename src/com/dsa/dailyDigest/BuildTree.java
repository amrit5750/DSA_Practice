package com.dsa.dailyDigest;

import java.util.HashMap;
import java.util.Map;

public class BuildTree {

    public static void main(String[] args) {

        int[] preorder = { 3, 9, 20, 15, 7 };
        int[] inorder = { 9, 3, 15, 20, 7 };
        System.out.println(buildTree(preorder, inorder));

    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);

        }

        return buildTreeHelper(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1, map);

    }

    public static TreeNode buildTreeHelper(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart,
            int inEnd, Map<Integer, Integer> map) {

        if (preStart > preEnd || inStart > inEnd)
            return null;

        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);

        int inRoot = map.get(rootVal);
        int numsLeft = inRoot - inStart;

        root.left = buildTreeHelper(preorder, inorder, preStart + 1, preStart + numsLeft, inStart, inRoot - 1, map);
        root.right = buildTreeHelper(preorder, inorder,
                preStart + numsLeft + 1,
                preEnd,
                inRoot + 1,
                inEnd,
                map);

        return root;

    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
