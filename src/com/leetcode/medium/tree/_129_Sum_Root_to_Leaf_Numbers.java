package com.leetcode.medium.tree;

import com.leetcode.TreeNode;

public class _129_Sum_Root_to_Leaf_Numbers {
    //https://leetcode.com/problems/sum-root-to-leaf-numbers/
    //129. Sum Root to Leaf Numbers
    //TREE
    //TOP

    public int sumNumbers(TreeNode root) {
       return dfs(root, 0);
    }

    private int dfs(TreeNode t, int sum) {
        if (t == null) return 0;
        if (t.left == null && t.right == null) return t.val + sum * 10;
        return dfs(t.left, t.val + sum * 10) + dfs(t.right, t.val + sum * 10);
    }
}
