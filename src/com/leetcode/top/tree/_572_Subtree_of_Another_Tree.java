package com.leetcode.top.tree;

import com.leetcode.TreeNode;

public class _572_Subtree_of_Another_Tree {
    //https://leetcode.com/problems/subtree-of-another-tree/description/
    //572. Subtree of Another Tree

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;
        if (check(root, subRoot)) {
            return true;
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean check(TreeNode r, TreeNode s) {
        if (r == null && s == null) return true;
        if (r == null || s == null) return false;

        return check(r.left, s.left) && check(r.right, s.right);
    }
}
