package com.leetcode.top.tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _671_Second_Minimum_Node_In_a_Binary_Tree {
    //https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/
    //671. Second Minimum Node In a Binary Tree

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int findSecondMinimumValue(TreeNode root) {
        Set<Integer> set = new HashSet<>();
        if (root == null) return -1;
        dfs(root, set);
        if (set.size() == 1) return -1;
        List<Integer> l = new ArrayList<>(set);
        int min = l.get(0);
        int max = l.get(0);
        for (int i: l) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        if (set.size() == 2) return max;
        int min1 = max;
        for (int i: l) {
            if (i != min) {
                min1 = Math.min(min1, i);
            }
        }
        return min1;
    }

    private void dfs(TreeNode root, Set<Integer> set) {
        if (root == null) return;

        set.add(root.val);
        dfs(root.right, set);
        dfs(root.left, set);
    }
}
