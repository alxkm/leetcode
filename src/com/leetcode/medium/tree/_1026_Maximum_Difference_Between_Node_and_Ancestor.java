package com.leetcode.medium.tree;

import com.leetcode.TreeNode;

public class _1026_Maximum_Difference_Between_Node_and_Ancestor {
    //1026. Maximum Difference Between Node and Ancestor
    //https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/description/

    public int maxAncestorDiff(TreeNode root) {
        return Math.max(dfs(root.left, root.val, root.val), dfs(root.right, root.val, root.val));
    }

    private int dfs(TreeNode t, int min, int max) {
        if (t == null) return max - min;
        min = Math.min(min, t.val);
        max = Math.max(max, t.val);

        return Math.max(dfs(t.left, min, max), dfs(t.right, min, max));
    }

    public int maxAncestorDiff1(TreeNode root) {
        return Math.max(dfs1(root.left, root.val, root.val), dfs1(root.right, root.val, root.val));
    }

    private int dfs1(TreeNode t, int max, int min) {
        if (t == null) return Integer.MIN_VALUE;

        var v = Math.max(Math.abs(max - t.val), Math.abs(min - t.val));

        var lm = dfs1(t.left, Math.max(max, t.val), Math.min(min, t.val));
        var rm = dfs1(t.right, Math.max(max, t.val), Math.min(min, t.val));

        return Math.max(Math.max(v, lm), rm);
    }
}
