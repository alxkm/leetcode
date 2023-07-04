package com.leetcode.top.tree;

import com.leetcode.TreeNode;

public class _226_Invert_Binary_Tree {
    //https://leetcode.com/problems/invert-binary-tree/

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        invert(root);
        return root;
    }

    public TreeNode invert(TreeNode t) {
        if (t == null) return null;

        var a = t.right;
        t.right = t.left;
        t.left = a;
        invert(t.left);
        invert(t.right);

        return t;
    }
}
