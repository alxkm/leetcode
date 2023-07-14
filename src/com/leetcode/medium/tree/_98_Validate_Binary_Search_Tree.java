package com.leetcode.medium.tree;

import com.leetcode.TreeNode;

public class _98_Validate_Binary_Search_Tree {
    //https://leetcode.com/problems/validate-binary-search-tree/

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return is(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean is(TreeNode t, long min, long max) {
        if (t == null) return true;
        if (t.val <= min || t.val >= max) return false;
        boolean left = is(t.left, min, t.val);
        boolean right = is(t.right, t.val, max);
        return left && right;
    }
}
