package com.leetcode.top.tree;

public class _101_Symmetric_Tree {
    //https://leetcode.com/problems/symmetric-tree/
    //101. Symmetric Tree

    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode() {}
        public TreeNode(int val) { this.val = val; }
        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

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
