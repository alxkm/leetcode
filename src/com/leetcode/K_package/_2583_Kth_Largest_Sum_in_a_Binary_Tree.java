package com.leetcode.K_package;

import com.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _2583_Kth_Largest_Sum_in_a_Binary_Tree {
    //https://leetcode.com/problems/kth-largest-sum-in-a-binary-tree/description/
    //2583. Kth Largest Sum in a Binary Tree

    Map<Integer, Long> map = new HashMap<>();

    public long kthLargestLevelSum(TreeNode root, int k) {
        dfs(root, 0);
        if (map.values().size() < k) return -1;
        List<Long> l = new ArrayList<>(map.values());
        Collections.sort(l);
        return l.get(l.size() - k);
    }

    private void dfs(TreeNode t, int i) {
        if (t == null) return;

        var val = map.get(i);
        if (val == null) map.put(i, (long)t.val);
        else map.put(i, (long)(t.val + val));

        dfs(t.right, i + 1);
        dfs(t.left, i + 1);
    }
}
