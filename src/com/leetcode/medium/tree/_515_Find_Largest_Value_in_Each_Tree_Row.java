package com.leetcode.medium.tree;

import com.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _515_Find_Largest_Value_in_Each_Tree_Row {
    //515. Find Largest Value in Each Tree Row
    //https://leetcode.com/problems/find-largest-value-in-each-tree-row/description/

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> l = new ArrayList<>();
        if (root == null) return l;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            int max = Integer.MIN_VALUE;
            while (size > 0) {
                size--;
                var t = q.poll();
                max = Math.max(max, t.val);
                if (t.left != null) q.add(t.left);
                if (t.right != null) q.add(t.right);
            }
            l.add(max);
        }
        return l;
    }

    public List<Integer> largestValues1(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> l = new ArrayList<>();
        if (root == null) return l;
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            int e = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode t = q.poll();
                e = Math.max(e, t.val);
                if (t.left != null) q.offer(t.left);
                if (t.right != null) q.offer(t.right);
            }
            l.add(e);
        }
        return l;
    }

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
    class Solution {
        public List<Integer> largestValues(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }

            List<Integer> res = new ArrayList<>();
            findLargestValues(root, 0, res);
            return res;
        }

        private void findLargestValues(TreeNode root, int level, List<Integer> largestValues) {
            if (root == null) {
                return;
            }

            if (level > largestValues.size() - 1) {
                largestValues.add(root.val);
            } else {
                int currMax = largestValues.get(level);
                int newMax = Math.max(currMax, root.val);
                largestValues.set(level, newMax);
            }

            findLargestValues(root.left, level + 1, largestValues);
            findLargestValues(root.right, level + 1, largestValues);
        }
    }
}
