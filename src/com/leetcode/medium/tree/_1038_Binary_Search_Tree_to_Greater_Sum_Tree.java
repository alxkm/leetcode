package com.leetcode.medium.tree;

import com.leetcode.TreeNode;

public class _1038_Binary_Search_Tree_to_Greater_Sum_Tree {
    //1038. Binary Search Tree to Greater Sum Tree
    //https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/
    //https://leetcode.com/problems/convert-bst-to-greater-tree/

    int sum = 0;
    public TreeNode bstToGst(TreeNode root) {
        dfs(root);
        return root;
    }

    void dfs(TreeNode t) {
        if (t == null) return;

        dfs(t.right);
        sum += t.val;
        t.val = sum;
        dfs(t.left);
    }
}
