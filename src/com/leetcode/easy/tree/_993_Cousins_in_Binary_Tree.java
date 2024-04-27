package com.leetcode.easy.tree;

import com.leetcode.TreeNode;

public class _993_Cousins_in_Binary_Tree {
    //993. Cousins in Binary Tree
    //https://leetcode.com/problems/cousins-in-binary-tree/description/

    int dx = Integer.MAX_VALUE;
    int dy = Integer.MIN_VALUE;
    TreeNode xp = null;
    TreeNode yp = null;

    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) return false;
        if (root.left == null || root.right == null) return false;

        dfs(root.left, root, x, y, 1);
        dfs(root.right, root, x, y, 1);

        if (yp != null)System.out.println(yp.val);
        if (xp != null)System.out.println(xp.val);
        return (xp != yp) && (dx == dy);
    }

    private void dfs(TreeNode t, TreeNode p, int x, int y, int d) {
        if (t == null) return;

        if (t.val == x) {
            xp = p;
            dx= d;
        }
        if (t.val == y) {
            yp = p;
            dy = d;
        }
        dfs(t.left, t, x, y, d + 1);
        dfs(t.right, t, x, y, d + 1);
    }
}
