package com.leetcode.easy.tree;

public class _2236_Root_Equals_Sum_of_Children {
    public boolean checkTree(TreeNode root) {
        return root.val == (root.left.val + root.right.val);
    }
}
