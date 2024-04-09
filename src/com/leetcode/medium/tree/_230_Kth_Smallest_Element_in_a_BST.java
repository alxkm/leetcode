package com.leetcode.medium.tree;

import com.leetcode.TreeNode;

public class _230_Kth_Smallest_Element_in_a_BST {
    //https://leetcode.com/problems/kth-smallest-element-in-a-bst/
    //230. Kth Smallest Element in a BST

    public int kthSmallest(TreeNode root, int k) {
        int[] counter = new int[1];
        int[] value = new int[1];
        inOrder(root, k, counter, value);
        return value[0];
    }

    private void inOrder(TreeNode t, int k, int[] counter, int[] value) {
        if (t == null) return;
        inOrder(t.left, k, counter, value);
        ++counter[0];
        if (counter[0] == k) {
            value[0] = t.val;
            return;
        }
        inOrder(t.right, k, counter, value);
    }
}
