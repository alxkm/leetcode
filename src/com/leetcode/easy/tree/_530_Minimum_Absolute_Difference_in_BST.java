package com.leetcode.easy.tree;

import com.leetcode.TreeNode;

public class _530_Minimum_Absolute_Difference_in_BST {
    //https://leetcode.com/problems/minimum-absolute-difference-in-bst/

    private int prev = Integer.MAX_VALUE;
    private int diff = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        return diff;
    }

    private void dfs(TreeNode t) {
        if (t == null) return;
        dfs(t.left);
        diff = Math.min(diff, Math.abs(t.val - prev));
        prev = t.val;
        dfs(t.right);
    }
}
