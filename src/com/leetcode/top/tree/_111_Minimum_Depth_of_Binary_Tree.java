package com.leetcode.top.tree;

import com.leetcode.TreeNode;

public class _111_Minimum_Depth_of_Binary_Tree {
    //https://leetcode.com/problems/minimum-depth-of-binary-tree/
    //111. Minimum Depth of Binary Tree

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
