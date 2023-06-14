package com.leetcode.top.tree;

import com.leetcode.TreeNode;

public class _783_Minimum_Distance_Between_BST_Nodes {
    //783. Minimum Distance Between BST Nodes
    //https://leetcode.com/problems/minimum-distance-between-bst-nodes/

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
