package com.leetcode.medium.tree;

import com.leetcode.TreeNode;

public class _235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree {
    //https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
    //235. Lowest Common Ancestor of a Binary Search Tree

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        var cur = root;
        while (cur != null) {
            if (p.val > cur.val && q.val > cur.val) {
                cur = cur.right;
            } else if (p.val < cur.val && q.val < cur.val) {
                cur = cur.left;
            } else {
                return cur;
            }
        }
        return null;
    }
}
