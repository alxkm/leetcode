package com.leetcode.medium.tree;

import com.leetcode.TreeNode;

public class _1123_Lowest_Common_Ancestor_of_Deepest_Leaves {
    //1123. Lowest Common Ancestor of Deepest Leaves
    //https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves/

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if (root == null) return null;
        int lh = height(root.left, 0);
        int rh = height(root.right, 0);
        if (lh == rh) return root;
        else if (lh > rh) return lcaDeepestLeaves(root.left);
        else return lcaDeepestLeaves(root.right);
    }

    private int height(TreeNode t, int d) {
        if (t == null) return d;
        return Math.max(height(t.left, d + 1), height(t.right, d + 1));
    }
}
