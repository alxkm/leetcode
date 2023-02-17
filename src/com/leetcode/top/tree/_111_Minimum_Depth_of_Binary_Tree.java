package com.leetcode.top.tree;

public class _111_Minimum_Depth_of_Binary_Tree {
    //https://leetcode.com/problems/minimum-depth-of-binary-tree/
    //111. Minimum Depth of Binary Tree

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        return calc(root);
    }

    public int calc(TreeNode t) {
        if (t == null) return 0;
        if (t.left == null && t.right == null) return 1;

        int a = calc(t.left);
        int b = calc(t.right);
        return a == 0 || b == 0 ? 1 + a + b : 1 + Math.min(a, b);
    }
}
