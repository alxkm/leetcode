package com.leetcode.medium.tree;

import com.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class _1530_Number_of_Good_Leaf_Nodes_Pairs {
    //1530. Number of Good Leaf Nodes Pairs
    //https://leetcode.com/problems/number-of-good-leaf-nodes-pairs/description/

    public int countPairs(TreeNode root, int distance) {
        Map<TreeNode, List<TreeNode>> map = new HashMap<>();
        Set<TreeNode> leafs = new HashSet<>();
        dfsFormGraph(root, null, map, leafs);
        int ans = 0;

        for (var leaf: leafs) {
            int d = 0;
            Queue<TreeNode> q = new LinkedList<>();
            Set<TreeNode> visit = new HashSet<>();
            q.add(leaf);
            visit.add(leaf);

            for (int i = 0; i <= distance; i++) {
                int size = q.size();

                for (int j = 0; j < size; j++) {
                    TreeNode currNode = q.poll();
                    if (leafs.contains(currNode) && currNode != leaf) ans++;

                    if (map.containsKey(currNode)) {
                        for (TreeNode neighbor: map.get(currNode)) {
                            if (!visit.contains(neighbor)) q.add(neighbor);
                            visit.add(neighbor);
                        }
                    }
                }
            }
        }
        return ans / 2;
    }

    private void dfsFormGraph(TreeNode t, TreeNode p, Map<TreeNode, List<TreeNode>> map, Set<TreeNode> leafs) {
        if (t == null) return;
        if (t.right == null && t.left == null) leafs.add(t);

        if (p != null) {
            map.computeIfAbsent(p, k -> new ArrayList<TreeNode>()).add(t);
            map.computeIfAbsent(t, k -> new ArrayList<TreeNode>()).add(p);
        }
        dfsFormGraph(t.left, t, map, leafs);
        dfsFormGraph(t.right, t, map, leafs);
    }
}
