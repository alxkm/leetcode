package com.leetcode.easy.tree;

import com.leetcode.TreeNode;

public class _104_Maximum_Depth_of_Binary_Tree {
    //104. Maximum Depth of Binary Tree
    //https://leetcode.com/problems/maximum-depth-of-binary-tree/

    static public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        return (l > r) ? l + 1 : r + 1;
    }

    public int maxDepth1(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth1(root.left), maxDepth1(root.right)) + 1;
    }


    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);
        p.left.left = null;
        p.left.right = null;
        p.right.left = new TreeNode(4);
        p.right.right = new TreeNode(5);
        System.out.println(maxDepth(p));
    }
}
