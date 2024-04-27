package com.leetcode.easy.tree;

import com.leetcode.TreeNode;

public class _938_Range_Sum_of_BST {
    //938. Range Sum of BST
    //https://leetcode.com/problems/range-sum-of-bst/description/

    public int rangeSumBST(TreeNode root, int low, int high) {
        return inorder(root, low, high);
    }

    int inorder(TreeNode root, int low, int high) {
        if (root != null) {
            int a = 0;
            if (root.val >= low && root.val <= high) {
                a = root.val;
            }
            return a + inorder(root.left, low, high) + inorder(root.right, low, high);
        }
        return 0;
    }
}
