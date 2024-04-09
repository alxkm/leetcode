package com.leetcode.medium.tree;

import com.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _102_Binary_Tree_Level_Order_Traversal {
    //https://leetcode.com/problems/binary-tree-level-order-traversal/
    //102. Binary Tree Level Order Traversal

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> nodes = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            Queue<TreeNode> newQueue = new LinkedList<>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.remove();
                list.add(node.val);
                if (node.left != null) {
                    newQueue.add(node.left);
                }
                if (node.right != null) {
                    newQueue.add(node.right);
                }
            }
            queue = newQueue;
            nodes.add(list);
        }
        return nodes;
    }
}
