package com.leetcode.easy.tree;

import com.leetcode.TreeNode;

public class _110_Balanced_Binary_Tree {
    //https://leetcode.com/problems/balanced-binary-tree/

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        boolean l = isBalanced(root.left);
        boolean r = isBalanced(root.right);

        int a = gh(root.left);
        int b = gh(root.right);

        if (Math.abs(a - b) >= 2) return false;

        return l && r;
    }

    public int gh(TreeNode t) {
        if (t == null) return -1;
        return Math.max(gh(t.left), gh(t.right)) + 1;
    }
}
