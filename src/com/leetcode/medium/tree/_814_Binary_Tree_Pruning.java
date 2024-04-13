package com.leetcode.medium.tree;

import com.leetcode.TreeNode;

public class _814_Binary_Tree_Pruning {
    //https://leetcode.com/problems/binary-tree-pruning/
    //814. Binary Tree Pruning

    public TreeNode pruneTree(TreeNode root) {
        if (root == null) return null;
        dfs(root);
        if (root.val == 0 && root.left == null && root.right == null) return null;
        return root;
    }

    private boolean compare(TreeNode t) {
        if (t == null) return false;
        if (t.val == 0 && t.left == null && t.right == null) return true;
        return compare(t.left) && compare(t.right);
    }

    private void dfs(TreeNode t) {
        if (t == null) return;

        dfs(t.left);
        if (compare(t.left)) {
            t.left = null;
        }
        dfs(t.right);
        if (compare(t.right)) {
            t.right = null;
        }
    }
}
