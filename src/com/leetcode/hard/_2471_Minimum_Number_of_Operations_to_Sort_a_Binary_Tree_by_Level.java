package com.leetcode.hard;

import com.leetcode.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class _2471_Minimum_Number_of_Operations_to_Sort_a_Binary_Tree_by_Level {
    //https://leetcode.com/problems/minimum-number-of-operations-to-sort-a-binary-tree-by-level/description/
    //2471. Minimum Number of Operations to Sort a Binary Tree by Level

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution {
        public int minimumOperations(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            int totalSwaps = 0;

            // Process tree level by level using BFS
            while (!queue.isEmpty()) {
                int levelSize = queue.size();
                int[] levelValues = new int[levelSize];

                // Store values of current level and add children to queue
                for (int i = 0; i < levelSize; i++) {
                    TreeNode node = queue.poll();
                    levelValues[i] = node.val;

                    if (node.left != null) queue.add(node.left);
                    if (node.right != null) queue.add(node.right);
                }

                // Add minimum swaps needed for current level
                totalSwaps += getMinSwaps(levelValues);
            }
            return totalSwaps;
        }

        // Calculate minimum swaps needed to sort an array
        private int getMinSwaps(int[] original) {
            int swaps = 0;
            int[] target = original.clone();
            Arrays.sort(target);

            // Map to track current positions of values
            Map<Integer, Integer> pos = new HashMap<>();
            for (int i = 0; i < original.length; i++) {
                pos.put(original[i], i);
            }

            // For each position, swap until correct value is placed
            for (int i = 0; i < original.length; i++) {
                if (original[i] != target[i]) {
                    swaps++;

                    // Update position of swapped values
                    int curPos = pos.get(target[i]);
                    pos.put(original[i], curPos);
                    original[curPos] = original[i];
                }
            }
            return swaps;
        }
    }
}
