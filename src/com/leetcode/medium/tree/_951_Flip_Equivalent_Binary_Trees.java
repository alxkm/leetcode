package com.leetcode.medium.tree;

import com.leetcode.TreeNode;

public class _951_Flip_Equivalent_Binary_Trees {
    //https://leetcode.com/problems/flip-equivalent-binary-trees/description/
    //951. Flip Equivalent Binary Trees

    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        return dfs(root1, root2);
    }

    private boolean dfs(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 != null) return false;
        if (t2 == null && t1 != null) return false;
        if (t1 == null && t2 == null) return true;

        if (t1.val != t2.val) return false;

        return (dfs(t1.left, t2.left) && dfs(t1.right, t2.right)) ||  (dfs(t1.left, t2.right) && dfs(t1.right, t2.left));
    }
}
