package com.leetcode.medium.tree;

import com.leetcode.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class _1161_Maximum_Level_Sum_of_a_Binary_Tree {
    //1161. Maximum Level Sum of a Binary Tree
    //https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/description/

    public int maxLevelSum(TreeNode root) {
        Deque<TreeNode> dq = new LinkedList<>();
        dq.add(root);
        int prevLevel = 0;
        int prevSum = Integer.MIN_VALUE;
        int level = 0;
        while (!dq.isEmpty()) {
            int size = dq.size();
            int sum = 0;
            level++;
            for (int i = 0; i < size; i++) {
                TreeNode t = dq.pollFirst();
                if (t.right != null) dq.offer(t.right);
                if (t.left != null) dq.offer(t.left);
                sum += t.val;
            }

            if (sum > prevSum) {
                prevSum = sum;
                prevLevel = level;
            }
        }
        return prevLevel;
    }
}
