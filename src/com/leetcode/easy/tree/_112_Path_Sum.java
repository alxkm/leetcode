package com.leetcode.easy.tree;

import java.util.ArrayList;
import java.util.List;

public class _112_Path_Sum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null && targetSum == 0) return false;
        List<Integer> s = new ArrayList<>();
        dfs(root, targetSum, 0, s);
        return s.size() > 0;
    }

    private void dfs(TreeNode t, int ts, int cs, List<Integer> s) {
        if (t == null) return;

        if (t.left == null && t.right == null && cs + t.val == ts) {
            if (cs + t.val == ts) s.add(ts);
            return;
        }
        dfs(t.left, ts, cs + t.val, s);
        dfs(t.right, ts, cs + t.val, s);
    }

    public boolean hasPathSum1(TreeNode root, int targetSum) {
        if (root == null) return false;
        return find(root, targetSum, 0);
    }

    private boolean find(TreeNode t, int targetSum, int tempSum) {
        if (t == null) return false;
        if (t.val + tempSum == targetSum && t.left == null && t.right == null) return true;
        return find(t.left, targetSum, tempSum + t.val) || find(t.right, targetSum, tempSum + t.val);
    }
}
