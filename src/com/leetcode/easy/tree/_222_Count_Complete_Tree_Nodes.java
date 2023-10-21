package com.leetcode.easy.tree;

import com.leetcode.TreeNode;

public class _222_Count_Complete_Tree_Nodes {
    //https://leetcode.com/problems/count-complete-tree-nodes/
    //222. Count Complete Tree Nodes

    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
