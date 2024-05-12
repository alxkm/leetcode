package com.leetcode.medium.tree;

import com.leetcode.TreeNode;

public class _865_Smallest_Subtree_with_all_the_Deepest_Nodes {
    //865. Smallest Subtree with all the Deepest Nodes
    //https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (root == null) return null;
        int lh = height(root.left, 0);
        int rh = height(root.right, 0);
        if (lh == rh) return root;
        else if (lh > rh) return subtreeWithAllDeepest(root.left);
        else return subtreeWithAllDeepest(root.right);
    }

    private int height(TreeNode t, int d) {
        if (t == null) return d;
        return Math.max(height(t.left, d + 1), height(t.right, d + 1));
    }
}
