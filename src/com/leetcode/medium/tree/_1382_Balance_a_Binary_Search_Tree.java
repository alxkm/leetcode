package com.leetcode.medium.tree;

import com.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class _1382_Balance_a_Binary_Search_Tree {
    //https://leetcode.com/problems/balance-a-binary-search-tree/
    //1382. Balance a Binary Search Tree

    public TreeNode balanceBST(TreeNode root) {
        List<Integer> l = new ArrayList<>();
        dfs(root, l);
        return create(l, 0, l.size() - 1);
    }

    private TreeNode create(List<Integer> l, int start, int end) {
        if (start > end) {
            return null;
        }

        int m = (start + (end - start) / 2);
        TreeNode t = new TreeNode(l.get(m));

        t.left = create(l, start, m - 1);
        t.right = create(l, m + 1, end);

        return t;
    }

    private void dfs(TreeNode t, List<Integer> l) {
        if (t == null) return;
        dfs(t.left, l);
        l.add(t.val);
        dfs(t.right, l);
    }
}
