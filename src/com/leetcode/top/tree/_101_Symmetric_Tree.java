package com.leetcode.top.tree;

import com.leetcode.TreeNode;

public class _101_Symmetric_Tree {
    //101. Symmetric Tree
    //https://leetcode.com/problems/symmetric-tree/

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return false;
        return check(root.left, root.right);
    }

    private boolean check(TreeNode l, TreeNode r) {
        if (l == null && r == null) return true;
        if (l == null || r == null) return false;
        if (l.val != r.val) return false;
        return check(l.left, r.right) && check(l.right, r.left);
    }
}
