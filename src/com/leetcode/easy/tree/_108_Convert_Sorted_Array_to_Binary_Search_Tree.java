package com.leetcode.easy.tree;

import com.leetcode.TreeNode;

public class _108_Convert_Sorted_Array_to_Binary_Search_Tree {
    //https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return construct(0, nums.length - 1, nums);
    }

    private TreeNode construct(int l, int r, int[] nums) {
        if (l > r) return null;
        int m = (l + r) / 2;
        TreeNode t = new TreeNode(nums[m]);
        t.left = construct(l, m - 1, nums);
        t.right = construct(m + 1, r, nums);
        return t;
    }
}
