package com.leetcode.easy.tree;

import com.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class _94_Binary_Tree_Inorder_Traversal {
    //94. Binary Tree Inorder Traversal
    //https://leetcode.com/problems/binary-tree-inorder-traversal/

    public void inorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inorderTraversal(root.left, list);
        list.add(root.val);
        inorderTraversal(root.right, list);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorderTraversal(root, list);
        return list;
    }

    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> l = new ArrayList<>();
        dfs1(root, l);
        return l;
    }

    private void dfs1(TreeNode t, List<Integer> l) {
        if (t == null) return;

        dfs1(t.left, l);
        l.add(t.val);
        dfs1(t.right, l);
    }
}
