package com.leetcode.medium.tree;

import com.leetcode.TreeNode;

public class _1302_Deepest_Leaves_Sum {
    //https://leetcode.com/problems/deepest-leaves-sum/
    //1302. Deepest Leaves Sum

    private int n = 0;
    private int sum = 0;

    private void findMaxLengthDfs(TreeNode t, int size) {
        if (t == null) {
            return;
        }
        if (t.left == null && t.right == null) {
            n = Math.max(size, n);
            return;
        }
        findMaxLengthDfs(t.right, size + 1);
        findMaxLengthDfs(t.left, size + 1);
    }

    private void sumDfs(TreeNode t, int size) {
        if (t == null) {
            return;
        }
        if (t.left == null && t.right == null && size == n) {
            sum += t.val;
            return;
        }
        sumDfs(t.right, size + 1);
        sumDfs(t.left, size + 1);
    }

    public int deepestLeavesSum(TreeNode root) {
        findMaxLengthDfs(root, 1);
        sumDfs(root, 1);
        return sum;
    }
}
