package com.leetcode.easy.tree;

import java.util.ArrayList;
import java.util.List;

public class _897_Increasing_Order_Search_Tree {
    public TreeNode increasingBST(TreeNode root) {
        List<TreeNode> l = new ArrayList<>();
        dfs(root, l);

        for (TreeNode treeNode : l) {
            treeNode.left = null;
            treeNode.right = null;
        }

        TreeNode t = l.get(0);
        for (int i = 1; i < l.size(); i++) {
            t.right = l.get(i);
            t = l.get(i);
        }
        return l.get(0);
    }

    private void dfs(TreeNode root, List<TreeNode> l) {
        if (root == null) return;

        dfs(root.left, l);
        l.add(root);
        dfs(root.right, l);
    }
}
