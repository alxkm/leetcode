package com.leetcode.medium.tree;

import java.util.ArrayList;
import java.util.List;


public class _173_Binary_Search_Tree_Iterator {
    //https://leetcode.com/problems/binary-search-tree-iterator/

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public class BSTIterator {
        private List<Integer> l = new ArrayList<>();
        private int i = 0;

        public BSTIterator(TreeNode root) {
            dfs(root);
        }

        public int next() {
            return l.get(i++);
        }

        public boolean hasNext() {
            return l.size() > i;
        }

        private void dfs(TreeNode t) {
            if (t == null) return;
            dfs(t.left);
            l.add(t.val);
            dfs(t.right);
        }
    }
}
