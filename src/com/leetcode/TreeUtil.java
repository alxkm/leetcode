package com.leetcode;

public class TreeUtil {
    public static TreeNode formTree(Integer[] data) {
        TreeNode root = new TreeNode(data[0]);
        form(root, 0, data);
        return root;
    }

    private static void form(TreeNode root, int rootIndex, Integer[] data) {
        int n = data.length;

        int leftIndex = 2 * rootIndex + 1;
        if (leftIndex < n && null != data[leftIndex]) {
            root.left = new TreeNode(data[leftIndex]);
            form(root.left, leftIndex, data);
        }

        int rightIndex = 2 * rootIndex + 2;
        if (rightIndex < n && null != data[rightIndex]) {
            root.right = new TreeNode(data[rightIndex]);
            form(root.right, rightIndex, data);
        }
    }
}
