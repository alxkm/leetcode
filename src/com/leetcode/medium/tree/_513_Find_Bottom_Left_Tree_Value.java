package com.leetcode.medium.tree;

import com.leetcode.TreeNode;

public class _513_Find_Bottom_Left_Tree_Value {
    //https://leetcode.com/problems/find-bottom-left-tree-value/
    //513. Find Bottom Left Tree Value

    TreeNode t;
    int max;

    public int findBottomLeftValue(TreeNode root) {
        max = deep(root, 0);
        dfs(root, 0);
        return t.val;
    }

    void dfs(TreeNode t, int d) {
        if (t != null && d == max) {
            this.t = t;
            return;
        }
        if (t == null) return;
        if (this.t == null) dfs(t.left, d + 1);
        if (this.t == null) dfs(t.right, d + 1);
    }

    int deep(TreeNode t, int d) {
        if (t == null) return d - 1;
        return Math.max(deep(t.left, d + 1), deep(t.right, d + 1));
    }
}
