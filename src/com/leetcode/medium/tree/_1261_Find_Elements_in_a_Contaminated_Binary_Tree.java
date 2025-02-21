package com.leetcode.medium.tree;

import com.leetcode.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class _1261_Find_Elements_in_a_Contaminated_Binary_Tree {
    //1261. Find Elements in a Contaminated Binary Tree
    //https://leetcode.com/problems/find-elements-in-a-contaminated-binary-tree/description/

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class FindElements {
        Set<Integer> set = new HashSet<>();

        public FindElements(TreeNode root) {
            root.val = 0;
            set.add(root.val);
            dfs(root);
        }

        public boolean find(int target) {
            return set.contains(target);
        }

        private void dfs(TreeNode treeNode) {
            if (treeNode == null) {
                return;
            }
            int x = treeNode.val;
            if (treeNode.left != null) {
                treeNode.left.val = 2 * x + 1;
                set.add(treeNode.left.val);
                dfs(treeNode.left);
            }
            if (treeNode.right != null) {
                treeNode.right.val = 2 * x + 2;
                set.add(treeNode.right.val);
                dfs(treeNode.right);
            }
        }
    }

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */
}
