package com.leetcode.medium.tree;

import com.leetcode.TreeNode;

public class _1325_Delete_Leaves_With_a_Given_Value1 {
    //1325. Delete Leaves With a Given Value
    //https://leetcode.com/problems/delete-leaves-with-a-given-value/description/

    public TreeNode removeLeafNodes(TreeNode root, int target) {
        return dfs(root, target);
    }

    TreeNode dfs(TreeNode t, int target) {
        if (t != null && t.right == null && t.left == null) {
            if (t.val == target) return null;
            else return t;
        }
        if (t == null) return null;

        t.left = dfs(t.left, target);
        t.right = dfs(t.right, target);

        if (t.right == null && t.left == null && t.val == target) return null;
        return t;
    }
}
