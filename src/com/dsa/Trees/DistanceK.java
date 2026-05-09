package com.dsa.Trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class DistanceK {

    public static void main(String[] args) {

    }

    public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        getParents(root, parentMap);
        Map<TreeNode, Boolean> visted = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();

        visted.put(target, true);
        queue.offer(target);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (level == k) {
                break;
            }
            level++;
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();
                if (currentNode.left != null && visted.get(currentNode.left) == null) {
                    queue.offer(currentNode.left);
                    visted.put(currentNode.left, true);
                }
                if (currentNode.right != null && visted.get(currentNode.right) == null) {
                    queue.offer(currentNode.right);
                    visted.put(currentNode.right, true);
                }

                if (parentMap.get(currentNode) != null && visted.get(parentMap.get(currentNode)) == null) {
                    queue.offer(parentMap.get(currentNode));
                    visted.put(parentMap.get(currentNode), true);
                }

            }

        }

        List<Integer> ls = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode cuTreeNode = queue.poll();
            ls.add(cuTreeNode.val);

        }

        return ls;

    }

    public static void getParents(TreeNode node, Map<TreeNode, TreeNode> parentMap) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            TreeNode currNode = queue.poll();

            if (currNode.left != null) {
                parentMap.put(currNode.left, currNode);
                queue.offer(currNode.left);
            }
            if (currNode.right != null) {
                parentMap.put(currNode.right, currNode);
                queue.offer(currNode.right);
            }

        }

    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
