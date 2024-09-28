package com.leetcode.medium.tree;

import com.leetcode.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _2196_Create_Binary_Tree_From_Descriptions {
    //2196. Create Binary Tree From Descriptions
    //https://leetcode.com/problems/create-binary-tree-from-descriptions/description/

    public TreeNode createBinaryTree(int[][] descriptions) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> childrenSet = new HashSet<>();
        //Map<Integer, List<[]int>> map = new HashMap<>();
        for (int[] ar: descriptions) {
            set.add(ar[0]);
            set.add(ar[1]);
            childrenSet.add(ar[1]);
            //map.computeIfAbsent(ar[0], k -> new ArrayList<>()).add(ar);
        }
        set.removeAll(childrenSet);
        Map<Integer, TreeNode> tm = new HashMap<>();

        for (int[] ar: descriptions) {
            var t = tm.computeIfAbsent(ar[0], k -> new TreeNode(ar[0]));
            var newNode = tm.computeIfAbsent(ar[1], k -> new TreeNode(ar[1]));
            if (ar[2] == 1) {
                t.left = newNode;
            } else {
                t.right = newNode;
            }
        }
        return tm.get(set.iterator().next());
    }
}
