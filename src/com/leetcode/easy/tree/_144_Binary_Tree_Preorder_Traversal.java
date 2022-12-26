package com.leetcode.easy.tree;

import java.util.ArrayList;
import java.util.List;

public class _144_Binary_Tree_Preorder_Traversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> a = new ArrayList<>();
        dfs(root, a);
        return a;
    }

    private void dfs(TreeNode root, List<Integer> a) {
        if (root == null) return;

        a.add(root.val);
        dfs(root.left, a);
        dfs(root.right, a);
    }
}
