package com.company.tree;

public class _938_Range_Sum_of_BST {
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
