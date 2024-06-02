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
}
