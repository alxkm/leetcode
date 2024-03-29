package com.leetcode.easy.tree;

import com.leetcode.TreeNode;

public class _606_Construct_String_from_Binary_Tree_ {
    //https://leetcode.com/problems/construct-string-from-binary-tree/
    //606. Construct String from Binary Tree

    public String tree2str(TreeNode root) {
        if (root == null) return "";
        String s = Integer.valueOf(root.val).toString();

        if (root.left == null && root.right == null) return s;

        s += "(" + tree2str(root.left) + ")";
        if (root.right != null) {
            s += "(" + tree2str(root.right) + ")";
        }

        return s;
    }
}
