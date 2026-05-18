package com.dsa.Trees.BST;

public class BstFromPreorder {

    int index = 0;

    public static void main(String[] args) {

    }

    public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorderHelper(preorder, Integer.MAX_VALUE);

    }

    public TreeNode bstFromPreorderHelper(int[] preorder, int bound) {

        if (index == preorder.length || preorder[index] > bound) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[index++]);
        node.left = bstFromPreorderHelper(preorder, node.val);
        node.right = bstFromPreorderHelper(preorder, bound);
        return node;
    }

}
