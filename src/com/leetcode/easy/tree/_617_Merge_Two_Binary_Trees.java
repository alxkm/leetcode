package com.leetcode.easy.tree;

import com.leetcode.TreeNode;

public class _617_Merge_Two_Binary_Trees {
    //https://leetcode.com/problems/merge-two-binary-trees/
    //617. Merge Two Binary Trees

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return null;

        TreeNode t = new TreeNode(0);
        if (t1 != null) t.val += t1.val;
        if (t2 != null) t.val += t2.val;

        t.left = mergeTrees(t1 != null ? t1.left : null, t2 != null ? t2.left : null);
        t.right = mergeTrees(t1 != null ? t1.right : null, t2 != null ? t2.right : null);

        return t;
    }
}
