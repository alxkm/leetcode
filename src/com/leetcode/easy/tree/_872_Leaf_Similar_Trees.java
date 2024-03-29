package com.leetcode.easy.tree;

import com.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class _872_Leaf_Similar_Trees {
    //872. Leaf-Similar Trees
    //https://leetcode.com/problems/leaf-similar-trees/

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        dfs(root1, l1);
        dfs(root2, l2);
        return l1.equals(l2);
    }

    private void dfs(TreeNode t, List<Integer> l) {
        if (t == null) return;
        if (t.left == null && t.right == null) {
            l.add(t.val);
            return;
        }
        dfs(t.left, l);
        dfs(t.right, l);
    }
}
