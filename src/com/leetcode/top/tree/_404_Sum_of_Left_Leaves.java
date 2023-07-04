package com.leetcode.top.tree;

import com.leetcode.TreeNode;

public class _404_Sum_of_Left_Leaves {
    //https://leetcode.com/problems/sum-of-left-leaves/

    public int sumOfLeftLeaves(TreeNode root) {
        return dfs(root.left, true) + dfs(root.right, false);
    }

    private int dfs(TreeNode t, boolean left) {
        if (t == null) return 0;
        if (left && t.left == null && t.right == null) return t.val;
        return dfs(t.left, true) + dfs(t.right, false);
    }
}
