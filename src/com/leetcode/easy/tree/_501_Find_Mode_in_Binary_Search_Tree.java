package com.leetcode.easy.tree;

import com.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _501_Find_Mode_in_Binary_Search_Tree {
    //501. Find Mode in Binary Search Tree
    //https://leetcode.com/problems/find-mode-in-binary-search-tree/

    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        dfs(root, map);
        for (var e: map.entrySet()) {
            max = Math.max(e.getValue(), max);
        }
        List<Integer> l = new ArrayList<>();
        for (var e: map.entrySet()) {
            if (max == e.getValue()) l.add(e.getKey());
        }
        int[] array = new int[l.size()];
        for (int i = 0; i < l.size(); i++) array[i] = l.get(i);

        return array;
    }

    private void dfs(TreeNode t, Map<Integer, Integer> map) {
        if (t == null) return;
        map.put(t.val, map.getOrDefault(t.val, 0) + 1);
        dfs(t.right, map);
        dfs(t.left, map);
    }
}
