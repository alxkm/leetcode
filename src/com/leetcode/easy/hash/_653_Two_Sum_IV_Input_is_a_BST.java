package com.leetcode.easy.hash;

import com.leetcode.easy.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class _653_Two_Sum_IV_Input_is_a_BST {
    public boolean findTarget(TreeNode root, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        search(root, map);
        if (map.get(k) != null && map.get(0) != null) return true;
        if (k < 0 && map.get(k * -1) != null && map.get(0) != null) return true;

        for (var entry : map.entrySet()) {
            if (entry.getKey() == k - entry.getKey()) {
                if (entry.getValue() >= 2) {
                    return true;
                } else if (entry.getValue() == 1) {
                    continue;
                }
            }
            if (map.get(k - entry.getKey()) != null) return true;
        }
        return false;
    }

    private void search(TreeNode root, Map<Integer, Integer> map) {
        if (root != null) {
            map.put(root.val, map.getOrDefault(root.val, 0) + 1);
            search(root.left, map);
            search(root.right, map);
        }
    }
}
