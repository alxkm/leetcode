package com.leetcode.top.tree;

public class _783_Minimum_Distance_Between_BST_Nodes {
    //https://leetcode.com/problems/minimum-distance-between-bst-nodes/
    //783. Minimum Distance Between BST Nodes

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

    private TreeNode prev;
    private Integer min = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
        if (root == null) return 0;
        dfs(root);
        return min;
    }

    private void dfs(TreeNode t) {
        if (t == null) return;
        dfs(t.left);
        if (prev != null) min = Math.min(min, Math.abs(prev.val - t.val));
        prev = t;
        dfs(t.right);
    }
}
