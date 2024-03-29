package com.leetcode.easy.tree;

import com.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class _257_Binary_Tree_Paths {
    //https://leetcode.com/problems/binary-tree-paths/
    //257. Binary Tree Paths
    //top
    //tree

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return null;
        List<String> list = new ArrayList<>();
        dfs(root, "", list);
        return list;
    }

    private void dfs(TreeNode t, String s, List<String> list) {
        if (t == null) return;
        if (t.left == null && t.right == null) {
            list.add(s + t.val);
            return;
        } else {
            dfs(t.left, s + t.val + "->", list);
            dfs(t.right, s + t.val + "->", list);
        }
    }
}
