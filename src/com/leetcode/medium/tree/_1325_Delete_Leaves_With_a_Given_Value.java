package com.leetcode.medium.tree;

import com.leetcode.TreeNode;

public class _1325_Delete_Leaves_With_a_Given_Value {
    //1325. Delete Leaves With a Given Value
    //https://leetcode.com/problems/delete-leaves-with-a-given-value/

    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root.val == target && root.left == null && root.right == null) return null;
        dfs(root.left, root, target, true);
        dfs(root.right, root, target, false);
        if (root.val == target && root.left == null && root.right == null) return null;
        return root;
    }

    public void dfs(TreeNode t, TreeNode p, int v, boolean isLeft) {
        if (t == null) return;
        dfs(t.left, t, v, true);
        dfs(t.right, t, v, false);

        if (t != null && t.val == v && t.left == null && t.right == null) {
            if (isLeft) p.left = null;
            else p.right = null;
        }
    }
}
