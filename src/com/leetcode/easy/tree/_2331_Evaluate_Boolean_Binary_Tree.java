package com.leetcode.easy.tree;

import com.leetcode.TreeNode;
import com.leetcode.TreeUtil;

public class _2331_Evaluate_Boolean_Binary_Tree {
    //https://leetcode.com/problems/evaluate-boolean-binary-tree/
    //2331. Evaluate Boolean Binary Tree

    public boolean evaluateTree(TreeNode root) {
        return dfs(root);
    }

    private boolean dfs(TreeNode t) {
        if (t.val == 0 || t.val == 1) return t.val == 1 ? true : false;
        if (t.val == 2) return dfs(t.left) || dfs(t.right);
        return dfs(t.left) && dfs(t.right);
    }

    public static void main(String[] args) {
        var sol = new _2331_Evaluate_Boolean_Binary_Tree();
        Integer[] integers = {2, 1, 3, null, null, 0, 1};
        System.out.println(sol.evaluateTree(TreeUtil.formTree(integers)));
    }
}
