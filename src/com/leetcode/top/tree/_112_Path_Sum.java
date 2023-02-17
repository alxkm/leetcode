package com.leetcode.top.tree;

public class _112_Path_Sum {
    //https://leetcode.com/problems/path-sum/
    //112. Path Sum

    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode() {}
        public TreeNode(int val) { this.val = val; }
        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        // if (root == null) return false;
        // return  dfs(root, targetSum, 0);
        if (root == null) return false;
        return find(root, targetSum, 0);
    }

    private boolean find(TreeNode t, int targetSum, int tempSum) {
        if (t == null) return false;
        if (t.val + tempSum == targetSum && t.left == null && t.right == null) return true;
        return find(t.left, targetSum, tempSum + t.val) || find(t.right, targetSum, tempSum + t.val);
    }

    private boolean dfs(TreeNode t, int ts, int cs) {
        if (t == null) return false;
        if (t.val + cs == ts && t.right == null && t.left == null) return true;
        return dfs(t.left, ts, cs + t.val) || dfs(t.right, ts, cs + t.val);
    }
}
