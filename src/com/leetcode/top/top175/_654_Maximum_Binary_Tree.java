package com.leetcode.top.top175;

import com.leetcode.TreeNode;

import java.util.Stack;

public class _654_Maximum_Binary_Tree {
    //654. Maximum Binary Tree
    //https://leetcode.com/problems/maximum-binary-tree/
    //FOREIGN_SOLUTION
    //TOP

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        TreeNode root = new TreeNode();

        Stack<TreeNode> stack = new Stack<>();

        for (int n: nums) {
            TreeNode node = new TreeNode(n);
            while (!stack.isEmpty() && stack.peek().val < n) {
                node.left = stack.pop();
            }
            if (!stack.isEmpty() && stack.peek().val > n) {
                stack.peek().right = node;
            }
            stack.push(node);
        }
        return stack.get(0);
    }
}
