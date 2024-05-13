package com.leetcode.medium.tree;

import com.leetcode.TreeNode;

public class _623_Add_One_Row_to_Tree {
    //623. Add One Row to Tree
    //https://leetcode.com/problems/add-one-row-to-tree/description/

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            return new TreeNode(val, root, null);
        }
        dfs(root, val, depth - 1);
        return root;
    }

    private boolean dfs(TreeNode t, int v, int d) {
        if (t == null) return false;
        if (d == 1) {
            TreeNode l = new TreeNode(v);
            TreeNode r = new TreeNode(v);
            l.left = t.left;
            r.right = t.right;
            t.left = l;
            t.right = r;
            return true;
        }
        return dfs(t.left, v, d - 1) | dfs(t.right, v, d - 1);
    }
}
