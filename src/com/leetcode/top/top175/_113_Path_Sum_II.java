package com.leetcode.top.top175;

import com.leetcode.TreeNode;
import com.leetcode.TreeUtil;

import java.util.ArrayList;
import java.util.List;

public class _113_Path_Sum_II {
    //https://leetcode.com/problems/path-sum-ii/
    //FOREIGN_SOLUTION

    private int s = 0;
    private List<List<Integer>> ll = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        s = targetSum;
        dfs(root, 0, new ArrayList<>());
        return ll;
    }

    private void dfs(TreeNode t, int ps, List<Integer> l) {
        if (t == null) {
            if (ps == s) {
                ll.add(l);
            }
            return;
        }

        l.add(t.val);
        dfs(t.right, ps + t.val, l);
        dfs(t.left, ps + t.val, l);
        if (l.size() >= 1) {
            l.remove(l.size() - 1);
        }
    }

    class Solution1 {
        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            List<List<Integer>> ll = new ArrayList<>();
            if (root == null) return ll;
            dfs(root, targetSum, 0, new ArrayList<Integer>(), ll);
            return ll;
        }

        private void dfs(TreeNode t, int targetSum, int partialSum, List<Integer> l, List<List<Integer>> ll) {
            if (t == null) {
                return;
            }
            l.add(t.val);
            if (t.left == null && t.right == null && t.val + partialSum == targetSum) {
                ll.add(new ArrayList<>(l));
            }
            dfs(t.left, targetSum, partialSum + t.val, l, ll);
            dfs(t.right, targetSum, partialSum + t.val, l, ll);
            l.remove(l.size() - 1);
        }
    }

    public static void main(String[] args) {
        var solution = new _113_Path_Sum_II();
        Integer[] ar = new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1};
        TreeNode root = TreeUtil.formTree(ar);
        int target = 22;
        System.out.println(solution.pathSum(root, target));
    }
}
