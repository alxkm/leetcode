package com.leetcode.easy.tree;

import com.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class _145_Binary_Tree_Postorder_Traversal {
    //https://leetcode.com/problems/binary-tree-postorder-traversal/description/
    //145. Binary Tree Postorder Traversal

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postorderTraversal(root, list);
        return list;
    }

    public void postorderTraversal(TreeNode root, List<Integer> list) {
        if (root != null) {
            postorderTraversal(root.left, list);
            postorderTraversal(root.right, list);
            list.add(root.val);
        }
    }

    class Solution {
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> l = new ArrayList<>();
            dfs(root, l);
            return l;
        }

        private void dfs(TreeNode t, List<Integer> l) {
            if (t == null) return;
            dfs(t.left, l);
            dfs(t.right, l);
            l.add(t.val);
        }
    }
}
