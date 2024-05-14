package com.leetcode.medium.tree;

import com.leetcode.TreeNode;

public class _1448_Count_Good_Nodes_in_Binary_Tree {
    //1448. Count Good Nodes in Binary Tree
    //https://leetcode.com/problems/count-good-nodes-in-binary-tree/

    public int goodNodes(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE);
    }

    private int dfs(TreeNode t, int max) {
        if (t == null) return 0;
        int result = 0;
        if (t.val >= max) result = 1;
        return result + dfs(t.right, Math.max(max, t.val)) + dfs(t.left, Math.max(max, t.val));
    }
}
