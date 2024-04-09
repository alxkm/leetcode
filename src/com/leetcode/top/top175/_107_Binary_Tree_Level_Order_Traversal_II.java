package com.leetcode.top.top175;

import com.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _107_Binary_Tree_Level_Order_Traversal_II {
    //https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
    //107. Binary Tree Level Order Traversal II
    //FOREIGN_SOLUTION

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> ll = new LinkedList<>();
        dfs(root, 1, ll);
        // Queue<TreeNode> q = new LinkedList<>();
        // q.add(root);

        // while (!q.isEmpty()) {
        //     int n = q.size();
        //     List<Integer> l = new LinkedList<>();
        //     for (int i = 0; i < n; i++) {
        //         TreeNode t = q.remove();
        //         if (t.left != null) q.add(t.left);
        //         if (t.right != null) q.add(t.right);
        //         l.add(t.val);
        //     }
        //     ll.add(l);
        // }

        // for (int i = 0; i < ll.size() / 2; i++) {
        //     var l = ll.get(i);
        //     ll.set(i, ll.get(ll.size() - i - 1));
        //     ll.set(ll.size() - i - 1, l);
        // }

        return ll;
    }

    private void dfs(TreeNode t, int level, List<List<Integer>> ll) {
        if (t == null) return;
        if (ll.size() < level) ll.add(0, new ArrayList<>());
        dfs(t.left, level + 1, ll);
        dfs(t.right, level + 1, ll);
        ll.get(ll.size() - level).add(t.val);
    }
}
