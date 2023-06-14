package com.leetcode.top.tree;

import com.leetcode.TreeNode;

public class _543_Diameter_of_Binary_Tree {
    //https://leetcode.com/problems/diameter-of-binary-tree/
    //543. Diameter of Binary Tree

    int d = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return d;
    }

    private int dfs(TreeNode t) {
        if (t == null) return 0;
        int a = dfs(t.left);
        int b = dfs(t.right);
        d = Math.max(d, a + b);
        return Math.max(a, b) + 1;
    }
}
